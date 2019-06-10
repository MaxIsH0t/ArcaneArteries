//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.init;

import com.aa.mod.config.ConfigFile;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class evilRegist {
  public evilRegist() {
  }

  public static void Register(FMLInitializationEvent event) {
    if (ConfigFile.evilDagger) {
      if (ConfigFile.disableSelfSac) {
        Item dagger = (Item)Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
        Item Flesh = (Item)Item.itemRegistry.getObject("evilcraft:werewolfFlesh");
        GameRegistry.addRecipe(new ItemStack(itemRegist.evilDagger), new Object[]{"F", "F", "D", 'F', new ItemStack(Flesh), 'D', new ItemStack(dagger)});
      }

      if (ConfigFile.disableSac) {
        GameRegistry.addRecipe(new ItemStack(itemRegist.evilcraftSacrifice), new Object[]{"D", 'D', itemRegist.evilDagger});
      }
    }

  }
}
