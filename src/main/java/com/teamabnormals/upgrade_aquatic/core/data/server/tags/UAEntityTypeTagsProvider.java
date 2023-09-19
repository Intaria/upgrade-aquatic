package com.teamabnormals.upgrade_aquatic.core.data.server.tags;

import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import static com.teamabnormals.upgrade_aquatic.core.registry.UAEntityTypes.*;

public class UAEntityTypeTagsProvider extends EntityTypeTagsProvider {

	public UAEntityTypeTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, UpgradeAquatic.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(EntityTypeTags.AXOLOTL_HUNT_TARGETS).add(PIKE.get(), PERCH.get(), LIONFISH.get());
	}
}
