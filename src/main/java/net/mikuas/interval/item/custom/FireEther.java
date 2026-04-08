package net.mikuas.interval.item.custom;

import net.mikuas.interval.item.AbstractDurabilityItem;
import net.minecraft.item.Item;

public class FireEther extends Item implements AbstractDurabilityItem
{
    /**
     * 耐久合成
     */

    public FireEther(Item.Settings settings)
    {
        super(settings.maxDamage(128));
    }
}
