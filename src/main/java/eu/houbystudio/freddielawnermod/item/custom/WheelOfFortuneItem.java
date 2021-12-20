package eu.houbystudio.freddielawnermod.item.custom;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import eu.houbystudio.freddielawnermod.item.ModItems;
import eu.houbystudio.freddielawnermod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;

public class WheelOfFortuneItem extends Item  {

    public WheelOfFortuneItem(Settings settings) {
        super(settings);
    }

    // This function can be called when player holds item in hand and right clicks with it on block
    // This does not work currently as it happens on client side instead of the server side
//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//        if(context.getWorld().isClient()) {
//            BlockPos positionClicked = context.getBlockPos();
//            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
//
//            Block randomBlock = getRandomBlock();
//            outputRandomBlockName(randomBlock, player);
//        }
//
//        context.getStack().decrement(1);
//
//        return super.useOnBlock(context);
//    }

    // This function is called when player right clicks with the item in the hand
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            Item randomItem = getRandomRareLoot();
            outputRandomItemName(randomItem, user);
        }

        return super.use(world, user, hand);
    }

    // Get random block from registry of all blocks
    private Block getRandomBlock() {
        Block randomBlock = Registry.BLOCK.getRandom(new Random());
        return randomBlock;
    }

    // Get random item from RARE_LOOT tag table
    private Item getRandomRareLoot() {
        // Does not work currently for some reason
        // Item randomItem = ModTags.ItemTags.RARE_LOOT.getRandom();
        Item randomItem = Registry.ITEM.getRandom(new Random());
        return randomItem;
    }

    // Output message to chat containing Block name
    private void outputRandomBlockName(Block randomBlock, PlayerEntity player) {
        TranslatableText randomBlockName = new TranslatableText(randomBlock.getTranslationKey());
        player.sendMessage(new TranslatableText("message." + FreddieLawnerMod.MOD_ID + ".wheel_of_fortune_roll_message", randomBlockName), false);
    }

    //Output message to chat containing Item name
    private void outputRandomItemName(Item randomItem, PlayerEntity player) {
        TranslatableText randomItemName = new TranslatableText(randomItem.getTranslationKey());
        player.sendMessage(new TranslatableText("message." + FreddieLawnerMod.MOD_ID + ".wheel_of_fortune_roll_message", randomItemName), false);
    }
}
