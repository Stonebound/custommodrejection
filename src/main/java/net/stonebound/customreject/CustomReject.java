package net.stonebound.customreject;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = CustomReject.MODID, name = "Custom Mod Rejection", version = "1.1.2", acceptableRemoteVersions = "*")
public class CustomReject {
    public static final String MODID = "creject";
    private static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(MODID)) {
            ConfigManager.sync(MODID, Type.INSTANCE);
        }
    }

    @Config(modid = MODID)
    public static class ModConfig {
        @Comment("Your custom rejection message [default: \"This server is running MyCoolPack 1.2.7\"]")
        public static String rejectionMessage = "This server is running MyCoolPack 1.2.7";

        @Comment("Include default mismatch message [default: true]")
        public static boolean includeMismatchedMods = true;
    }
}
