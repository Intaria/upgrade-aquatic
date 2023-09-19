package com.teamabnormals.upgrade_aquatic.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import com.teamabnormals.upgrade_aquatic.common.block.entity.ElderEyeBlockEntity;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class UABlockEntityTypes {
	public static final BlockEntitySubRegistryHelper HELPER = UpgradeAquatic.REGISTRY_HELPER.getBlockEntitySubHelper();

	public static final RegistryObject<BlockEntityType<ElderEyeBlockEntity>> ELDER_EYE = HELPER.createBlockEntity("elder_eye", ElderEyeBlockEntity::new, () -> new Block[]{UABlocks.ELDER_EYE.get()});
}