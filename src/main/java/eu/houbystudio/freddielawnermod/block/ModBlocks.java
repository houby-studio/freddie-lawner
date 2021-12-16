package eu.houbystudio.freddielawnermod.block;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import eu.houbystudio.freddielawnermod.block.custom.StallBlock;
import eu.houbystudio.freddielawnermod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block WHEEL_OF_FORTUNE_BLOCK = registerBlock("wheel_of_fortune_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4.0f).requiresTool()));

    public static final Block STALL_BLOCK = registerBlock("stall_block",
            new StallBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f).requiresTool().breakByHand(true)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(FreddieLawnerMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(FreddieLawnerMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.FREDDIELAWNER)));
    }

    public static void registerModBlocks() {
        FreddieLawnerMod.LOGGER.info("Register Mod Blocks for " + FreddieLawnerMod.MOD_ID);
    }
}
