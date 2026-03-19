package net.mikuas.interval.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.mikuas.interval.Interval;
import net.mikuas.interval.block.IzumiBlocks;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.item.custom.IzumiItem;
import net.mikuas.interval.tags.IzumiItemTags;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;


/// 配方
public class IzumiRecipesProvider extends FabricRecipeProvider
{
//    private static final List<ItemConvertible> ICE_ETHER = List.of(IzumiItems.ICE_DiYa, IzumiItems.ICE_MaCao, IzumiItems.ICE_LuoJingWen);

    // Food List
    private static final List<ItemConvertible> FOODS = List.of(IzumiItems.IZUMI_MIMI);

    // Ore List
    private static final List<ItemConvertible> ORES = List.of(IzumiItems.IZUMI_CPHN, IzumiItems.IZUMI_CLSY, IzumiItems.IZUMI_LXTL);

    public IzumiRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter)
    {
        // 可逆配方
        offerReversibleCompactingRecipes(
                exporter,
                // 所属类别
                RecipeCategory.MISC,
                IzumiItems.IZUMI_LXTL,
                // 所属类别
                RecipeCategory.BUILDING_BLOCKS,
                IzumiBlocks.IZUMI_FLUOR_ICE
        );

        // 冶炼
        /*
            ICE_ETHER => Type: List<ItemConvertible>

            冶炼之后变为 IzumiItems.IZUMI_FOOD_PAI_MENG

         */
        // 熔炉
        offerSmelting(exporter,
                // 被烧的物品
                FOODS,
                // 类别
                RecipeCategory.MISC,
                // 冶炼后的结果
                IzumiItems.IZUMI_FOOD_PAI_MENG,
                // 冶炼能获取的经验
                0.7F,
                // 冶炼时间
                32,
                // 所属组
                "izumi_foods"
        );
        offerSmelting(exporter, ORES, RecipeCategory.MISC, IzumiBlocks.IZUMI_FLUOR_ICE, 0.7F, 10, "izumi_ores");

        // 高炉
        offerBlasting(exporter,
                // 被烧的物品
                FOODS,
                // 类别
                RecipeCategory.MISC,
                // 冶炼后的结果
                IzumiItems.IZUMI_FOOD_PAI_MENG,
                // 冶炼能获取的经验
                0.7F,
                // 冶炼时间
                16,
                // 所属组
                "ice_ether"
        );

        // smoking, campfire_cooking
        // 篝火
        offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new,
                // 时间
                32,
                IzumiItems.IZUMI_MIMI, IzumiItems.IZUMI_FOOD_PAI_MENG,
                // 经验值
                1.0F
                );

        // 有序配方
//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR, 3)
//                .pattern("###")
//                .input('#', Ingredient.ofItems(Items.BEETROOT))
//                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.BEETROOT))
//                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "beetroot_to_sugar"));

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.APPLE, 3)
//                .pattern("###")
//                .input('#', IzumiItemTags.APPLE_TAG)    // Apply Tag
//                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_CPHN))
//                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "cphn_clsy_lxtl_to_apple"));
//
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_AMBER, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_FLUOR_ICE))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_FLUOR_ICE))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "fluor_ice_to_ether_amber")); // path -> 文件名

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_STAIRS, 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_ETHER_AMBER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_ETHER_AMBER))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "ether_amber_to_ether_stairs"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_SLAB, 6)
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_ETHER_AMBER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_ETHER_AMBER))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "ether_amber_to_ether_slab"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_PRESSURE_PLATE, 1)
                .pattern("## ")
                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_ETHER_AMBER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_ETHER_AMBER))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "ether_amber_to_ether_pressure_plate"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_DOOR, 3)
                .pattern("## ")
                .pattern("## ")
                .pattern("## ")
                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_ETHER_AMBER))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_ETHER_AMBER))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "ether_amber_to_ether_door"));

        // 无序配方
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiBlocks.IZUMI_ETHER_BUTTON)
                .input(IzumiBlocks.IZUMI_ETHER_AMBER)
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_ETHER_AMBER))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID,  "ether_amber_toether_button"));

//        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.DIAMOND_BLOCK, 3)
//                .pattern("# #")
//                .pattern(" X ")
//                .input('#', Ingredient.ofItems(IzumiBlocks.IZUMI_VOID_MIST))
//                .input('X', Ingredient.ofItems(IzumiBlocks.IZUMI_FLUX_CRYSTAL))
//                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_VOID_MIST))
//                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiBlocks.IZUMI_FLUX_CRYSTAL))
//                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "void_mist_flux_crystal_to_diamond_block"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC, IzumiItems.IZUMI_LXTL, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_CLSY))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_CLSY))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "clsy_to_lxtl"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.MISC, IzumiItems.IZUMI_CLSY, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_CPHN))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_CPHN))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "cphn_to_clsy"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.COMBAT, IzumiItems.IZUMI_HELMET, 1)
                .pattern("###")
                .pattern("# #")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_LXTL))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_LXTL))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "lxtl_to_helmet"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.COMBAT, IzumiItems.IZUMI_CHESTPLATE, 1)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_LXTL))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_LXTL))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "lxtl_to_chestplate"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.COMBAT, IzumiItems.IZUMI_LEGGINGS, 1)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_LXTL))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_LXTL))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "lxtl_to_leggings"));

        ShapedRecipeJsonBuilder.create(
                RecipeCategory.COMBAT, IzumiItems.IZUMI_BOOTS, 1)
                .pattern("# #")
                .pattern("# #")
                .input('#', Ingredient.ofItems(IzumiItems.IZUMI_LXTL))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_LXTL))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID, "lxtl_to_boots"));

        // 无序配方
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiItems.IZUMI_CPHN)
                .input(IzumiItems.IZUMI_MIMI)
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_MIMI))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID,  "mimi_to_cphn"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, IzumiItems.IZUMI_FOOD_PAI_MENG)
                .input(IzumiItems.IZUMI_CPHN)
                .input(IzumiItems.IZUMI_CLSY)
                .input(IzumiItems.IZUMI_LXTL)
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_CPHN))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_CLSY))
                .criterion("has_item", RecipeProvider.conditionsFromItem(IzumiItems.IZUMI_LXTL))
                .offerTo(exporter, Identifier.of(Interval.MOD_ID,  "cphn_clsy_lxtl_ether_pai_meng"));

    }
}
