package dev.mayaqq.sam.mixin;

import dev.mayaqq.sam.extensions.PlayerEntityExtension;
import dev.mayaqq.sam.registry.SamAttributes;
import dev.mayaqq.sam.registry.entities.SummonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements PlayerEntityExtension {

    @Unique
    private ArrayList<SummonEntity> summonedMinions = new ArrayList<>();

    @Inject(method = "createPlayerAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", require = 1, allow = 1, at = @At("RETURN"))
    private static void additionalEntityAttributes$addPlayerAttributes(final CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
        info.getReturnValue()
                .add(SamAttributes.MINION_SLOTS)
                .add(SamAttributes.MINION_DAMAGE);
    }

    @Override
    public void summonAMinion$addSummonedMinion(SummonEntity entity) {
        this.summonedMinions.add(entity);
    }

    @Override
    public void summonAMinion$removeSummonedMinion(SummonEntity entity) {
        this.summonedMinions.remove(entity);
    }

    @Override
    public int summonAMinion$getSummonedMinionCount() {
        return summonedMinions.size();
    }

    @Override
    public int summonAMinion$getSummonedMinionLimit() {
        return (int) ((PlayerEntity) (Object) this).getAttributeInstance(SamAttributes.MINION_SLOTS).getValue();
    }

    @Override
    public ArrayList<SummonEntity> summonAMinion$getSummonedMinions() {
        return summonedMinions;
    }

    @Override
    public float summonAMinion$getSummonedMinionDamage() {
        return (float) ((PlayerEntity) (Object) this).getAttributeInstance(SamAttributes.MINION_DAMAGE).getValue();
    }
}