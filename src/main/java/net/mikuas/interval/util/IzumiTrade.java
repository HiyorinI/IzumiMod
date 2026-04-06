package net.mikuas.interval.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.mikuas.interval.item.IzumiItems;
import net.mikuas.interval.villager.IzumiPointOfInterestTypes;
import net.mikuas.interval.villager.IzumiVillagers;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class IzumiTrade
{
    /*
        自定义交易
     */

    public static void registerIzumiTrade()
    {
        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.FARMER,      // 职业
                1,                               // 等级
                factories ->
                {
                    // Items
                    factories.add(new TradeOffers.BuyItemFactory(       // 村民购买
                            IzumiItems.IZUMI_CLSY,                     // 购买的物品
                            1,                                          // 数量
                            64,                                         // 最大交易次数
                            12,                                         // 经验
                            12                                           // 价格
                    ));
                    factories.add(new TradeOffers.SellItemFactory(      // 出售
                            IzumiItems.IZUMI_SWORD,                      // 物品
                            64,                                         // 价格
                            1,                                          // 数量
                            12,                                         // 最大交易次数
                            6,                                          // 经验
                            0.5F                                        // 打折力度
                    ));
                }
        );

        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.FARMER,
                2,
                factories ->
                {
                    factories.add(new TradeOffers.ProcessItemFactory(IzumiItems.IZUMI_MIMI, 1, 5, IzumiItems.IZUMI_SEED, 1, 12, 1, 0.05F)); // 绿宝石和 IZUMI_MIMI -> IZUMI_SEED
                    factories.add(new TradeOffers.ProcessItemFactory(IzumiItems.IZUMI_CPHN, 1, 5, IzumiItems.IZUMI_CLSY, 18, 12, 1, 0.05F));
                }
        );

        TradeOfferHelper.registerVillagerOffers(
                VillagerProfession.WEAPONSMITH, // 武器职业
                1,
                factories ->
                {
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_HELMET, 32, 1, 1, 1, 0.3F));
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_CHESTPLATE, 64, 1, 1, 1, 0.6F));
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_LEGGINGS, 48, 1, 1, 1, 0.4F));
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_BOOTS, 24, 1, 1, 1, 0.2F));
                }
        );
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///     CUSTOM
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TradeOfferHelper.registerVillagerOffers(
                IzumiVillagers.IZUMI_VOID_MIST_MASTER,
                1,
                factories ->
                {
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_MIMI, 1, 32, 12, 1, 0.5F));
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_PICKAXE, 64, 1, 6, 1, 0.0F));
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_FUEL_HK3, 5, 1, 32, 10, 0.15F));
                }
        );

        TradeOfferHelper.registerVillagerOffers(
                IzumiVillagers.IZUMI_FLUOR_ICE_MASTER,
                1,
                factories ->
                {
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_CPHN, 1, 1, 16, 1, 0.0F));
                }
        );
        TradeOfferHelper.registerVillagerOffers(
                IzumiVillagers.IZUMI_FLUOR_ICE_MASTER,
                2,
                factories ->
                {
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_CLSY, 8, 1, 16, 1, 0.0F));
                }
        );
        TradeOfferHelper.registerVillagerOffers(
                IzumiVillagers.IZUMI_FLUOR_ICE_MASTER,
                3,
                factories ->
                {
                    factories.add(new TradeOffers.SellItemFactory(IzumiItems.IZUMI_LXTL, 24, 1, 16, 1, 0.0F));
                }
        );

    }
}
