package dev.mayaqq.sam.registry.items.base;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SummonerWandItem extends Item {
    public SummonerWandItem(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d pos = user.raycast(ReachEntityAttributes.getReachDistance(user, 4.5), 0, false).getPos();
        PigEntity pig = new PigEntity(EntityType.PIG, world);
        pig.setPos(pos.x, pos.y, pos.z);
        world.spawnEntity(pig);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}