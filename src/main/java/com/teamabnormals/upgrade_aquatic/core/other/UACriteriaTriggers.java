package com.teamabnormals.upgrade_aquatic.core.other;

import com.teamabnormals.blueprint.common.advancement.EmptyTrigger;
import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = UpgradeAquatic.MOD_ID)
public class UACriteriaTriggers {
	private static ResourceLocation prefix(String name) {
		return new ResourceLocation(UpgradeAquatic.MOD_ID, name);
	}
}