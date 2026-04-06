package net.mikuas.interval.sound;

import net.mikuas.interval.Interval;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class IzumiSoundEvents
{
    /*
        音效
        OGG

        单声道
        会随着距离, 方向 减弱
        其他不会

     */

    public static final SoundEvent IZUMI_AI_YIN_BLOCK_BREAK = register("izumi_ai_yin_block_break"); // 破坏音效
    public static final SoundEvent IZUMI_AI_YIN_BLOCK_STEP = register("izumi_ai_yin_block_step"); // 步行音效
    public static final SoundEvent IZUMI_AI_YIN_BLOCK_PLACE = register("izumi_ai_yin_block_place"); // 放置音效
    public static final SoundEvent IZUMI_AI_YIN_BLOCK_HIT = register("izumi_ai_yin_block_hit"); // 打击音效
    public static final SoundEvent IZUMI_AI_YIN_BLOCK_FALL = register("izumi_ai_yin_block_fall"); // 落下音效

    public static final BlockSoundGroup IZUMI_AI_YIN_BLOCK_SOUND_GROUP = new BlockSoundGroup(1.0F, 1.0F, IZUMI_AI_YIN_BLOCK_BREAK, IZUMI_AI_YIN_BLOCK_STEP, IZUMI_AI_YIN_BLOCK_PLACE, IZUMI_AI_YIN_BLOCK_HIT, IZUMI_AI_YIN_BLOCK_FALL);

    public static SoundEvent register(String name)
    {
        Identifier id = Identifier.of(Interval.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerIzumiSoundEvents()
    {

    }

    /*
        自定义音乐唱片
     */

    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_NO_GOOD = registerReference("music_disc.no_good");
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_THE_WAY_THAT_I_LOVED_YOU = registerReference("music_disc.the_way_that_i_loved_you");
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_PINKY_OATH = registerReference("music_disc.pinky_oath");
    public static final RegistryEntry.Reference<SoundEvent> MUSIC_DISC_FLOWER_TOWER = registerReference("music_disc.flower_tower");

    private static RegistryEntry.Reference<SoundEvent> registerReference(String name)
    {
        Identifier id = Identifier.of(Interval.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
