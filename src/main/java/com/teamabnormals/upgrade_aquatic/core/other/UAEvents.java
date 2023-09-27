package com.teamabnormals.upgrade_aquatic.core.other;

import com.teamabnormals.blueprint.core.util.BlockUtil;
import com.teamabnormals.blueprint.core.util.TradeUtil;
import com.teamabnormals.blueprint.core.util.TradeUtil.BlueprintTrade;
import com.teamabnormals.upgrade_aquatic.api.util.UAEntityPredicates;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.Lionfish;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.Pike;
import com.teamabnormals.upgrade_aquatic.core.UAConfig;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.stats.StatsCounter;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = UpgradeAquatic.MOD_ID)
public class UAEvents {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		if (event.getLevel().isClientSide) return;

		Entity entity = event.getEntity();
		if (entity instanceof Drowned drowned) {
			drowned.goalSelector.addGoal(3, new AvoidEntityGoal<>(drowned, Turtle.class, 6.0F, 1.0D, 1.2D));
		}
		if (entity instanceof AbstractFish fish) {
			fish.goalSelector.addGoal(2, new AvoidEntityGoal<>(fish, Pike.class, 8.0F, 1.6D, 1.4D, UAEntityPredicates.IS_HIDING_IN_PICKERELWEED::test));
			if (entity instanceof TropicalFish) {
				fish.goalSelector.addGoal(2, new AvoidEntityGoal<>(fish, Lionfish.class, 8.0F, 1.6D, 1.4D, EntitySelector.ENTITY_STILL_ALIVE::test));
			}
		}
		if (entity instanceof WaterAnimal waterAnimal && !(entity instanceof Enemy)) {
			if (entity instanceof Dolphin dolphin) {
				dolphin.goalSelector.addGoal(1, new MeleeAttackGoal(dolphin, 1.2D, true));
			}
		}
	}

	@SubscribeEvent
	public static void onInteractEntity(EntityInteract event) {
		Entity entity = event.getTarget();
		Player player = event.getEntity();
		ItemStack stack = event.getItemStack();
		if (stack.getItem() == Items.WATER_BUCKET && entity.isAlive() && entity instanceof Squid squid) {
			squid.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
			ItemStack bucket;
			if (squid.getType() == EntityType.SQUID) {
				bucket = new ItemStack(UAItems.SQUID_BUCKET.get());
			} else if (squid.getType() == EntityType.GLOW_SQUID) {
				bucket = new ItemStack(UAItems.GLOW_SQUID_BUCKET.get());
			} else {
				return;
			}

			Bucketable.saveDefaultDataToBucketTag(squid, bucket);
			ItemStack itemstack2 = ItemUtils.createFilledResult(stack, player, bucket, false);
			player.setItemInHand(event.getHand(), itemstack2);
			if (!event.getLevel().isClientSide()) {
				CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, bucket);
			}

			entity.discard();
			event.setCanceled(true);
			event.setCancellationResult(InteractionResult.sidedSuccess(event.getLevel().isClientSide()));
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent event) {
		Player player = event.player;

		ItemStack headSlotStack = player.getItemBySlot(EquipmentSlot.HEAD);
		if (event.phase == Phase.END && player.isEffectiveAi() && !headSlotStack.isEmpty() && headSlotStack.is(Items.TURTLE_HELMET)) {
			int timeTillDamage = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, headSlotStack) > 0 ? 40 * (1 + EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, headSlotStack) / 2) : 40;
			if (player.isEyeInFluid(FluidTags.WATER)) {
				player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100));
				if (player.level.getGameTime() % timeTillDamage == 0) {
					headSlotStack.hurtAndBreak(1, player, (p_213341_0_) -> p_213341_0_.broadcastBreakEvent(EquipmentSlot.HEAD));
				}
			}
		}
	}

	@SubscribeEvent
	public static void onRightClickBlock(RightClickBlock event) {
		Level level = event.getLevel();
		BlockPos pos = event.getPos();
		BlockState state = level.getBlockState(pos);
		Player player = event.getEntity();
		ItemStack stack = event.getItemStack();
		RandomSource random = player.getRandom();

		if (stack.is(Items.GLOW_INK_SAC)) {
			ResourceLocation name = ForgeRegistries.BLOCKS.getKey(state.getBlock());
			String path = name.getPath();
			if ((path.contains("dead") || path.contains("elder")) && path.contains("coral") && !path.contains("coralstone")) {
				Block livingCoral = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(name.getNamespace(), path.replace("dead_", "").replace("elder_", "")));
				if (livingCoral != null) {
					level.setBlockAndUpdate(pos, BlockUtil.transferAllBlockStates(state, livingCoral.defaultBlockState()));
					level.scheduleTick(pos, livingCoral, 60 + level.getRandom().nextInt(40));
					level.playSound(player, pos, SoundEvents.SQUID_SQUIRT, SoundSource.BLOCKS, 1.0F, 1.0F);
					for (int i = 0; i < 5; ++i) {
						double d1 = random.nextGaussian() * 0.02D;
						double d6 = (double) pos.getX() + random.nextDouble();
						double d7 = (double) pos.getY() + random.nextDouble() * state.getShape(level, pos).max(Axis.Y);
						double d8 = (double) pos.getZ() + random.nextDouble();
						level.addParticle(ParticleTypes.GLOW_SQUID_INK, d6, d7, d8, d1, d1, d1);
					}
					if (!player.getAbilities().instabuild) player.getItemInHand(event.getHand()).shrink(1);
					event.setCancellationResult(InteractionResult.sidedSuccess(level.isClientSide()));
					event.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onWandererTradesEvent(WandererTradesEvent event) {
		TradeUtil.addWandererTrades(event, new BlueprintTrade(1, UABlocks.BEACHGRASS.get().asItem(), 1, 12, 1), new BlueprintTrade(1, UABlocks.WHITE_SEAROCKET.get().asItem(), 1, 8, 1), new BlueprintTrade(1, UABlocks.PINK_SEAROCKET.get().asItem(), 1, 8, 1), new BlueprintTrade(1, UABlocks.BLUE_PICKERELWEED.get().asItem(), 1, 8, 1), new BlueprintTrade(1, UABlocks.PURPLE_PICKERELWEED.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.FINGER_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.ACAN_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.BRANCH_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.PILLOW_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.SILK_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.PETAL_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.MOSS_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.ROCK_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.STAR_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(3, UABlocks.CHROME_CORAL_BLOCK.get().asItem(), 1, 8, 1), new BlueprintTrade(5, UABlocks.EMBEDDED_AMMONITE.get().asItem(), 1, 5, 1));

		TradeUtil.addRareWandererTrades(event, new BlueprintTrade(5, UAItems.PIKE_BUCKET.get(), 1, 4, 1), new BlueprintTrade(5, UAItems.LIONFISH_BUCKET.get(), 1, 4, 1), new BlueprintTrade(5, UAItems.NAUTILUS_BUCKET.get(), 1, 4, 1));
	}

	@SubscribeEvent
	public static void onVillagerTradesEvent(VillagerTradesEvent event) {
		if (event.getType().equals(VillagerProfession.FISHERMAN)) {
			TradeUtil.addVillagerTrades(event, TradeUtil.APPRENTICE, new BlueprintTrade(new ItemStack(UAItems.PERCH.get(), 6), new ItemStack(Items.EMERALD), new ItemStack(UAItems.COOKED_PERCH.get(), 6), 16, 5, 0.05F));

			TradeUtil.addVillagerTrades(event, TradeUtil.JOURNEYMAN, new BlueprintTrade(UAItems.PERCH.get(), 14, 1, 16, 20), new BlueprintTrade(new ItemStack(UAItems.PIKE.get(), 6), new ItemStack(Items.EMERALD), new ItemStack(UAItems.COOKED_PIKE.get(), 6), 16, 10, 0.05F));

			TradeUtil.addVillagerTrades(event, TradeUtil.EXPERT, new BlueprintTrade(UAItems.PIKE.get(), 5, 1, 16, 25), new BlueprintTrade(new ItemStack(UAItems.LIONFISH.get(), 6), new ItemStack(Items.EMERALD), new ItemStack(UAItems.COOKED_LIONFISH.get(), 6), 16, 15, 0.05F));

			TradeUtil.addVillagerTrades(event, TradeUtil.MASTER, new BlueprintTrade(UAItems.LIONFISH.get(), 3, 1, 16, 30));
		}
	}
}
