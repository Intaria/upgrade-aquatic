package com.teamabnormals.upgrade_aquatic.core.registry;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.upgrade_aquatic.common.effect.RepellenceMobEffect;
import com.teamabnormals.upgrade_aquatic.common.effect.VibingMobEffect;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UAMobEffects {
	public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, UpgradeAquatic.MOD_ID);
	public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, UpgradeAquatic.MOD_ID);

	public static final RegistryObject<MobEffect> REPELLENCE = MOB_EFFECTS.register("repellence", RepellenceMobEffect::new);
	public static final RegistryObject<MobEffect> VIBING = MOB_EFFECTS.register("vibing", VibingMobEffect::new);

	public static final RegistryObject<Potion> REPELLENCE_NORMAL = POTIONS.register("repellence", () -> new Potion(new MobEffectInstance(REPELLENCE.get(), 3600)));
	public static final RegistryObject<Potion> REPELLENCE_STRONG = POTIONS.register("repellence_strong", () -> new Potion(new MobEffectInstance(REPELLENCE.get(), 1800, 1)));
	public static final RegistryObject<Potion> REPELLENCE_LONG = POTIONS.register("repellence_long", () -> new Potion(new MobEffectInstance(REPELLENCE.get(), 9600)));
	public static final RegistryObject<Potion> VIBING_NORMAL = POTIONS.register("vibing", () -> new Potion(new MobEffectInstance(VIBING.get(), 3600)));
	public static final RegistryObject<Potion> VIBING_STRONG = POTIONS.register("vibing_strong", () -> new Potion(new MobEffectInstance(VIBING.get(), 1800, 1)));
	public static final RegistryObject<Potion> VIBING_LONG = POTIONS.register("vibing_long", () -> new Potion(new MobEffectInstance(VIBING.get(), 9600)));

	public static void registerBrewingRecipes() {
		DataUtil.addMix(Potions.AWKWARD, UAItems.LIONFISH.get(), REPELLENCE_NORMAL.get());
		DataUtil.addMix(REPELLENCE_NORMAL.get(), Items.GLOWSTONE_DUST, REPELLENCE_STRONG.get());
		DataUtil.addMix(REPELLENCE_NORMAL.get(), Items.REDSTONE, REPELLENCE_LONG.get());
		DataUtil.addMix(REPELLENCE_NORMAL.get(), Items.FERMENTED_SPIDER_EYE, VIBING_NORMAL.get());
		DataUtil.addMix(VIBING_NORMAL.get(), Items.GLOWSTONE_DUST, VIBING_STRONG.get());
		DataUtil.addMix(VIBING_NORMAL.get(), Items.REDSTONE, VIBING_LONG.get());
	}
}