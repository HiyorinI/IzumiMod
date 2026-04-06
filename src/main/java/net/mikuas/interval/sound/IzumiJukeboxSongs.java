package net.mikuas.interval.sound;

import net.mikuas.interval.Interval;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public interface IzumiJukeboxSongs
{
    RegistryKey<JukeboxSong> NO_GOOD = of("no_good");
    RegistryKey<JukeboxSong> THE_WAY_THAT_I_LOVED_YOU = of("the_way_that_i_loved_you");
    RegistryKey<JukeboxSong> PINKY_OATH = of("pinky_oath");
    RegistryKey<JukeboxSong> FLOWER_TOWER = of("flower_tower");

    private static RegistryKey<JukeboxSong> of(String id)
    {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Interval.MOD_ID, id));
    }

    private static void register(Registerable<JukeboxSong> registry, RegistryKey<JukeboxSong> key, RegistryEntry.Reference<SoundEvent> soundEvent, int lengthInSeconds, int comparatorOutput)
    {
        registry.register(key, new JukeboxSong(soundEvent, Text.translatable(Util.createTranslationKey("jukebox_song", key.getValue())), lengthInSeconds, comparatorOutput));
    }

    static void bootstrap(Registerable<JukeboxSong> registry)
    {
        register(
                registry,
                NO_GOOD,
                IzumiSoundEvents.MUSIC_DISC_NO_GOOD,
                244, // 时长
                15 // 红石信号强度 Max 15
        );
        register(registry, THE_WAY_THAT_I_LOVED_YOU, IzumiSoundEvents.MUSIC_DISC_THE_WAY_THAT_I_LOVED_YOU, 193, 5);
        register(registry, PINKY_OATH, IzumiSoundEvents.MUSIC_DISC_PINKY_OATH, 184, 10);
        register(registry, FLOWER_TOWER, IzumiSoundEvents.MUSIC_DISC_FLOWER_TOWER, 275, 3);
    }
}
