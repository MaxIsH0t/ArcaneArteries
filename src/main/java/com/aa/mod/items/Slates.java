//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.items;

import com.aa.mod.JordTab;
import com.aa.mod.init.itemRegist;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class Slates extends Item {
  public Slates() {
    this.setMaxStackSize(64);
    this.setCreativeTab(JordTab.JordTab);
  }

  public void registerIcons(IIconRegister iconRegister) {
    if (this.equals(itemRegist.thaumicSlate)) {
      this.itemIcon = iconRegister.registerIcon("arcanearteries:thaumicSlate");
    } else if (this.equals(itemRegist.manaSlate)) {
      this.itemIcon = iconRegister.registerIcon("arcanearteries:manaSlate");
    }

  }
}
