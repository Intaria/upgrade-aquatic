package com.teamabnormals.upgrade_aquatic.core.registry;

import com.teamabnormals.blueprint.core.util.registry.EntitySubRegistryHelper;
import com.teamabnormals.upgrade_aquatic.common.entity.animal.*;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class UAEntityTypes {
	public static final EntitySubRegistryHelper HELPER = UpgradeAquatic.REGISTRY_HELPER.getEntitySubHelper();

	public static final RegistryObject<EntityType<Nautilus>> NAUTILUS = HELPER.createLivingEntity("nautilus", Nautilus::new, MobCategory.WATER_AMBIENT, 0.5F, 0.5F);
	public static final RegistryObject<EntityType<Pike>> PIKE = HELPER.createLivingEntity("pike", Pike::new, MobCategory.WATER_AMBIENT, 0.7F, 0.4F);
	public static final RegistryObject<EntityType<Perch>> PERCH = HELPER.createLivingEntity("perch", Perch::new, MobCategory.WATER_AMBIENT, 0.6F, 0.5F);
	public static final RegistryObject<EntityType<Lionfish>> LIONFISH = HELPER.createLivingEntity("lionfish", Lionfish::new, MobCategory.WATER_AMBIENT, 0.6F, 0.5F);
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(NAUTILUS.get(), Nautilus.registerAttributes().build());
		event.put(PIKE.get(), Pike.registerAttributes().build());
		event.put(LIONFISH.get(), Lionfish.registerAttributes().build());
		event.put(PERCH.get(), Perch.createAttributes().build());
	}

	public static void registerSpawnPlacements() {
		SpawnPlacements.register(UAEntityTypes.NAUTILUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING, Nautilus::checkNautilusSpawnRules);
		SpawnPlacements.register(UAEntityTypes.LIONFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING, Lionfish::checkLionfishSpawnRules);
		SpawnPlacements.register(UAEntityTypes.PIKE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING, Pike::checkPikeSpawnRules);
		SpawnPlacements.register(UAEntityTypes.PERCH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
		
	}
}