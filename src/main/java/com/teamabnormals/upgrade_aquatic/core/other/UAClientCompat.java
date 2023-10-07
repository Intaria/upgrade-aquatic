package com.teamabnormals.upgrade_aquatic.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;

import java.util.Arrays;

public class UAClientCompat {
	private static final RenderType CUTOUT = RenderType.cutout();
	private static final RenderType CUTOUT_MIPPED = RenderType.cutoutMipped();
	private static final RenderType TRANSLUSCENT = RenderType.translucent();

	public static void registerClientCompat() {
		registerRenderLayers();
	}

	public static void registerRenderLayers() {
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BEACHGRASS.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.TALL_BEACHGRASS.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.BLUE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PURPLE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.TALL_BLUE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.TALL_PURPLE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PINK_SEAROCKET.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.WHITE_SEAROCKET.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.FLOWERING_RUSH.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.BEACHGRASS_THATCH.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BEACHGRASS_THATCH_SLAB.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BEACHGRASS_THATCH_STAIRS.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.ACAN_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.FINGER_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.STAR_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.MOSS_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PETAL_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BRANCH_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ROCK_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PILLOW_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.SILK_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.CHROME_CORAL.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.ACAN_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.FINGER_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.STAR_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.MOSS_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PETAL_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BRANCH_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ROCK_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PILLOW_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.SILK_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.CHROME_CORAL_FAN.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.ACAN_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.FINGER_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.STAR_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.MOSS_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PETAL_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.BRANCH_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ROCK_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PILLOW_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.SILK_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.CHROME_CORAL_WALL_FAN.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ACAN_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_FINGER_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_STAR_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_MOSS_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PETAL_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_BRANCH_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ROCK_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PILLOW_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_SILK_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_CHROME_CORAL.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ACAN_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_FINGER_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_STAR_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_MOSS_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PETAL_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_BRANCH_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ROCK_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PILLOW_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_SILK_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_CHROME_CORAL_FAN.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ACAN_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_FINGER_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_STAR_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_MOSS_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PETAL_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_BRANCH_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_ROCK_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_PILLOW_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_SILK_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.DEAD_CHROME_CORAL_WALL_FAN.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.PRISMARINE_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PRISMARINE_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PRISMARINE_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.PRISMARINE_CORAL_SHOWER.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.ELDER_PRISMARINE_CORAL.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ELDER_PRISMARINE_CORAL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ELDER_PRISMARINE_CORAL_WALL_FAN.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.ELDER_PRISMARINE_CORAL_SHOWER.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.ELDER_EYE.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.OCHRE_KELP.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.THORNY_KELP.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.POLAR_KELP.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.TONGUE_KELP.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.OCHRE_KELP_PLANT.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.THORNY_KELP_PLANT.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.POLAR_KELP_PLANT.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.TONGUE_KELP_PLANT.get(), CUTOUT);

		ItemBlockRenderTypes.setRenderLayer(UABlocks.POTTED_PURPLE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.POTTED_BLUE_PICKERELWEED.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.POTTED_PINK_SEAROCKET.get(), CUTOUT);
		ItemBlockRenderTypes.setRenderLayer(UABlocks.POTTED_WHITE_SEAROCKET.get(), CUTOUT);
	}
}