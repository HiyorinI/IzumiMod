package net.mikuas.interval.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class IzumiFoodComponents
{
    public static final FoodComponent IZUMI_STAR_RAIL = new FoodComponent
            .Builder()
            .nutrition(0)
            .saturationModifier(0.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.UNLUCK, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, -1, 1), 1.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.INFESTED, -1, 1), 1.0F)
            .alwaysEdible()
            .build();

    public static final FoodComponent IZUMI_FOOD_PAI_MENG = new FoodComponent.Builder().nutrition(6).saturationModifier(2.0F)
            // 效果
            .statusEffect(new StatusEffectInstance(
                    StatusEffects.NIGHT_VISION, // 效果
                    600, // 持续时间 单位 tick 30s
                    1
            ), 1.0F) // 触发概率
            .statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 600, 1),  0.5F)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1), 1.0F)
            .alwaysEdible() // 永远可以食用
            .usingConvertsTo(IzumiItems.IZUMI_MIMI) // 吃玩返回
            .build();
}
