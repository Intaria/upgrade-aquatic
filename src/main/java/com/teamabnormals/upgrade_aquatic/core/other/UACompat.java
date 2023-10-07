package com.teamabnormals.upgrade_aquatic.core.other;

import com.teamabnormals.blueprint.core.util.DataUtil;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;

public class UACompat {

	public static void registerCompat() {
		registerCompostables();
		registerFlammables();
	}

	public static void registerCompostables() {
		DataUtil.registerCompostable(UABlocks.BEACHGRASS.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.TALL_BEACHGRASS.get(), 0.65F);
		DataUtil.registerCompostable(UABlocks.BEACHGRASS_THATCH.get(), 0.65F);
		DataUtil.registerCompostable(UABlocks.BEACHGRASS_THATCH_STAIRS.get(), 0.65F);
		DataUtil.registerCompostable(UABlocks.BEACHGRASS_THATCH_SLAB.get(), 0.65F);

		DataUtil.registerCompostable(UABlocks.BLUE_PICKERELWEED.get(), 0.30F);
		DataUtil.registerCompostable(UAItems.BOILED_BLUE_PICKERELWEED.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.BLUE_PICKERELWEED_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.BOILED_BLUE_PICKERELWEED_BLOCK.get(), 0.50F);

		DataUtil.registerCompostable(UABlocks.PURPLE_PICKERELWEED.get(), 0.30F);
		DataUtil.registerCompostable(UAItems.BOILED_PURPLE_PICKERELWEED.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.PURPLE_PICKERELWEED_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.BOILED_PURPLE_PICKERELWEED_BLOCK.get(), 0.50F);

		DataUtil.registerCompostable(UABlocks.FLOWERING_RUSH.get(), 0.65F);
		DataUtil.registerCompostable(UABlocks.WHITE_SEAROCKET.get(), 0.65F);
		DataUtil.registerCompostable(UABlocks.PINK_SEAROCKET.get(), 0.65F);

		DataUtil.registerCompostable(UABlocks.TONGUE_KELP.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.THORNY_KELP.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.OCHRE_KELP.get(), 0.30F);
		DataUtil.registerCompostable(UABlocks.POLAR_KELP.get(), 0.30F);

		DataUtil.registerCompostable(UABlocks.KELP_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.TONGUE_KELP_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.THORNY_KELP_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.OCHRE_KELP_BLOCK.get(), 0.50F);
		DataUtil.registerCompostable(UABlocks.POLAR_KELP_BLOCK.get(), 0.50F);
	}

	public static void registerFlammables() {
		DataUtil.registerFlammable(UABlocks.BLUE_PICKERELWEED_BLOCK.get(), 30, 60);
		DataUtil.registerFlammable(UABlocks.PURPLE_PICKERELWEED_BLOCK.get(), 30, 60);
		DataUtil.registerFlammable(UABlocks.BOILED_BLUE_PICKERELWEED_BLOCK.get(), 30, 60);
		DataUtil.registerFlammable(UABlocks.BOILED_PURPLE_PICKERELWEED_BLOCK.get(), 30, 60);
		DataUtil.registerFlammable(UABlocks.BLUE_PICKERELWEED.get(), 60, 100);
		DataUtil.registerFlammable(UABlocks.PURPLE_PICKERELWEED.get(), 60, 100);
		DataUtil.registerFlammable(UABlocks.TALL_BLUE_PICKERELWEED.get(), 60, 100);
		DataUtil.registerFlammable(UABlocks.TALL_PURPLE_PICKERELWEED.get(), 60, 100);

		DataUtil.registerFlammable(UABlocks.BEACHGRASS.get(), 60, 20);
		DataUtil.registerFlammable(UABlocks.TALL_BEACHGRASS.get(), 60, 20);
		DataUtil.registerFlammable(UABlocks.BEACHGRASS_THATCH.get(), 60, 20);
		DataUtil.registerFlammable(UABlocks.BEACHGRASS_THATCH_STAIRS.get(), 60, 20);
		DataUtil.registerFlammable(UABlocks.BEACHGRASS_THATCH_SLAB.get(), 60, 20);
	}

}