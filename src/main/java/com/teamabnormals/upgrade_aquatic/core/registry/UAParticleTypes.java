package com.teamabnormals.upgrade_aquatic.core.registry;


import com.teamabnormals.upgrade_aquatic.client.particle.ElderPrismarineShowerParticle;
import com.teamabnormals.upgrade_aquatic.client.particle.PrismarineShowerParticle;
import com.teamabnormals.upgrade_aquatic.client.particle.SpectralConsumeParticle;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UAParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, UpgradeAquatic.MOD_ID);

	public static final RegistryObject<SimpleParticleType> PRISMARINE_SHOWER = register("prismarine_shower");
	public static final RegistryObject<SimpleParticleType> ELDER_PRISMARINE_SHOWER = register("elder_prismarine_shower");
	public static final RegistryObject<SimpleParticleType> SPECTRAL_CONSUME = register("spectral_consume");

	private static RegistryObject<SimpleParticleType> register(String name) {
		return PARTICLES.register(name, () -> new SimpleParticleType(false));
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void registerParticleTypes(RegisterParticleProvidersEvent event) {
		event.register(PRISMARINE_SHOWER.get(), PrismarineShowerParticle.Factory::new);
		event.register(ELDER_PRISMARINE_SHOWER.get(), ElderPrismarineShowerParticle.Factory::new);
		event.register(SPECTRAL_CONSUME.get(), SpectralConsumeParticle.Factory::new);

	}
}