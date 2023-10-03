package dev.mayaqq.sam.registry.items.materials;

import dev.mayaqq.sam.registry.items.base.WhipMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;

public enum WhipMaterials implements WhipMaterial {
    LEATHER(1.0F, -2.4F, 100, 15, Ingredient.ofItems(Items.LEATHER)),
    ;

    private final float damage;
    private final float attackSpeed;
    private final int durability;
    private final int enchantability;
    private final Ingredient repairIngredient;

    private WhipMaterials(float damage, float attackSpeed, int durability, int enchantability, Ingredient repairIngredient) {
        this.damage = damage;
        this.attackSpeed = attackSpeed;
        this.durability = durability;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public float getAttackDamage() {
        return this.damage;
    }

    @Override
    public float getAttackSpeed() {
        return this.attackSpeed;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
