package com.minecraftabnormals.upgrade_aquatic.core.registry;

import com.minecraftabnormals.upgrade_aquatic.common.tileentities.BedrollTileEntity;
import com.minecraftabnormals.upgrade_aquatic.common.tileentities.ElderEyeTileEntity;
import com.minecraftabnormals.upgrade_aquatic.core.UpgradeAquatic;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class UATileEntities {
	public static final BlockEntitySubRegistryHelper HELPER = UpgradeAquatic.REGISTRY_HELPER.getBlockEntitySubHelper();

	public static final RegistryObject<BlockEntityType<ElderEyeTileEntity>> ELDER_EYE = HELPER.createBlockEntity("elder_eye", ElderEyeTileEntity::new, () -> new Block[]{UABlocks.ELDER_EYE.get()});
	public static final RegistryObject<BlockEntityType<BedrollTileEntity>> BEDROLL = HELPER.createBlockEntity("bedroll", BedrollTileEntity::new, () -> new Block[]{UABlocks.BEDROLL.get(), UABlocks.GRAY_BEDROLL.get(), UABlocks.LIGHT_GRAY_BEDROLL.get(), UABlocks.BROWN_BEDROLL.get(), UABlocks.WHITE_BEDROLL.get(), UABlocks.BLACK_BEDROLL.get(), UABlocks.PINK_BEDROLL.get(), UABlocks.RED_BEDROLL.get(), UABlocks.ORANGE_BEDROLL.get(), UABlocks.YELLOW_BEDROLL.get(), UABlocks.LIME_BEDROLL.get(), UABlocks.GREEN_BEDROLL.get(), UABlocks.LIGHT_BLUE_BEDROLL.get(), UABlocks.BLUE_BEDROLL.get(), UABlocks.CYAN_BEDROLL.get(), UABlocks.MAGENTA_BEDROLL.get(), UABlocks.PURPLE_BEDROLL.get()});

	public static void registerRenderers() {
		//ClientRegistry.bindTileEntityRenderer(UATileEntities.ELDER_EYE.get(), ElderEyeTileEntityRenderer::new);
	}
}