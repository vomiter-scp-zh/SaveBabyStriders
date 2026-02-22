package com.vomiter.savebabystriders;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SaveBabyStriders.MODID)
public class SaveBabyStriders
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "savebabystriders";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public SaveBabyStriders(ModContainer mod, IEventBus modBus) {
        mod.registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
    }
}
