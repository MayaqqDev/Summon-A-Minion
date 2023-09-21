package dev.mayaqq.sam.registry.entities;

import dev.mayaqq.sam.registry.entities.goals.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.scoreboard.AbstractTeam;
import net.minecraft.server.ServerConfigHandler;
import net.minecraft.world.EntityView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class SummonEntity extends PathAwareEntity implements Tameable {

    protected static final TrackedData<Optional<UUID>> OWNER_UUID;
    public SummonEntity(EntityType<? extends SummonEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
        this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(OWNER_UUID, Optional.empty());
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(5, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(6, new FollowSummonerGoal(this, 1.0D, 3.0F, 2.0F, false));
        this.goalSelector.add(10, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(10, new LookAroundGoal(this));

        this.targetSelector.add(1, new ActiveSummonTargetGoal(this, MobEntity.class, true));
        this.targetSelector.add(2, new TrackSummonerAttackerGoal(this));
        this.targetSelector.add(3, new AttackWithSummonerGoal(this));
        this.targetSelector.add(4, new UniversalAngerGoal(this, true));
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        if (this.getOwner() != null) {
            nbt.putUuid("Owner", this.getOwner().getUuid());
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        UUID UUID;
        if (nbt.containsUuid("Owner")) {
            UUID = nbt.getUuid("Owner");
        } else {
            String string = nbt.getString("Owner");
            UUID = ServerConfigHandler.getPlayerUuidByName(this.getServer(), string);
        }

        if (UUID != null) {
            this.setOwnerUuid(UUID);
        }
    }

    @Override
    public boolean canBeLeashedBy(PlayerEntity player) {
        return false;
    }

    @Nullable
    public UUID getOwnerUuid() {
        return (UUID)((Optional)this.dataTracker.get(OWNER_UUID)).orElse((Object)null);
    }

    @Override
    public EntityView method_48926() {
        return this.getWorld();
    }

    public void setOwnerUuid(@Nullable UUID uuid) {
        this.dataTracker.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    public void setOwner(PlayerEntity player) {
        this.setOwnerUuid(player.getUuid());
    }

    @Override
    public AbstractTeam getScoreboardTeam() {
        LivingEntity livingEntity = this.getOwner();
        if (livingEntity != null) {
            return livingEntity.getScoreboardTeam();
        }

        return super.getScoreboardTeam();
    }

    public boolean isTeammate(Entity other) {
        LivingEntity livingEntity = this.getOwner();
        if (other == livingEntity) {
            return true;
        }

        if (livingEntity != null) {
            return livingEntity.isTeammate(other);
        }

        return super.isTeammate(other);
    }

    static {
        OWNER_UUID = DataTracker.registerData(SummonEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }
}
