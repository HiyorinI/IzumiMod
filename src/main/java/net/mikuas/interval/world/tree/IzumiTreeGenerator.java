package net.mikuas.interval.world.tree;

import net.mikuas.interval.Interval;
import net.mikuas.interval.world.IzumiConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class IzumiTreeGenerator
{
    public static final SaplingGenerator IZUMI_TREE = new SaplingGenerator(
            Interval.MOD_ID + ":izumi_tree",
            Optional.empty(),
            Optional.of(IzumiConfiguredFeatures.IZUMI_TREE_KEY),
            Optional.empty()
    );
}
