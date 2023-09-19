package dev.mayaqq.sam.registry.items.base;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.mayaqq.sam.registry.entities.SlimeSummonEntity;
import dev.mayaqq.sam.registry.entities.SummonEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SummonerWandItem extends Item {

    EntityType<? extends SummonEntity> entityType;

    public SummonerWandItem(Settings settings, EntityType<SlimeSummonEntity> entityType) {
        super(settings.maxCount(1));
        this.entityType = entityType;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Vec3d pos =  user.raycast(ReachEntityAttributes.getReachDistance(user, 4.5), 0, false).getPos();
        SummonEntity slimeSummonEntity = new SummonEntity(this.entityType, world);
        slimeSummonEntity.setOwner(user);
        slimeSummonEntity.updatePosition(pos.x, pos.y, pos.z);
        slimeSummonEntity.setInvulnerable(true);
        world.spawnEntity(slimeSummonEntity);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}