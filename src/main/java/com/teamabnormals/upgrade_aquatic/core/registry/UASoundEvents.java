package com.teamabnormals.upgrade_aquatic.core.registry;

import com.teamabnormals.blueprint.core.util.registry.SoundSubRegistryHelper;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class UASoundEvents {
	public static final SoundSubRegistryHelper HELPER = UpgradeAquatic.REGISTRY_HELPER.getSoundSubHelper();

	public static final RegistryObject<SoundEvent> ENTITY_PIKE_AMBIENT = HELPER.createSoundEvent("entity.pike.ambient");
	public static final RegistryObject<SoundEvent> ENTITY_PIKE_DEATH = HELPER.createSoundEvent("entity.pike.death");
	public static final RegistryObject<SoundEvent> ENTITY_PIKE_HURT = HELPER.createSoundEvent("entity.pike.hurt");
	public static final RegistryObject<SoundEvent> ENTITY_PIKE_FLOP = HELPER.createSoundEvent("entity.pike.flop");
	public static final RegistryObject<SoundEvent> ENTITY_PIKE_BITE = HELPER.createSoundEvent("entity.pike.bite");
	public static final RegistryObject<SoundEvent> ENTITY_PIKE_SPIT = HELPER.createSoundEvent("entity.pike.spit");

	public static final RegistryObject<SoundEvent> ENTITY_PERCH_AMBIENT = HELPER.createSoundEvent("entity.perch.ambient");
	public static final RegistryObject<SoundEvent> ENTITY_PERCH_DEATH = HELPER.createSoundEvent("entity.perch.death");
	public static final RegistryObject<SoundEvent> ENTITY_PERCH_HURT = HELPER.createSoundEvent("entity.perch.hurt");
	public static final RegistryObject<SoundEvent> ENTITY_PERCH_FLOP = HELPER.createSoundEvent("entity.perch.flop");
}