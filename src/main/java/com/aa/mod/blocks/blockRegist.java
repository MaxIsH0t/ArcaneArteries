package com.aa.mod.blocks;

import WayofTime.alchemicalWizardry.common.block.BloodRune;
import com.aa.mod.helpers.RegisterHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class blockRegist
{
  public static BloodRune manaRune;
  public static BloodRune thaumicRune;
  
  public blockRegist() {}
  
  public static void Register(FMLPreInitializationEvent event)
  {
    manaRune = new manaRune();
    RegisterHelper.registerBlock(manaRune);
    
    thaumicRune = new thaumicRune();
    RegisterHelper.registerBlock(thaumicRune);
  }
}
