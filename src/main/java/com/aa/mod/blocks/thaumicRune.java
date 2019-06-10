package com.aa.mod.blocks;

import WayofTime.alchemicalWizardry.common.block.BloodRune;
import com.aa.mod.JordTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;


public class thaumicRune
  extends BloodRune
{
  public thaumicRune()
  {
    setBlockName("thaumicRune");
    setCreativeTab(JordTab.JordTab);
    setHardness(2.0F);
    setResistance(5.0F);
  }
  

  @SideOnly(Side.CLIENT)
  public void registerBlockIcons(IIconRegister iconRegister)
  {
    blockIcon = iconRegister.registerIcon("arcanearteries:thaumicRune");
  }
}
