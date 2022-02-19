package com.minecraftabnormals.upgrade_aquatic.client.render.jellyfish;

import com.teamabnormals.blueprint.core.endimator.entity.EndimatorEntityModel;
import com.minecraftabnormals.upgrade_aquatic.common.entities.jellyfish.AbstractJellyfishEntity;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public abstract class AbstractJellyfishRenderer<J extends AbstractJellyfishEntity> extends MobRenderer<J, EndimatorEntityModel<J>> {

	public AbstractJellyfishRenderer(EntityRenderDispatcher renderManagerIn, EndimatorEntityModel<J> entityModelIn, float shadowSizeIn) {
		super(renderManagerIn, entityModelIn, shadowSizeIn);
	}

	public abstract ResourceLocation getOverlayTexture(J jellyfish);

}