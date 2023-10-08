package dev.mayaqq.sam.registry.items.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import dev.mayaqq.sam.extensions.PlayerEntityExtension;
import dev.mayaqq.sam.registry.SamAttributes;
import dev.mayaqq.sam.registry.SamEntities;
import dev.mayaqq.sam.registry.entities.summons.SummonEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Uuids;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class SummonerWandItem extends Item {

    EntityType<? extends SummonEntity> entityType;

    public SummonerWandItem(Settings settings, EntityType<? extends SummonEntity> entityType) {
        super(settings.maxCount(1));
        this.entityType = entityType;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return TypedActionResult.success(user.getStackInHand(hand));
        if (user.getAttributeValue(SamAttributes.MINION_SLOTS) <= 0) return TypedActionResult.fail(user.getStackInHand(hand));
        if (((PlayerEntityExtension) user).summonAMinion$getSummonedMinionCount() >= user.getAttributeValue(SamAttributes.MINION_SLOTS)) {
            ((PlayerEntityExtension) user).summonAMinion$getSummonedMinions().get(0).remove(Entity.RemovalReason.DISCARDED);
            ((PlayerEntityExtension) user).summonAMinion$getSummonedMinions().remove(0);
        }
        Vec3d pos =  user.raycast(ReachEntityAttributes.getReachDistance(user, 4.5), 0, false).getPos();
        SummonEntity summonEntity = new SummonEntity(this.entityType, world);
        summonEntity.setOwner(user);
        summonEntity.updatePosition(pos.x, pos.y, pos.z);
        world.spawnEntity(summonEntity);
        user.getItemCooldownManager().set(this, 10);
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Right click to summon a minion!"));
    }
}