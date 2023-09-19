package com.teamabnormals.upgrade_aquatic.core.data.server.tags;

import com.teamabnormals.upgrade_aquatic.core.UpgradeAquatic;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import static com.teamabnormals.upgrade_aquatic.core.registry.UABlocks.*;

//TODO: Add all the other block tags to this
public class UABlockTagsProvider extends BlockTagsProvider {

	public UABlockTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper) {
		super(dataGenerator, UpgradeAquatic.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		TagAppender<Block> mineableWithAxe = this.tag(BlockTags.MINEABLE_WITH_AXE);
		TagAppender<Block> mineableWithPickaxe = this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
		TagAppender<Block> mineableWithHoe = this.tag(BlockTags.MINEABLE_WITH_HOE);

		mineableWithPickaxe.add(EMBEDDED_AMMONITE.get(), PRISMARINE_ROD_BUNDLE.get(), ELDER_EYE.get());
		
		for (RegistryObject<Block> block : HELPER.getDeferredRegister().getEntries()) {
			String path = block.getId().getPath();
			if (path.contains("luminous_prismarine") || (path.contains("dead") && path.contains("coral")) || path.contains("coral_block") || path.contains("scute") || path.contains("coralstone") || path.contains("kelpy_cobblestone") || path.contains("kelpy_stone")) {
				mineableWithPickaxe.add(block.get());
			} else if (path.contains("beachgrass") || path.contains("pickerelweed_block") || path.contains("kelp_block")) {
				mineableWithHoe.add(block.get());
			}
		}
	}

}
