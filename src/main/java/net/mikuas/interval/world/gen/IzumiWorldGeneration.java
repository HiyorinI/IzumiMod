package net.mikuas.interval.world.gen;

public class IzumiWorldGeneration
{
    public static  void registerWorldGenerations()
    {
        IzumiTreeGeneration.registerTrees();
        IzumiFlowerGeneration.generateFlowers();
        IzumiOreGeneration.generateOres();
    }
}
