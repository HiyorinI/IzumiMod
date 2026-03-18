package net.mikuas.interval.tags;

import net.mikuas.interval.Interval;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class IzumiItemTags
{
    public static final TagKey<Item> APPLE_TAG = of("apple_tag");

    public static TagKey<Item> of(String id)
    {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Interval.MOD_ID, id));
    }

    public static void registerIzumiItemTags()
    {

        Interval.LOGGER.info("Registering Item Tags");
    }
}
