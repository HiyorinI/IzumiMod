package net.mikuas.interval.item;

import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum IzumiToolMaterials implements ToolMaterial
{
//    IZUMI_LXTL(
//            BlockTags.INCORRECT_FOR_IRON_TOOL, // 等级
//            1145,                              // 耐久值
//            14.0F,                               // 采集速度
//            24.0F,                             // 伤害
//            50,                                // 附魔能力
//            () -> Ingredient.ofItems(IzumiItems.IZUMI_CLSY) // 修复材料
//    ),

    // 合金工具 INCORRECT_FOR_NETHERITE_TOOL
    IZUMI_PICKAXE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3072, 64.0F, 32.0F, 48, () -> Ingredient.ofItems(IzumiItems.IZUMI_LXTL)),

    // 钻石
    IZUMI_DIAMOND(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2048, 32.0F, 16.0F, 24, () -> Ingredient.ofItems(IzumiItems.IZUMI_LXTL));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    private IzumiToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient
    )
    {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() { return this.repairIngredient.get(); }
}
