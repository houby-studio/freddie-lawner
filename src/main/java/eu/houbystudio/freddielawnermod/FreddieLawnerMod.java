package eu.houbystudio.freddielawnermod;

import eu.houbystudio.freddielawnermod.block.ModBlocks;
import eu.houbystudio.freddielawnermod.item.ModItems;
import eu.houbystudio.freddielawnermod.registries.ModRegistries;
import eu.houbystudio.freddielawnermod.util.ModTags;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FreddieLawnerMod implements ModInitializer {
	// This variable is used throughout the repository, so we do not have to type it out all the time
	public static final String MOD_ID = "freddielawnermod";
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Register Items via ./item/ModItems
		ModItems.registerModItems();
		// Register Blocks via ./block/ModBlocks
		ModBlocks.registerModBlocks();
		// Register fuel Registry via ./registries/ModRegistries
		ModRegistries.registerFuels();

		LOGGER.info("Freddie Lawner mod initialized!");
	}
}
