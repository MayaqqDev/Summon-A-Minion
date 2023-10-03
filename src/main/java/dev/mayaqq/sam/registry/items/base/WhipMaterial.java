package dev.mayaqq.sam.registry.items.base;

import net.minecraft.item.ToolMaterial;

public interface WhipMaterial extends ToolMaterial {
    float getAttackSpeed();

    @Override
    default int getMiningLevel() {
        return 0;
    }

    @Override
    default float getMiningSpeedMultiplier() {
        return 0;
    }
}
