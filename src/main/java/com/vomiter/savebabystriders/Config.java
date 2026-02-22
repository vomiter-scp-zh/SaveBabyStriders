//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.vomiter.savebabystriders;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(
        modid = "savebabystriders"
)
public class Config {
    public static final ModConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    public static boolean ADULT_STRIDER_LEAVES_MOUNT_ON_GROW = false;

    public static class Common {
        public final ModConfigSpec.BooleanValue adultStriderLeavesMountOnGrow;
        public Common(ModConfigSpec.Builder builder) {
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
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        COMMON = new Common(builder);
        COMMON_SPEC = builder.build();
    }
}
