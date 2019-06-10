package com.aa.mod;

import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;
import com.aa.mod.init.botaniaRegist;
import com.aa.mod.init.evilRegist;
import com.aa.mod.init.itemRegist;
import com.aa.mod.init.thaumRegist;
import com.aa.mod.proxies.CommonProxy;
import com.aa.mod.updateChecker.CheckVersion;
import cpw.mods.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.ClickEvent.Action;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Logger;

@Mod(modid="arcanearteries", version="5")
public class Main
{
  public static Configuration config;
  public static Logger logger;
  @Instance("arcanearteries")
  public static Main instance;
  @SidedProxy(
          clientSide = "com.aa.mod.proxies.ClientProxy",
          serverSide = "com.aa.mod.proxies.CommonProxy"
  )
  public static CommonProxy proxy;
  public static CheckVersion versionChecker;
  public static boolean haveWarnedVersionOutOfDate = false;

  public Main() {
  }

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    config = new Configuration(event.getSuggestedConfigurationFile());
    logger = event.getModLog();
    MinecraftForge.EVENT_BUS.register(this);
    ConfigFile.INSTANCE.syncConfig();
    itemRegist.Register(event);
    blockRegist.Register(event);
  }

  @EventHandler
  public void Init(FMLInitializationEvent event) {
    if (Loader.isModLoaded("Botania")) {
      botaniaRegist.Register();
    }

    if (Loader.isModLoaded("evilcraft")) {
      evilRegist.Register(event);
    }

  }

  @EventHandler
  public void PostInit(FMLPostInitializationEvent event) {
    if (Loader.isModLoaded("Thaumcraft")) {
      thaumRegist.Register(event);
    }

  }

  @SubscribeEvent(
          priority = EventPriority.NORMAL,
          receiveCanceled = true
  )
  public void onEvent(PlayerTickEvent event1) {
    if (!haveWarnedVersionOutOfDate && event1.player.worldObj.isRemote && !versionChecker.isLatestVersion()) {
      ClickEvent versionCheckChatClickEvent = new ClickEvent(Action.OPEN_URL, "http://jabelarminecraft.blogspot.com");
      ChatStyle clickableChatStyle = (new ChatStyle()).setChatClickEvent(versionCheckChatClickEvent);
      ChatComponentText versionWarningChatComponent = new ChatComponentText("Your Magic Beans Mod is not latest version!  Click here to update.");
      versionWarningChatComponent.setChatStyle(clickableChatStyle);
      event1.player.addChatMessage(versionWarningChatComponent);
      haveWarnedVersionOutOfDate = true;
    }

  }

  @SubscribeEvent
  public void onConfigChanged(OnConfigChangedEvent event) {
    if (event.modID.equals("arcanearteries")) {
      ConfigFile.INSTANCE.syncConfig();
    }

  }
}
