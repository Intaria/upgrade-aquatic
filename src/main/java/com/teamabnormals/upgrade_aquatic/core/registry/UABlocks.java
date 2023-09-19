package com.teamabnormals.upgrade_aquatic.core.registry;

import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.blueprint.common.block.*;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintStandingSignBlock;
import com.teamabnormals.blueprint.common.block.sign.BlueprintWallSignBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchSlabBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchStairBlock;
import com.teamabnormals.blueprint.common.block.thatch.ThatchVerticalSlabBlock;
import com.teamabnormals.blueprint.common.block.wood.*;
import com.teamabnormals.blueprint.core.util.PropertyUtil;
import com.teamabnormals.blueprint.core.util.PropertyUtil.WoodSetProperties;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.upgrade_aquatic.common.block.*;
import com.teamabnormals.upgrade_aquatic.common.block.coralstone.*;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.function.Supplier;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class UABlocks {
	public static final BlockSubRegistryHelper HELPER = UpgradeAquatic.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> EMBEDDED_AMMONITE = HELPER.createBlock("embedded_ammonite", () -> new EmbeddedAmmoniteBlock(Properties.copy(Blocks.STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> WHITE_SEAROCKET = HELPER.createBlock("white_searocket", () -> new SearocketBlock(() -> MobEffects.WATER_BREATHING, 9, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PINK_SEAROCKET = HELPER.createBlock("pink_searocket", () -> new SearocketBlock(() -> MobEffects.WATER_BREATHING, 9, PropertyUtil.flower()), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> FLOWERING_RUSH = HELPER.createBlock("flowering_rush", () -> new FloweringRushBlock(Properties.copy(Blocks.PEONY).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> BLUE_PICKERELWEED = HELPER.createBlock("blue_pickerelweed", () -> new PickerelweedPlantBlock(UAProperties.PICKERELWEED), CreativeModeTab.TAB_MISC);
	public static final RegistryObject<Block> TALL_BLUE_PICKERELWEED = HELPER.createBlockNoItem("tall_blue_pickerelweed", () -> new PickerelweedDoublePlantBlock(UAProperties.PICKERELWEED));
	public static final RegistryObject<Block> PURPLE_PICKERELWEED = HELPER.createBlock("purple_pickerelweed", () -> new PickerelweedPlantBlock(UAProperties.PICKERELWEED), CreativeModeTab.TAB_MISC);
	public static final RegistryObject<Block> TALL_PURPLE_PICKERELWEED = HELPER.createBlockNoItem("tall_purple_pickerelweed", () -> new PickerelweedDoublePlantBlock(UAProperties.PICKERELWEED));

	public static final RegistryObject<Block> BLUE_PICKERELWEED_BLOCK = HELPER.createBlock("blue_pickerelweed_block", () -> new PickerelweedBlock(UAProperties.createPickerelweedBlock(false), false), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PURPLE_PICKERELWEED_BLOCK = HELPER.createBlock("purple_pickerelweed_block", () -> new PickerelweedBlock(UAProperties.createPickerelweedBlock(false), false), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOILED_BLUE_PICKERELWEED_BLOCK = HELPER.createBlock("boiled_blue_pickerelweed_block", () -> new PickerelweedBlock(UAProperties.createPickerelweedBlock(true), true), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BOILED_PURPLE_PICKERELWEED_BLOCK = HELPER.createBlock("boiled_purple_pickerelweed_block", () -> new PickerelweedBlock(UAProperties.createPickerelweedBlock(true), true), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> POTTED_WHITE_SEAROCKET = HELPER.createBlockNoItem("potted_white_searocket", () -> new FlowerPotBlock(WHITE_SEAROCKET.get(), PropertyUtil.flowerPot()));
	public static final RegistryObject<Block> POTTED_PINK_SEAROCKET = HELPER.createBlockNoItem("potted_pink_searocket", () -> new FlowerPotBlock(PINK_SEAROCKET.get(), PropertyUtil.flowerPot()));
	public static final RegistryObject<Block> POTTED_BLUE_PICKERELWEED = HELPER.createBlockNoItem("potted_blue_pickerelweed", () -> new FlowerPotBlock(BLUE_PICKERELWEED.get(), PropertyUtil.flowerPot()));
	public static final RegistryObject<Block> POTTED_PURPLE_PICKERELWEED = HELPER.createBlockNoItem("potted_purple_pickerelweed", () -> new FlowerPotBlock(PURPLE_PICKERELWEED.get(), PropertyUtil.flowerPot()));

	public static final RegistryObject<Block> BEACHGRASS = HELPER.createBlock("beachgrass", () -> new BeachgrassBlock(Properties.copy(Blocks.FERN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> TALL_BEACHGRASS = HELPER.createBlock("tall_beachgrass", () -> new TallBeachgrassBlock(Properties.copy(Blocks.LARGE_FERN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BEACHGRASS_THATCH = HELPER.createBlock("beachgrass_thatch", () -> new ThatchBlock(UAProperties.BEACHGRASS_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BEACHGRASS_THATCH_SLAB = HELPER.createBlock("beachgrass_thatch_slab", () -> new ThatchSlabBlock(UAProperties.BEACHGRASS_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BEACHGRASS_THATCH_STAIRS = HELPER.createBlock("beachgrass_thatch_stairs", () -> new ThatchStairBlock(BEACHGRASS_THATCH.get().defaultBlockState(), UAProperties.BEACHGRASS_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BEACHGRASS_THATCH_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "beachgrass_thatch_vertical_slab", () -> new ThatchVerticalSlabBlock(UAProperties.BEACHGRASS_THATCH), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> PRISMARINE_ROD_BUNDLE = HELPER.createBlock("prismarine_rod_bundle", () -> new PrismarineRodBlock(Properties.copy(Blocks.PRISMARINE_BRICKS).sound(SoundType.METAL)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LUMINOUS_PRISMARINE = HELPER.createBlock("luminous_prismarine", () -> new ConduitFrameBlock(UAProperties.LUMINOUS_PRISMARINE), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LUMINOUS_PRISMARINE_STAIRS = HELPER.createBlock("luminous_prismarine_stairs", () -> new StairBlock(() -> LUMINOUS_PRISMARINE.get().defaultBlockState(), UAProperties.LUMINOUS_PRISMARINE), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LUMINOUS_PRISMARINE_SLAB = HELPER.createBlock("luminous_prismarine_slab", () -> new SlabBlock(UAProperties.LUMINOUS_PRISMARINE), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> LUMINOUS_PRISMARINE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "luminous_prismarine_vertical_slab", () -> new VerticalSlabBlock(UAProperties.LUMINOUS_PRISMARINE), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> GLASS_TRAPDOOR = HELPER.createBlock("glass_trapdoor", () -> new TrapDoorBlock(Properties.copy(Blocks.GLASS)), CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Block> GLASS_DOOR = HELPER.createBlock("glass_door", () -> new DoorBlock(Properties.copy(Blocks.GLASS)), CreativeModeTab.TAB_REDSTONE);

	public static final RegistryObject<Block> SCUTE_BLOCK = HELPER.createBlock("scute_block", () -> new ScuteBlock(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_SHINGLES = HELPER.createBlock("scute_shingles", () -> new Block(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_SHINGLE_STAIRS = HELPER.createBlock("scute_shingle_stairs", () -> new StairBlock(() -> SCUTE_BLOCK.get().defaultBlockState(), Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_SHINGLE_SLAB = HELPER.createBlock("scute_shingle_slab", () -> new SlabBlock(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_SHINGLE_WALL = HELPER.createBlock("scute_shingle_wall", () -> new WallBlock(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> SCUTE_SHINGLE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "scute_shingle_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(SCUTE_SHINGLES.get())), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_SCUTE_SHINGLES = HELPER.createBlock("chiseled_scute_shingles", () -> new Block(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_PAVEMENT = HELPER.createBlock("scute_pavement", () -> new Block(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_PAVEMENT_STAIRS = HELPER.createBlock("scute_pavement_stairs", () -> new StairBlock(() -> SCUTE_BLOCK.get().defaultBlockState(), Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_PAVEMENT_SLAB = HELPER.createBlock("scute_pavement_slab", () -> new SlabBlock(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SCUTE_PAVEMENT_WALL = HELPER.createBlock("scute_pavement_wall", () -> new WallBlock(Properties.copy(Blocks.END_STONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> SCUTE_PAVEMENT_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "scute_pavement_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(SCUTE_PAVEMENT.get())), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> DEAD_ACAN_CORAL_BLOCK = HELPER.createBlock("dead_acan_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_FINGER_CORAL_BLOCK = HELPER.createBlock("dead_finger_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_STAR_CORAL_BLOCK = HELPER.createBlock("dead_star_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_MOSS_CORAL_BLOCK = HELPER.createBlock("dead_moss_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_PETAL_CORAL_BLOCK = HELPER.createBlock("dead_petal_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_BRANCH_CORAL_BLOCK = HELPER.createBlock("dead_branch_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_ROCK_CORAL_BLOCK = HELPER.createBlock("dead_rock_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_PILLOW_CORAL_BLOCK = HELPER.createBlock("dead_pillow_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_SILK_CORAL_BLOCK = HELPER.createBlock("dead_silk_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CHROME_CORAL_BLOCK = HELPER.createBlock("dead_chrome_coral_block", () -> new InjectedBlock(Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), UAProperties.DEAD_CORAL_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORAL_BLOCK = HELPER.createInjectedBlock("elder_prismarine_coral_block", Blocks.DEAD_HORN_CORAL_BLOCK.asItem(), () -> new ConduitFrameBlock(UAProperties.createPrismarineCoralBlock(true)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> ACAN_CORAL_BLOCK = HELPER.createInjectedBlock("acan_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_ACAN_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_CYAN)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CORAL_BLOCK = HELPER.createInjectedBlock("finger_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_FINGER_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.TERRACOTTA_ORANGE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CORAL_BLOCK = HELPER.createInjectedBlock("star_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_STAR_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_LIGHT_GREEN)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CORAL_BLOCK = HELPER.createInjectedBlock("moss_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_MOSS_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_GREEN)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CORAL_BLOCK = HELPER.createInjectedBlock("petal_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_PETAL_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_LIGHT_BLUE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CORAL_BLOCK = HELPER.createInjectedBlock("branch_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_BRANCH_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.TERRACOTTA_GRAY)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CORAL_BLOCK = HELPER.createInjectedBlock("rock_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_ROCK_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_BROWN)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CORAL_BLOCK = HELPER.createInjectedBlock("pillow_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_PILLOW_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.TERRACOTTA_WHITE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CORAL_BLOCK = HELPER.createInjectedBlock("silk_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_SILK_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.COLOR_PURPLE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CORAL_BLOCK = HELPER.createInjectedBlock("chrome_coral_block", Blocks.HORN_CORAL_BLOCK.asItem(), () -> new CoralBlock(DEAD_CHROME_CORAL_BLOCK.get(), UAProperties.createCoralBlock(MaterialColor.TERRACOTTA_GRAY)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CORAL_BLOCK = HELPER.createBlock("prismarine_coral_block", () -> new PrismarineCoralBlock(ELDER_PRISMARINE_CORAL_BLOCK.get(), UAProperties.createPrismarineCoralBlock(false)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> DEAD_ACAN_CORAL = HELPER.createBlock("dead_acan_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_FINGER_CORAL = HELPER.createBlock("dead_finger_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_STAR_CORAL = HELPER.createBlock("dead_star_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_MOSS_CORAL = HELPER.createBlock("dead_moss_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_PETAL_CORAL = HELPER.createBlock("dead_petal_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_BRANCH_CORAL = HELPER.createBlock("dead_branch_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_ROCK_CORAL = HELPER.createBlock("dead_rock_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_PILLOW_CORAL = HELPER.createBlock("dead_pillow_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_SILK_CORAL = HELPER.createBlock("dead_silk_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_CHROME_CORAL = HELPER.createBlock("dead_chrome_coral", () -> new UABaseCoralPlantBlock(UAProperties.DEAD_CORAL), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORAL = HELPER.createBlock("elder_prismarine_coral", () -> new UABaseCoralPlantBlock(UAProperties.createPrismarineCoral(true)), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> ACAN_CORAL = HELPER.createInjectedBlock("acan_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_ACAN_CORAL.get(), UAProperties.createCoral(MaterialColor.COLOR_CYAN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> FINGER_CORAL = HELPER.createInjectedBlock("finger_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_FINGER_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_ORANGE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> STAR_CORAL = HELPER.createInjectedBlock("star_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_STAR_CORAL.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_GREEN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MOSS_CORAL = HELPER.createInjectedBlock("moss_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_MOSS_CORAL.get(), UAProperties.createCoral(MaterialColor.COLOR_GREEN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PETAL_CORAL = HELPER.createInjectedBlock("petal_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_PETAL_CORAL.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_BLUE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BRANCH_CORAL = HELPER.createInjectedBlock("branch_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_BRANCH_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ROCK_CORAL = HELPER.createInjectedBlock("rock_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_ROCK_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_BROWN)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PILLOW_CORAL = HELPER.createInjectedBlock("pillow_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_PILLOW_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_WHITE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> SILK_CORAL = HELPER.createInjectedBlock("silk_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_SILK_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_PURPLE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CHROME_CORAL = HELPER.createInjectedBlock("chrome_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(DEAD_CHROME_CORAL.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PRISMARINE_CORAL = HELPER.createInjectedBlock("prismarine_coral", Blocks.HORN_CORAL.asItem(), () -> new UACoralPlantBlock(ELDER_PRISMARINE_CORAL.get(), UAProperties.createPrismarineCoral(false)), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> DEAD_ACAN_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_acan_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_FINGER_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_finger_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_STAR_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_star_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_MOSS_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_moss_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_PETAL_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_petal_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_BRANCH_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_branch_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_ROCK_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_rock_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_PILLOW_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_pillow_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_SILK_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_silk_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> DEAD_CHROME_CORAL_WALL_FAN = HELPER.createBlockNoItem("dead_chrome_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.DEAD_CORAL));
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORAL_WALL_FAN = HELPER.createBlockNoItem("elder_prismarine_coral_wall_fan", () -> new BaseCoralWallFanBlock(UAProperties.createPrismarineCoral(true)));

	public static final RegistryObject<Block> ACAN_CORAL_WALL_FAN = HELPER.createBlockNoItem("acan_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_ACAN_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_CYAN)));
	public static final RegistryObject<Block> FINGER_CORAL_WALL_FAN = HELPER.createBlockNoItem("finger_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_FINGER_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_ORANGE)));
	public static final RegistryObject<Block> STAR_CORAL_WALL_FAN = HELPER.createBlockNoItem("star_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_STAR_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_GREEN)));
	public static final RegistryObject<Block> MOSS_CORAL_WALL_FAN = HELPER.createBlockNoItem("moss_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_MOSS_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_GREEN)));
	public static final RegistryObject<Block> PETAL_CORAL_WALL_FAN = HELPER.createBlockNoItem("petal_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_PETAL_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_BLUE)));
	public static final RegistryObject<Block> BRANCH_CORAL_WALL_FAN = HELPER.createBlockNoItem("branch_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_BRANCH_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)));
	public static final RegistryObject<Block> ROCK_CORAL_WALL_FAN = HELPER.createBlockNoItem("rock_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_ROCK_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_BROWN)));
	public static final RegistryObject<Block> PILLOW_CORAL_WALL_FAN = HELPER.createBlockNoItem("pillow_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_PILLOW_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_WHITE)));
	public static final RegistryObject<Block> SILK_CORAL_WALL_FAN = HELPER.createBlockNoItem("silk_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_SILK_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_PURPLE)));
	public static final RegistryObject<Block> CHROME_CORAL_WALL_FAN = HELPER.createBlockNoItem("chrome_coral_wall_fan", () -> new CoralWallFanBlock(DEAD_CHROME_CORAL_WALL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)));
	public static final RegistryObject<Block> PRISMARINE_CORAL_WALL_FAN = HELPER.createBlockNoItem("prismarine_coral_wall_fan", () -> new CoralWallFanBlock(ELDER_PRISMARINE_CORAL_WALL_FAN.get(), UAProperties.createPrismarineCoral(false)));

	public static final RegistryObject<Block> DEAD_ACAN_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_acan_coral_fan", UABaseCoralFanBlock::new, DEAD_ACAN_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_FINGER_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_finger_coral_fan", UABaseCoralFanBlock::new, DEAD_FINGER_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_STAR_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_star_coral_fan", UABaseCoralFanBlock::new, DEAD_STAR_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_MOSS_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_moss_coral_fan", UABaseCoralFanBlock::new, DEAD_MOSS_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_PETAL_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_petal_coral_fan", UABaseCoralFanBlock::new, DEAD_PETAL_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_BRANCH_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_branch_coral_fan", UABaseCoralFanBlock::new, DEAD_BRANCH_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_ROCK_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_rock_coral_fan", UABaseCoralFanBlock::new, DEAD_ROCK_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_PILLOW_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_pillow_coral_fan", UABaseCoralFanBlock::new, DEAD_PILLOW_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_SILK_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_silk_coral_fan", UABaseCoralFanBlock::new, DEAD_SILK_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_CHROME_CORAL_FAN = HELPER.createStandingAndWallBlock("dead_chrome_coral_fan", UABaseCoralFanBlock::new, DEAD_CHROME_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORAL_FAN = HELPER.createStandingAndWallBlock("elder_prismarine_coral_fan", () -> new UABaseCoralFanBlock(UAProperties.createPrismarineCoral(true)), ELDER_PRISMARINE_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> ACAN_CORAL_FAN = HELPER.createStandingAndWallBlock("acan_coral_fan", () -> new UACoralFanBlock(DEAD_ACAN_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_CYAN)), ACAN_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> FINGER_CORAL_FAN = HELPER.createStandingAndWallBlock("finger_coral_fan", () -> new UACoralFanBlock(DEAD_FINGER_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_ORANGE)), FINGER_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> STAR_CORAL_FAN = HELPER.createStandingAndWallBlock("star_coral_fan", () -> new UACoralFanBlock(DEAD_STAR_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_GREEN)), STAR_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MOSS_CORAL_FAN = HELPER.createStandingAndWallBlock("moss_coral_fan", () -> new UACoralFanBlock(DEAD_MOSS_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_GREEN)), MOSS_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PETAL_CORAL_FAN = HELPER.createStandingAndWallBlock("petal_coral_fan", () -> new UACoralFanBlock(DEAD_PETAL_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.COLOR_LIGHT_BLUE)), PETAL_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BRANCH_CORAL_FAN = HELPER.createStandingAndWallBlock("branch_coral_fan", () -> new UACoralFanBlock(DEAD_BRANCH_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)), BRANCH_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ROCK_CORAL_FAN = HELPER.createStandingAndWallBlock("rock_coral_fan", () -> new UACoralFanBlock(DEAD_ROCK_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_BROWN)), ROCK_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PILLOW_CORAL_FAN = HELPER.createStandingAndWallBlock("pillow_coral_fan", () -> new UACoralFanBlock(DEAD_PILLOW_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_WHITE)), PILLOW_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> SILK_CORAL_FAN = HELPER.createStandingAndWallBlock("silk_coral_fan", () -> new UACoralFanBlock(DEAD_SILK_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_PURPLE)), SILK_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CHROME_CORAL_FAN = HELPER.createStandingAndWallBlock("chrome_coral_fan", () -> new UACoralFanBlock(DEAD_CHROME_CORAL_FAN.get(), UAProperties.createCoral(MaterialColor.TERRACOTTA_GRAY)), CHROME_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PRISMARINE_CORAL_FAN = HELPER.createStandingAndWallBlock("prismarine_coral_fan", () -> new UACoralFanBlock(ELDER_PRISMARINE_CORAL_FAN.get(), UAProperties.createPrismarineCoral(false)), PRISMARINE_CORAL_WALL_FAN, CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> ELDER_PRISMARINE_CORAL_SHOWER = HELPER.createBlock("elder_prismarine_coral_shower", () -> new DeadCoralShowerBlock(UAProperties.createPrismarineCoral(true)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PRISMARINE_CORAL_SHOWER = HELPER.createBlock("prismarine_coral_shower", () -> new CoralShowerBlock(ELDER_PRISMARINE_CORAL_SHOWER.get(), UAProperties.createPrismarineCoral(false)), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> ELDER_EYE = HELPER.createRareBlock("elder_eye", () -> new ElderEyeBlock(UAProperties.ELDER_EYE), Rarity.RARE, CreativeModeTab.TAB_REDSTONE);

	public static final RegistryObject<Block> CORALSTONE = HELPER.createBlock("coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BUBBLE_CORALSTONE = HELPER.createBlock("bubble_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{Blocks.BUBBLE_CORAL, Blocks.BUBBLE_CORAL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> HORN_CORALSTONE = HELPER.createBlock("horn_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{Blocks.HORN_CORAL, Blocks.HORN_CORAL_FAN, Blocks.HORN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TUBE_CORALSTONE = HELPER.createBlock("tube_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{Blocks.TUBE_CORAL, Blocks.TUBE_CORAL_FAN, Blocks.TUBE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRAIN_CORALSTONE = HELPER.createBlock("brain_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{Blocks.BRAIN_CORAL, Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FIRE_CORALSTONE = HELPER.createBlock("fire_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{Blocks.FIRE_CORAL, Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ACAN_CORALSTONE = HELPER.createBlock("acan_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{ACAN_CORAL.get(), ACAN_CORAL_FAN.get(), ACAN_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CORALSTONE = HELPER.createBlock("finger_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{FINGER_CORAL.get(), FINGER_CORAL_FAN.get(), FINGER_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CORALSTONE = HELPER.createBlock("star_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{STAR_CORAL.get(), STAR_CORAL_FAN.get(), STAR_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CORALSTONE = HELPER.createBlock("moss_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{MOSS_CORAL.get(), MOSS_CORAL_FAN.get(), MOSS_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CORALSTONE = HELPER.createBlock("petal_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{PETAL_CORAL.get(), PETAL_CORAL_FAN.get(), PETAL_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CORALSTONE = HELPER.createBlock("branch_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{BRANCH_CORAL.get(), BRANCH_CORAL_FAN.get(), BRANCH_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CORALSTONE = HELPER.createBlock("rock_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{ROCK_CORAL.get(), ROCK_CORAL_FAN.get(), ROCK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CORALSTONE = HELPER.createBlock("pillow_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{PILLOW_CORAL.get(), PILLOW_CORAL_FAN.get(), PILLOW_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CORALSTONE = HELPER.createBlock("silk_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{SILK_CORAL.get(), SILK_CORAL_FAN.get(), SILK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CORALSTONE = HELPER.createBlock("chrome_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{CHROME_CORAL.get(), CHROME_CORAL_FAN.get(), CHROME_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CORALSTONE = HELPER.createBlock("prismarine_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false, new Block[]{PRISMARINE_CORAL.get(), PRISMARINE_CORAL_FAN.get(), PRISMARINE_CORAL_WALL_FAN.get(), PRISMARINE_CORAL_SHOWER.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORALSTONE = HELPER.createBlock("elder_prismarine_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CORALSTONE = HELPER.createBlock("dead_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, false), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> CHISELED_CORALSTONE = HELPER.createBlock("chiseled_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BUBBLE_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_bubble_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{Blocks.BUBBLE_CORAL, Blocks.BUBBLE_CORAL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> HORN_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_horn_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{Blocks.HORN_CORAL, Blocks.HORN_CORAL_FAN, Blocks.HORN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TUBE_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_tube_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{Blocks.TUBE_CORAL, Blocks.TUBE_CORAL_FAN, Blocks.TUBE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRAIN_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_brain_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{Blocks.BRAIN_CORAL, Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FIRE_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_fire_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{Blocks.FIRE_CORAL, Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ACAN_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_acan_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{ACAN_CORAL.get(), ACAN_CORAL_FAN.get(), ACAN_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_finger_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{FINGER_CORAL.get(), FINGER_CORAL_FAN.get(), FINGER_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_star_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{STAR_CORAL.get(), STAR_CORAL_FAN.get(), STAR_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_moss_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{MOSS_CORAL.get(), MOSS_CORAL_FAN.get(), MOSS_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_petal_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{PETAL_CORAL.get(), PETAL_CORAL_FAN.get(), PETAL_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_branch_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{BRANCH_CORAL.get(), BRANCH_CORAL_FAN.get(), BRANCH_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_rock_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{ROCK_CORAL.get(), ROCK_CORAL_FAN.get(), ROCK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_pillow_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{PILLOW_CORAL.get(), PILLOW_CORAL_FAN.get(), PILLOW_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_silk_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{SILK_CORAL.get(), SILK_CORAL_FAN.get(), SILK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_chrome_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{CHROME_CORAL.get(), CHROME_CORAL_FAN.get(), CHROME_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_prismarine_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true, new Block[]{PRISMARINE_CORAL.get(), PRISMARINE_CORAL_FAN.get(), PRISMARINE_CORAL_WALL_FAN.get(), PRISMARINE_CORAL_SHOWER.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHISELED_ELDER_PRISMARINE_CORALSTONE = HELPER.createBlock("chiseled_elder_prismarine_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CHISELED_CORALSTONE = HELPER.createBlock("chiseled_dead_coralstone", () -> new CoralstoneBlock(UAProperties.CORALSTONE, true), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> CORALSTONE_SLAB = HELPER.createBlock("coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BUBBLE_CORALSTONE_SLAB = HELPER.createBlock("bubble_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.BUBBLE_CORAL, Blocks.BUBBLE_CORAL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> HORN_CORALSTONE_SLAB = HELPER.createBlock("horn_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.HORN_CORAL, Blocks.HORN_CORAL_FAN, Blocks.HORN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TUBE_CORALSTONE_SLAB = HELPER.createBlock("tube_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.TUBE_CORAL, Blocks.TUBE_CORAL_FAN, Blocks.TUBE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRAIN_CORALSTONE_SLAB = HELPER.createBlock("brain_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.BRAIN_CORAL, Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FIRE_CORALSTONE_SLAB = HELPER.createBlock("fire_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.FIRE_CORAL, Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ACAN_CORALSTONE_SLAB = HELPER.createBlock("acan_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{ACAN_CORAL.get(), ACAN_CORAL_FAN.get(), ACAN_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CORALSTONE_SLAB = HELPER.createBlock("finger_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{FINGER_CORAL.get(), FINGER_CORAL_FAN.get(), FINGER_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CORALSTONE_SLAB = HELPER.createBlock("star_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{STAR_CORAL.get(), STAR_CORAL_FAN.get(), STAR_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CORALSTONE_SLAB = HELPER.createBlock("moss_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{MOSS_CORAL.get(), MOSS_CORAL_FAN.get(), MOSS_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CORALSTONE_SLAB = HELPER.createBlock("petal_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{PETAL_CORAL.get(), PETAL_CORAL_FAN.get(), PETAL_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CORALSTONE_SLAB = HELPER.createBlock("branch_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{BRANCH_CORAL.get(), BRANCH_CORAL_FAN.get(), BRANCH_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CORALSTONE_SLAB = HELPER.createBlock("rock_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{ROCK_CORAL.get(), ROCK_CORAL_FAN.get(), ROCK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CORALSTONE_SLAB = HELPER.createBlock("pillow_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{PILLOW_CORAL.get(), PILLOW_CORAL_FAN.get(), PILLOW_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CORALSTONE_SLAB = HELPER.createBlock("silk_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{SILK_CORAL.get(), SILK_CORAL_FAN.get(), SILK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CORALSTONE_SLAB = HELPER.createBlock("chrome_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{CHROME_CORAL.get(), CHROME_CORAL_FAN.get(), CHROME_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CORALSTONE_SLAB = HELPER.createBlock("prismarine_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, new Block[]{PRISMARINE_CORAL.get(), PRISMARINE_CORAL_FAN.get(), PRISMARINE_CORAL_WALL_FAN.get(), PRISMARINE_CORAL_SHOWER.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORALSTONE_SLAB = HELPER.createBlock("elder_prismarine_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CORALSTONE_SLAB = HELPER.createBlock("dead_coralstone_slab", () -> new CoralstoneSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> CORALSTONE_STAIRS = HELPER.createBlock("coralstone_stairs", () -> new CoralstoneStairsBlock(() -> CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BUBBLE_CORALSTONE_STAIRS = HELPER.createBlock("bubble_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> BUBBLE_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{Blocks.BUBBLE_CORAL, Blocks.BUBBLE_CORAL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> HORN_CORALSTONE_STAIRS = HELPER.createBlock("horn_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> HORN_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{Blocks.HORN_CORAL, Blocks.HORN_CORAL_FAN, Blocks.HORN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TUBE_CORALSTONE_STAIRS = HELPER.createBlock("tube_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> TUBE_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{Blocks.TUBE_CORAL, Blocks.TUBE_CORAL_FAN, Blocks.TUBE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRAIN_CORALSTONE_STAIRS = HELPER.createBlock("brain_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> BRAIN_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{Blocks.BRAIN_CORAL, Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FIRE_CORALSTONE_STAIRS = HELPER.createBlock("fire_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> FIRE_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{Blocks.FIRE_CORAL, Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ACAN_CORALSTONE_STAIRS = HELPER.createBlock("acan_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> ACAN_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{ACAN_CORAL.get(), ACAN_CORAL_FAN.get(), ACAN_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CORALSTONE_STAIRS = HELPER.createBlock("finger_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> FINGER_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{FINGER_CORAL.get(), FINGER_CORAL_FAN.get(), FINGER_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CORALSTONE_STAIRS = HELPER.createBlock("star_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> STAR_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{STAR_CORAL.get(), STAR_CORAL_FAN.get(), STAR_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CORALSTONE_STAIRS = HELPER.createBlock("moss_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> MOSS_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{MOSS_CORAL.get(), MOSS_CORAL_FAN.get(), MOSS_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CORALSTONE_STAIRS = HELPER.createBlock("petal_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> PETAL_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{PETAL_CORAL.get(), PETAL_CORAL_FAN.get(), PETAL_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CORALSTONE_STAIRS = HELPER.createBlock("branch_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> BRANCH_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{BRANCH_CORAL.get(), BRANCH_CORAL_FAN.get(), BRANCH_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CORALSTONE_STAIRS = HELPER.createBlock("rock_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> ROCK_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{ROCK_CORAL.get(), ROCK_CORAL_FAN.get(), ROCK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CORALSTONE_STAIRS = HELPER.createBlock("pillow_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> PILLOW_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{PILLOW_CORAL.get(), PILLOW_CORAL_FAN.get(), PILLOW_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CORALSTONE_STAIRS = HELPER.createBlock("silk_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> SILK_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{SILK_CORAL.get(), SILK_CORAL_FAN.get(), SILK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CORALSTONE_STAIRS = HELPER.createBlock("chrome_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> CHROME_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{CHROME_CORAL.get(), CHROME_CORAL_FAN.get(), CHROME_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CORALSTONE_STAIRS = HELPER.createBlock("prismarine_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> PRISMARINE_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, new Block[]{PRISMARINE_CORAL.get(), PRISMARINE_CORAL_FAN.get(), PRISMARINE_CORAL_WALL_FAN.get(), PRISMARINE_CORAL_SHOWER.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORALSTONE_STAIRS = HELPER.createBlock("elder_prismarine_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> ELDER_PRISMARINE_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CORALSTONE_STAIRS = HELPER.createBlock("dead_coralstone_stairs", () -> new CoralstoneStairsBlock(() -> DEAD_CORALSTONE.get().defaultBlockState(), UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> CORALSTONE_WALL = HELPER.createBlock("coralstone_wall", () -> new CoralstoneWallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BUBBLE_CORALSTONE_WALL = HELPER.createBlock("bubble_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> HORN_CORALSTONE_WALL = HELPER.createBlock("horn_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> TUBE_CORALSTONE_WALL = HELPER.createBlock("tube_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BRAIN_CORALSTONE_WALL = HELPER.createBlock("brain_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> FIRE_CORALSTONE_WALL = HELPER.createBlock("fire_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ACAN_CORALSTONE_WALL = HELPER.createBlock("acan_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> FINGER_CORALSTONE_WALL = HELPER.createBlock("finger_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> STAR_CORALSTONE_WALL = HELPER.createBlock("star_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MOSS_CORALSTONE_WALL = HELPER.createBlock("moss_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PETAL_CORALSTONE_WALL = HELPER.createBlock("petal_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> BRANCH_CORALSTONE_WALL = HELPER.createBlock("branch_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ROCK_CORALSTONE_WALL = HELPER.createBlock("rock_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PILLOW_CORALSTONE_WALL = HELPER.createBlock("pillow_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> SILK_CORALSTONE_WALL = HELPER.createBlock("silk_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CHROME_CORALSTONE_WALL = HELPER.createBlock("chrome_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> PRISMARINE_CORALSTONE_WALL = HELPER.createBlock("prismarine_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORALSTONE_WALL = HELPER.createBlock("elder_prismarine_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DEAD_CORALSTONE_WALL = HELPER.createBlock("dead_coralstone_wall", () -> new WallBlock(UAProperties.CORALSTONE), CreativeModeTab.TAB_DECORATIONS);

	public static final RegistryObject<Block> CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BUBBLE_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "bubble_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.BUBBLE_CORAL, Blocks.BUBBLE_CORAL_FAN, Blocks.BUBBLE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> HORN_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "horn_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.HORN_CORAL, Blocks.HORN_CORAL_FAN, Blocks.HORN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TUBE_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "tube_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.TUBE_CORAL, Blocks.TUBE_CORAL_FAN, Blocks.TUBE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRAIN_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "brain_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.BRAIN_CORAL, Blocks.BRAIN_CORAL_FAN, Blocks.BRAIN_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FIRE_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "fire_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{Blocks.FIRE_CORAL, Blocks.FIRE_CORAL_FAN, Blocks.FIRE_CORAL_WALL_FAN}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ACAN_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "acan_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{ACAN_CORAL.get(), ACAN_CORAL_FAN.get(), ACAN_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> FINGER_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "finger_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{FINGER_CORAL.get(), FINGER_CORAL_FAN.get(), FINGER_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> STAR_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "star_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{STAR_CORAL.get(), STAR_CORAL_FAN.get(), STAR_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> MOSS_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "moss_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{MOSS_CORAL.get(), MOSS_CORAL_FAN.get(), MOSS_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PETAL_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "petal_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{PETAL_CORAL.get(), PETAL_CORAL_FAN.get(), PETAL_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> BRANCH_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "branch_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{BRANCH_CORAL.get(), BRANCH_CORAL_FAN.get(), BRANCH_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ROCK_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "rock_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{ROCK_CORAL.get(), ROCK_CORAL_FAN.get(), ROCK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PILLOW_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "pillow_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{PILLOW_CORAL.get(), PILLOW_CORAL_FAN.get(), PILLOW_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> SILK_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "silk_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{SILK_CORAL.get(), SILK_CORAL_FAN.get(), SILK_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> CHROME_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "chrome_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{CHROME_CORAL.get(), CHROME_CORAL_FAN.get(), CHROME_CORAL_WALL_FAN.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> PRISMARINE_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "prismarine_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, new Block[]{PRISMARINE_CORAL.get(), PRISMARINE_CORAL_FAN.get(), PRISMARINE_CORAL_WALL_FAN.get(), PRISMARINE_CORAL_SHOWER.get()}), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> ELDER_PRISMARINE_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "elder_prismarine_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> DEAD_CORALSTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "dead_coralstone_vertical_slab", () -> new CoralstoneVerticalSlabBlock(UAProperties.CORALSTONE, null), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TONGUE_KELP = HELPER.createBlock("tongue_kelp", () -> new UAKelpBlock(KelpType.TONGUE, Properties.copy(Blocks.KELP)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> THORNY_KELP = HELPER.createBlock("thorny_kelp", () -> new UAKelpBlock(KelpType.THORNY, Properties.copy(Blocks.KELP)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> OCHRE_KELP = HELPER.createBlock("ochre_kelp", () -> new UAKelpBlock(KelpType.OCHRE, Properties.copy(Blocks.KELP)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> POLAR_KELP = HELPER.createBlock("polar_kelp", () -> new UAKelpBlock(KelpType.POLAR, Properties.copy(Blocks.KELP)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> TONGUE_KELP_PLANT = HELPER.createBlockNoItem("tongue_kelp_plant", () -> new UAKelpPlantBlock(KelpType.TONGUE, Properties.copy(Blocks.KELP_PLANT)));
	public static final RegistryObject<Block> THORNY_KELP_PLANT = HELPER.createBlockNoItem("thorny_kelp_plant", () -> new UAKelpPlantBlock(KelpType.THORNY, Properties.copy(Blocks.KELP_PLANT)));
	public static final RegistryObject<Block> OCHRE_KELP_PLANT = HELPER.createBlockNoItem("ochre_kelp_plant", () -> new UAKelpPlantBlock(KelpType.OCHRE, Properties.copy(Blocks.KELP_PLANT)));
	public static final RegistryObject<Block> POLAR_KELP_PLANT = HELPER.createBlockNoItem("polar_kelp_plant", () -> new UAKelpPlantBlock(KelpType.POLAR, Properties.copy(Blocks.KELP_PLANT)));

	public static final RegistryObject<Block> KELP_BLOCK = HELPER.createBlock("kelp_block", () -> new Block(Properties.copy(Blocks.DRIED_KELP_BLOCK).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELP_BLOCK = HELPER.createBlock("tongue_kelp_block", () -> new Block(Properties.copy(Blocks.DRIED_KELP_BLOCK).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELP_BLOCK = HELPER.createBlock("thorny_kelp_block", () -> new Block(Properties.copy(Blocks.DRIED_KELP_BLOCK).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELP_BLOCK = HELPER.createBlock("ochre_kelp_block", () -> new Block(Properties.copy(Blocks.DRIED_KELP_BLOCK).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELP_BLOCK = HELPER.createBlock("polar_kelp_block", () -> new Block(Properties.copy(Blocks.DRIED_KELP_BLOCK).sound(SoundType.WET_GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> KELPY_COBBLESTONE = HELPER.createBlock("kelpy_cobblestone", () -> new Block(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_COBBLESTONE_STAIRS = HELPER.createBlock("kelpy_cobblestone_stairs", () -> new StairBlock(() -> KELPY_COBBLESTONE.get().defaultBlockState(), Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_COBBLESTONE_SLAB = HELPER.createBlock("kelpy_cobblestone_slab", () -> new SlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_COBBLESTONE_WALL = HELPER.createBlock("kelpy_cobblestone_wall", () -> new WallBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> KELPY_COBBLESTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "kelpy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_STONE_BRICKS = HELPER.createBlock("kelpy_stone_bricks", () -> new Block(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_STONE_BRICK_STAIRS = HELPER.createBlock("kelpy_stone_brick_stairs", () -> new StairBlock(() -> KELPY_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_STONE_BRICK_SLAB = HELPER.createBlock("kelpy_stone_brick_slab", () -> new SlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> KELPY_STONE_BRICK_WALL = HELPER.createBlock("kelpy_stone_brick_wall", () -> new WallBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> KELPY_STONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "kelpy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> TONGUE_KELPY_COBBLESTONE = HELPER.createBlock("tongue_kelpy_cobblestone", () -> new Block(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_COBBLESTONE_STAIRS = HELPER.createBlock("tongue_kelpy_cobblestone_stairs", () -> new StairBlock(() -> TONGUE_KELPY_COBBLESTONE.get().defaultBlockState(), Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_COBBLESTONE_SLAB = HELPER.createBlock("tongue_kelpy_cobblestone_slab", () -> new SlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_COBBLESTONE_WALL = HELPER.createBlock("tongue_kelpy_cobblestone_wall", () -> new WallBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> TONGUE_KELPY_COBBLESTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "tongue_kelpy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICKS = HELPER.createBlock("tongue_kelpy_stone_bricks", () -> new Block(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_STAIRS = HELPER.createBlock("tongue_kelpy_stone_brick_stairs", () -> new StairBlock(() -> TONGUE_KELPY_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_SLAB = HELPER.createBlock("tongue_kelpy_stone_brick_slab", () -> new SlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_WALL = HELPER.createBlock("tongue_kelpy_stone_brick_wall", () -> new WallBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> TONGUE_KELPY_STONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "tongue_kelpy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> THORNY_KELPY_COBBLESTONE = HELPER.createBlock("thorny_kelpy_cobblestone", () -> new Block(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_COBBLESTONE_STAIRS = HELPER.createBlock("thorny_kelpy_cobblestone_stairs", () -> new StairBlock(() -> THORNY_KELPY_COBBLESTONE.get().defaultBlockState(), Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_COBBLESTONE_SLAB = HELPER.createBlock("thorny_kelpy_cobblestone_slab", () -> new SlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_COBBLESTONE_WALL = HELPER.createBlock("thorny_kelpy_cobblestone_wall", () -> new WallBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> THORNY_KELPY_COBBLESTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "thorny_kelpy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICKS = HELPER.createBlock("thorny_kelpy_stone_bricks", () -> new Block(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_STAIRS = HELPER.createBlock("thorny_kelpy_stone_brick_stairs", () -> new StairBlock(() -> THORNY_KELPY_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_SLAB = HELPER.createBlock("thorny_kelpy_stone_brick_slab", () -> new SlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_WALL = HELPER.createBlock("thorny_kelpy_stone_brick_wall", () -> new WallBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> THORNY_KELPY_STONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "thorny_kelpy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> OCHRE_KELPY_COBBLESTONE = HELPER.createBlock("ochre_kelpy_cobblestone", () -> new Block(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_COBBLESTONE_STAIRS = HELPER.createBlock("ochre_kelpy_cobblestone_stairs", () -> new StairBlock(() -> OCHRE_KELPY_COBBLESTONE.get().defaultBlockState(), Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_COBBLESTONE_SLAB = HELPER.createBlock("ochre_kelpy_cobblestone_slab", () -> new SlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_COBBLESTONE_WALL = HELPER.createBlock("ochre_kelpy_cobblestone_wall", () -> new WallBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> OCHRE_KELPY_COBBLESTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "ochre_kelpy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICKS = HELPER.createBlock("ochre_kelpy_stone_bricks", () -> new Block(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_STAIRS = HELPER.createBlock("ochre_kelpy_stone_brick_stairs", () -> new StairBlock(() -> OCHRE_KELPY_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_SLAB = HELPER.createBlock("ochre_kelpy_stone_brick_slab", () -> new SlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_WALL = HELPER.createBlock("ochre_kelpy_stone_brick_wall", () -> new WallBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> OCHRE_KELPY_STONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "ochre_kelpy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final RegistryObject<Block> POLAR_KELPY_COBBLESTONE = HELPER.createBlock("polar_kelpy_cobblestone", () -> new Block(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_COBBLESTONE_STAIRS = HELPER.createBlock("polar_kelpy_cobblestone_stairs", () -> new StairBlock(() -> POLAR_KELPY_COBBLESTONE.get().defaultBlockState(), Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_COBBLESTONE_SLAB = HELPER.createBlock("polar_kelpy_cobblestone_slab", () -> new SlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_COBBLESTONE_WALL = HELPER.createBlock("polar_kelpy_cobblestone_wall", () -> new WallBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> POLAR_KELPY_COBBLESTONE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polar_kelpy_cobblestone_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.COBBLESTONE)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICKS = HELPER.createBlock("polar_kelpy_stone_bricks", () -> new Block(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_STAIRS = HELPER.createBlock("polar_kelpy_stone_brick_stairs", () -> new StairBlock(() -> POLAR_KELPY_STONE_BRICKS.get().defaultBlockState(), Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_SLAB = HELPER.createBlock("polar_kelpy_stone_brick_slab", () -> new SlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_WALL = HELPER.createBlock("polar_kelpy_stone_brick_wall", () -> new WallBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> POLAR_KELPY_STONE_BRICK_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "polar_kelpy_stone_brick_vertical_slab", () -> new VerticalSlabBlock(Properties.copy(Blocks.STONE_BRICKS)), CreativeModeTab.TAB_BUILDING_BLOCKS);

	public static final class UAProperties {
		public static final BlockBehaviour.Properties DEAD_CORAL_BLOCK = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(1.5F, 6.0F);
		public static final BlockBehaviour.Properties DEAD_CORAL = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().noCollission().instabreak();

		public static final BlockBehaviour.Properties LUMINOUS_PRISMARINE = BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIAMOND).strength(1.5F, 6.0F).lightLevel((unknown) -> (8)).hasPostProcess(PropertyUtil::always).emissiveRendering(PropertyUtil::always);

		public static final BlockBehaviour.Properties CORALSTONE = Properties.copy(Blocks.STONE).randomTicks();

		public static final BlockBehaviour.Properties ELDER_EYE = BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.TERRACOTTA_WHITE).sound(SoundType.METAL).strength(1.0F);
		public static final BlockBehaviour.Properties PICKERELWEED = BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).randomTicks().noCollission().strength(0.0F).sound(SoundType.WET_GRASS);
		public static final BlockBehaviour.Properties BEACHGRASS_THATCH = BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.GRASS).noOcclusion();

		public static BlockBehaviour.Properties createCoral(MaterialColor color) {
			return BlockBehaviour.Properties.of(Material.WATER_PLANT, color).noCollission().instabreak().sound(SoundType.WET_GRASS);
		}

		public static BlockBehaviour.Properties createCoralBlock(MaterialColor color) {
			return BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.CORAL_BLOCK);
		}

		public static BlockBehaviour.Properties createPrismarineCoral(boolean elder) {
			MaterialColor color = !elder ? MaterialColor.DIAMOND : MaterialColor.TERRACOTTA_WHITE;
			return BlockBehaviour.Properties.of(Material.WATER_PLANT, color).noCollission().instabreak().lightLevel((unknown) -> (5)).sound(SoundType.GLASS);
		}

		public static BlockBehaviour.Properties createPrismarineCoralBlock(boolean elder) {
			MaterialColor color = !elder ? MaterialColor.DIAMOND : MaterialColor.TERRACOTTA_WHITE;
			return BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(1.5F, 6.0F).lightLevel((unknown) -> (6)).sound(SoundType.GLASS);
		}

		public static BlockBehaviour.Properties createPickerelweedBlock(boolean isBoiled) {
			return isBoiled ? BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.PLANT).strength(0.5F, 5).noOcclusion().sound(SoundType.GRASS) : BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).noOcclusion().strength(0.5F, 5).sound(SoundType.WET_GRASS);
		}
	}

	public static final Map<Supplier<Block>, Supplier<Block>> CORALSTONE_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CORALSTONE);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CORALSTONE);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CORALSTONE);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CORALSTONE);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CORALSTONE);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CORALSTONE);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CORALSTONE);
		conversions.put(STAR_CORAL_BLOCK, STAR_CORALSTONE);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CORALSTONE);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CORALSTONE);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CORALSTONE);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CORALSTONE);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CORALSTONE);
		conversions.put(SILK_CORAL_BLOCK, SILK_CORALSTONE);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CORALSTONE);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CORALSTONE);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> CHISELED_CORALSTONE_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CHISELED_CORALSTONE);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CHISELED_CORALSTONE);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CHISELED_CORALSTONE);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CHISELED_CORALSTONE);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CHISELED_CORALSTONE);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CHISELED_CORALSTONE);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CHISELED_CORALSTONE);
		conversions.put(STAR_CORAL_BLOCK, STAR_CHISELED_CORALSTONE);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CHISELED_CORALSTONE);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CHISELED_CORALSTONE);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CHISELED_CORALSTONE);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CHISELED_CORALSTONE);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CHISELED_CORALSTONE);
		conversions.put(SILK_CORAL_BLOCK, SILK_CHISELED_CORALSTONE);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CHISELED_CORALSTONE);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CHISELED_CORALSTONE);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> CORALSTONE_SLAB_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CORALSTONE_SLAB);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CORALSTONE_SLAB);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CORALSTONE_SLAB);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CORALSTONE_SLAB);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CORALSTONE_SLAB);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CORALSTONE_SLAB);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CORALSTONE_SLAB);
		conversions.put(STAR_CORAL_BLOCK, STAR_CORALSTONE_SLAB);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CORALSTONE_SLAB);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CORALSTONE_SLAB);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CORALSTONE_SLAB);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CORALSTONE_SLAB);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CORALSTONE_SLAB);
		conversions.put(SILK_CORAL_BLOCK, SILK_CORALSTONE_SLAB);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CORALSTONE_SLAB);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CORALSTONE_SLAB);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> CORALSTONE_STAIRS_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CORALSTONE_STAIRS);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CORALSTONE_STAIRS);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CORALSTONE_STAIRS);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CORALSTONE_STAIRS);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CORALSTONE_STAIRS);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CORALSTONE_STAIRS);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CORALSTONE_STAIRS);
		conversions.put(STAR_CORAL_BLOCK, STAR_CORALSTONE_STAIRS);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CORALSTONE_STAIRS);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CORALSTONE_STAIRS);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CORALSTONE_STAIRS);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CORALSTONE_STAIRS);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CORALSTONE_STAIRS);
		conversions.put(SILK_CORAL_BLOCK, SILK_CORALSTONE_STAIRS);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CORALSTONE_STAIRS);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CORALSTONE_STAIRS);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> CORALSTONE_WALL_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CORALSTONE_WALL);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CORALSTONE_WALL);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CORALSTONE_WALL);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CORALSTONE_WALL);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CORALSTONE_WALL);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CORALSTONE_WALL);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CORALSTONE_WALL);
		conversions.put(STAR_CORAL_BLOCK, STAR_CORALSTONE_WALL);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CORALSTONE_WALL);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CORALSTONE_WALL);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CORALSTONE_WALL);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CORALSTONE_WALL);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CORALSTONE_WALL);
		conversions.put(SILK_CORAL_BLOCK, SILK_CORALSTONE_WALL);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CORALSTONE_WALL);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CORALSTONE_WALL);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> CORALSTONE_VERTICAL_SLAB_CONVERSION_MAP = Util.make(Maps.newHashMap(), (conversions) -> {
		conversions.put(() -> Blocks.BUBBLE_CORAL_BLOCK, BUBBLE_CORALSTONE_VERTICAL_SLAB);
		conversions.put(() -> Blocks.HORN_CORAL_BLOCK, HORN_CORALSTONE_VERTICAL_SLAB);
		conversions.put(() -> Blocks.TUBE_CORAL_BLOCK, TUBE_CORALSTONE_VERTICAL_SLAB);
		conversions.put(() -> Blocks.BRAIN_CORAL_BLOCK, BRAIN_CORALSTONE_VERTICAL_SLAB);
		conversions.put(() -> Blocks.FIRE_CORAL_BLOCK, FIRE_CORALSTONE_VERTICAL_SLAB);
		conversions.put(ACAN_CORAL_BLOCK, ACAN_CORALSTONE_VERTICAL_SLAB);
		conversions.put(FINGER_CORAL_BLOCK, FINGER_CORALSTONE_VERTICAL_SLAB);
		conversions.put(STAR_CORAL_BLOCK, STAR_CORALSTONE_VERTICAL_SLAB);
		conversions.put(MOSS_CORAL_BLOCK, MOSS_CORALSTONE_VERTICAL_SLAB);
		conversions.put(PETAL_CORAL_BLOCK, PETAL_CORALSTONE_VERTICAL_SLAB);
		conversions.put(BRANCH_CORAL_BLOCK, BRANCH_CORALSTONE_VERTICAL_SLAB);
		conversions.put(ROCK_CORAL_BLOCK, ROCK_CORALSTONE_VERTICAL_SLAB);
		conversions.put(PILLOW_CORAL_BLOCK, PILLOW_CORALSTONE_VERTICAL_SLAB);
		conversions.put(SILK_CORAL_BLOCK, SILK_CORALSTONE_VERTICAL_SLAB);
		conversions.put(CHROME_CORAL_BLOCK, CHROME_CORALSTONE_VERTICAL_SLAB);
		conversions.put(PRISMARINE_CORAL_BLOCK, PRISMARINE_CORALSTONE_VERTICAL_SLAB);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> FALLABLES = Util.make(Maps.newHashMap(), (fallables) -> {
		fallables.put(() -> Blocks.SANDSTONE, () -> Blocks.SAND);
		fallables.put(() -> Blocks.RED_SANDSTONE, () -> Blocks.RED_SAND);
		fallables.put(() -> Blocks.COBBLESTONE, () -> Blocks.GRAVEL);
	});

	public static final Map<Supplier<Block>, Supplier<Block>> ATMOSHPERIC_FALLABLES = ModList.get().isLoaded("atmospheric") ? Util.make(Maps.newHashMap(), (fallables) -> {
		fallables.put(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation("atmospheric", "arid_sandstone")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation("atmospheric", "arid_sand")));
		fallables.put(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation("atmospheric", "red_arid_sandstone")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation("atmospheric", "red_arid_sand")));
	}) : null;

	public enum KelpType {
		TONGUE, THORNY, OCHRE, POLAR
	}
}
