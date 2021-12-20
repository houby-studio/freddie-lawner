package eu.houbystudio.freddielawnermod.block.custom;

import eu.houbystudio.freddielawnermod.FreddieLawnerMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class StallBlock extends Block {
    public StallBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.isClient()) {
            // Client code
            if (hand == Hand.MAIN_HAND) {
                player.sendMessage(new TranslatableText("message." + FreddieLawnerMod.MOD_ID + ".stall_use_message", player.getDisplayName()), false);
            }
        } else {
            // Server code
            if (hand == Hand.MAIN_HAND) {
                // Make NPC look at player
                Vec3d eyePosition = player.getEyePos();
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {

        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip." + FreddieLawnerMod.MOD_ID + ".stall_block_shift_1"));
            tooltip.add(new TranslatableText("tooltip." + FreddieLawnerMod.MOD_ID + ".stall_block_shift_2"));
        } else {
            tooltip.add(new TranslatableText("tooltip." + FreddieLawnerMod.MOD_ID + ".stall_block"));
        }

        super.appendTooltip(stack, world, tooltip, options);
    }
}
