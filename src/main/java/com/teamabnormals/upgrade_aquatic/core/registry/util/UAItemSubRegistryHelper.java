package com.teamabnormals.upgrade_aquatic.core.registry.util;

import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class UAItemSubRegistryHelper extends ItemSubRegistryHelper {

	public UAItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister());
	}
}