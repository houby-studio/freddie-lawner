package eu.houbystudio.freddielawnermod.registries;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import eu.houbystudio.freddielawnermod.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class ModRegistries {

    public static void registerFuels() {
        FreddieLawnerMod.LOGGER.info("Now registering fueld for " + FreddieLawnerMod.MOD_ID);
        FuelRegistry registry = FuelRegistry.INSTANCE;

        registry.add(ModItems.GASOLINE_CANISTER, 1200); // x / 20 = seconds
    }
}
