//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.vomiter.savebabystriders;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@EventBusSubscriber(
        modid = "savebabystriders",
        bus = Bus.MOD
)
public class Config {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    public static boolean ADULT_STRIDER_LEAVES_MOUNT_ON_GROW = false;

    public static class Common {
        public final ForgeConfigSpec.BooleanValue adultStriderLeavesMountOnGrow;
        public Common(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            this.adultStriderLeavesMountOnGrow = builder.comment("If true, striders riding on other striders will automatically dismount when they become adults.").define("adultStriderLeavesMountOnGrow", false);
            builder.pop();
        }
    }



    @SubscribeEvent
    public static void onLoad(ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            bake();
        }

    }

    @SubscribeEvent
    public static void onReload(ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == COMMON_SPEC) {
            bake();
        }

    }

    private static void bake() {
        ADULT_STRIDER_LEAVES_MOUNT_ON_GROW = COMMON.adultStriderLeavesMountOnGrow.get();
    }

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }
}
