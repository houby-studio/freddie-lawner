package eu.houbystudio.freddielawnermod.item.custom;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Objects;
import java.util.Random;

public class WheelOfFortuneItem extends Item  {

    public WheelOfFortuneItem(Settings settings) {
        super(settings);
    }

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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) {
            Block randomBlock = getRandomBlock();
            outputRandomBlockName(randomBlock, user);
        }

        return super.use(world, user, hand);
    }

    private Block getRandomBlock() {
        Block randomBlock = Registry.BLOCK.getRandom(new Random());
        return randomBlock;
    }

    private void outputRandomBlockName(Block randomBlock, PlayerEntity player) {
        TranslatableText randomBlockName = new TranslatableText(randomBlock.getTranslationKey());
        player.sendMessage(new TranslatableText("message.freddielawnermod.wheel_of_fortune_roll_message", randomBlockName), false);
    }
}
