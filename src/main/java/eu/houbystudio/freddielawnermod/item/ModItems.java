package eu.houbystudio.freddielawnermod.item;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import eu.houbystudio.freddielawnermod.item.custom.WheelOfFortuneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item WHEEL_OF_FORTUNE = registerItem("wheel_of_fortune",
            new WheelOfFortuneItem(new FabricItemSettings().group(ModItemGroup.FREDDIELAWNER)));

    public static final Item WHEEL_OF_FORTUNE_SHARDS = registerItem("wheel_of_fortune_shards",
            new Item(new FabricItemSettings().group(ModItemGroup.FREDDIELAWNER)));

    public static final Item DOG_FOOD = registerItem("dog_food", new Item(new FabricItemSettings()
            .food(new FoodComponent.Builder().hunger(3).saturationModifier(0.2f).build())
            .group(ModItemGroup.FREDDIELAWNER)));

    public static final Item GASOLINE_CANISTER = registerItem("gasoline_canister",
            new Item(new FabricItemSettings().group(ModItemGroup.FREDDIELAWNER)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FreddieLawnerMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FreddieLawnerMod.LOGGER.info("Registering Mod Items for " + FreddieLawnerMod.MOD_ID);
    }
}
