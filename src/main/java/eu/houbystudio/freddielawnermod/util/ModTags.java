package eu.houbystudio.freddielawnermod.util;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class BlockTags {

        // Mod tags
        public static final Tag<Block> VALUABLE_BLOCKS = createTag("valuable_blocks");
        //public static final Tag<Block> FORTUNE_ORES = createTag("fortune_ores");

        public static final Tag<Block> FORTUNE_ORES = TagFactory.BLOCK.create(new Identifier(FreddieLawnerMod.MOD_ID, "fortune_ores"));

        // Common tags
        // TODO:

        private static Tag<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(FreddieLawnerMod.MOD_ID, name));
        }

        private static Tag<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }

    }

    public static class ItemTags {

        public static final Tag<Item> BUYABLE = createTag("buyable");
        public static final Tag<Item> RARE_LOOT = createTag("rare_loot");

        private static Tag<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(FreddieLawnerMod.MOD_ID, name));
        }

        private static Tag<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }

    }
}
