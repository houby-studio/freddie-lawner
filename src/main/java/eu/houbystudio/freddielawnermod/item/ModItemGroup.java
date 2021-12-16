package eu.houbystudio.freddielawnermod.item;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup FREDDIELAWNER = FabricItemGroupBuilder.build(new Identifier(FreddieLawnerMod.MOD_ID, "freddielawner"),
            () -> new ItemStack(ModItems.WHEEL_OF_FORTUNE));
}
