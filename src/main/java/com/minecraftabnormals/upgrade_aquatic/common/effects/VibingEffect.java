package com.minecraftabnormals.upgrade_aquatic.common.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class VibingEffect extends MobEffect {

	public VibingEffect() {
		super(MobEffectCategory.NEUTRAL, 0xffb5f4);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		for (LivingEntity living : entity.level.getEntitiesOfClass(LivingEntity.class, entity.getBoundingBox().inflate(0.3D))) {
			if (living.isAlive() && living != entity && !(living instanceof Player && ((Player) living).isCreative())) {
				living.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 70, amplifier + 1));
			}
		}
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
