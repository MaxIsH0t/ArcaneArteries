package com.aa.mod;

import com.aa.mod.init.itemRegist;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class JordTab
{
  public static CreativeTabs JordTab = new CreativeTabs("JordTab")
  {
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
      return itemRegist.knife;
    }
  };
  
  public JordTab() {}
}
