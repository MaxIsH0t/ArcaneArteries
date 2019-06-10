//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.init;

import com.aa.mod.JordTab;
import com.aa.mod.config.ConfigFile;
import com.aa.mod.helpers.RegisterHelper;
import com.aa.mod.items.Slates;
import com.aa.mod.items.botaniaSacrifice;
import com.aa.mod.items.configDagger;
import com.aa.mod.items.configSacrifice;
import com.aa.mod.items.evilDagger;
import com.aa.mod.items.evilcraftSacrifice;
import com.aa.mod.items.knife;
import com.aa.mod.items.thaumcraftSacrifice;
import com.aa.mod.items.thaumicKnife;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class itemRegist {
  static CreativeTabs Tab;
  public static Item knife;
  public static Item thaumicKnife;
  public static Item configDagger;
  public static Item evilDagger;
  public static Item botaniaSacrifice;
  public static Item thaumcraftSacrifice;
  public static Item evilcraftSacrifice;
  public static Item configSacrifice;
  public static Item manaSlate;
  public static Item thaumicSlate;

  public itemRegist() {
  }

  public static void Register(FMLPreInitializationEvent event) {
    knife = new knife();
    RegisterHelper.registerItem(knife);
    thaumicKnife = new thaumicKnife();
    RegisterHelper.registerItem(thaumicKnife);
    if (!ConfigFile.razorBlade) {
      configDagger = new configDagger();
      RegisterHelper.registerItem(configDagger);
    }

    evilDagger = new evilDagger();
    RegisterHelper.registerItem(evilDagger);
    botaniaSacrifice = new botaniaSacrifice();
    RegisterHelper.registerItem(botaniaSacrifice);
    thaumcraftSacrifice = new thaumcraftSacrifice();
    RegisterHelper.registerItem(thaumcraftSacrifice);
    evilcraftSacrifice = new evilcraftSacrifice();
    RegisterHelper.registerItem(evilcraftSacrifice);
    if (!ConfigFile.configSacrifice) {
      configSacrifice = new configSacrifice();
      RegisterHelper.registerItem(configSacrifice);
    }

    thaumicSlate = (new Slates()).setUnlocalizedName("thaumicSlate");
    RegisterHelper.registerItem(thaumicSlate);
    manaSlate = (new Slates()).setUnlocalizedName("manaSlate");
    RegisterHelper.registerItem(manaSlate);
  }

  static {
    Tab = JordTab.JordTab;
  }
}
