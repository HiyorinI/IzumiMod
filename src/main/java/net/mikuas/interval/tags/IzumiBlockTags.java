package net.mikuas.interval.tags;

import net.mikuas.interval.Interval;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class IzumiBlockTags
{
    public static final TagKey<Block> ORE_LIST = of("ore_list");

    public static TagKey<Block> of(String id)
    {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Interval.MOD_ID, id));
    }

    public static void registerIzumiBlockTags()
    {
        Interval.LOGGER.info("Registering Item Tags");
    }
}
