package net.mikuas.interval.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class IzumiFoodComponents
{
    public static final FoodComponent IZUMI_STAR_RAIL = new FoodComponent.Builder().nutrition(1).saturationModifier(0.8F).build();

    public static final FoodComponent IZUMI_FOOD_PAI_MENG = new FoodComponent.Builder().nutrition(6).saturationModifier(2.0F)
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.FIRE_RESISTANCE, // 效果
                    600, // 持续时间 单位 tick 30s
                    1 // 触发概率
            ), 1.0F) // 效果
            .alwaysEdible() // 永远可以食用
            .usingConvertsTo(IzumiItems.IZUMI_MIMI) // 吃玩返回
            .build();
}
