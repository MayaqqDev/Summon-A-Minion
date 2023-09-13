package dev.mayaqq.sam.registry.items.base;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SummonerWandItem extends Item {
    public SummonerWandItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.raycast(3, 0, false).getPos();
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}