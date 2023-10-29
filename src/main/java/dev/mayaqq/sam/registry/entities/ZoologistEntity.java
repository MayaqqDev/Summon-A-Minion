package dev.mayaqq.sam.registry.entities;

import dev.mayaqq.sam.registry.SamItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.village.TradeOffers;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class ZoologistEntity extends MerchantEntity {
    public ZoologistEntity(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new StopFollowingCustomerGoal(this));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, EvokerEntity.class, 12.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, VindicatorEntity.class, 8.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, VexEntity.class, 8.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, PillagerEntity.class, 15.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, IllusionerEntity.class, 12.0F, 0.5, 0.5));
        this.goalSelector.add(1, new FleeEntityGoal<>(this, ZoglinEntity.class, 10.0F, 0.5, 0.5));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 0.5));
        this.goalSelector.add(1, new LookAtCustomerGoal(this));
        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 0.35));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.35));
        this.goalSelector.add(9, new StopAndLookAtEntityGoal(this, PlayerEntity.class, 3.0F, 1.0F));
        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0F));
    }

    public static DefaultAttributeContainer.Builder createZoologistAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0).add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0);
    }

    @Override
    public boolean isLeveledMerchant() {
        return false;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.isOf(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.hasCustomer() && !this.isBaby()) {
            if (hand == Hand.MAIN_HAND) {
                player.incrementStat(Stats.TALKED_TO_VILLAGER);
            }

            if (offers != null) {
                this.offers.clear();
                this.fillRecipes();
            }

            if (!this.getOffers().isEmpty()) {
                if (!this.getWorld().isClient) {
                    this.offers.forEach(TradeOffer::resetUses);
                    this.setCustomer(player);
                    this.sendOffers(player, this.getDisplayName(), 1);
                }

            }
            return ActionResult.success(this.getWorld().isClient);
        } else {
            return super.interactMob(player, hand);
        }
    }

    @Override
    protected void fillRecipes() {
        TradeOffers.Factory[] alwaysFactorys = getAlwaysTrades();
        TradeOffers.Factory[] currentFactorys = getCurrentTrades();
        TradeOfferList tradeOfferList = this.getOffers();
        Arrays.stream(alwaysFactorys).forEach((factory) -> {
            tradeOfferList.add(factory.create(this, this.random));
        });
        Arrays.stream(currentFactorys).forEach((factory) -> {
            tradeOfferList.add(factory.create(this, this.random));
        });
    }

    protected TradeOffers.Factory[] getCurrentTrades() {
        World world = this.getWorld();
        int moonPhase = world.getMoonPhase();
        switch (moonPhase) {
            case 0, 1 -> {
                return new TradeOffers.Factory[]{new SellDecorationTrinket(SamItems.DOG_EARS), new SellDecorationTrinket(SamItems.DOG_TAIL)};
            }
            case 2, 3 -> {
                return new TradeOffers.Factory[]{new SellDecorationTrinket(SamItems.FOX_EARS), new SellDecorationTrinket(SamItems.FOX_TAIL)};
            }
            case 4, 5 -> {
                return new TradeOffers.Factory[]{new SellDecorationTrinket(SamItems.LIZARD_EARS), new SellDecorationTrinket(SamItems.LIZARD_TAIL)};
            }
            case 6, 7 -> {
                return new TradeOffers.Factory[]{new SellDecorationTrinket(SamItems.BUNNY_EARS), new SellDecorationTrinket(SamItems.BUNNY_TAIL)};
            }
            default -> {
                return null;
            }
        }
    }

    protected TradeOffers.Factory[] getAlwaysTrades() {
        return new TradeOffers.Factory[]{
                        new TradeOffers.SellItemFactory(SamItems.LEATHER_WHIP, 24, 1, 10)
        };
    }

    @Override
    protected void afterUsing(TradeOffer offer) {
        if (offer.shouldRewardPlayerExperience()) {
            int i = 3 + this.random.nextInt(4);
            this.getWorld().spawnEntity(new ExperienceOrbEntity(this.getWorld(), this.getX(), this.getY() + 0.5, this.getZ(), i));
        }

    }

    protected SoundEvent getAmbientSound() {
        return this.hasCustomer() ? SoundEvents.ENTITY_WANDERING_TRADER_TRADE : SoundEvents.ENTITY_WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WANDERING_TRADER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_DEATH;
    }

    protected SoundEvent getTradingSound(boolean sold) {
        return sold ? SoundEvents.ENTITY_WANDERING_TRADER_YES : SoundEvents.ENTITY_WANDERING_TRADER_NO;
    }

    public SoundEvent getYesSound() {
        return SoundEvents.ENTITY_WANDERING_TRADER_YES;
    }

    public static class SellDecorationTrinket implements TradeOffers.Factory {
        private final Item item;

        public SellDecorationTrinket(Item item) {
            this.item = item;
        }

        @Nullable
        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(new ItemStack(Items.EMERALD, 10), new ItemStack(item, 1), 1000, 2, 0.0F);
        }
    }
}
