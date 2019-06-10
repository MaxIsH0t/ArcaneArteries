package com.aa.mod.helpers;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;


public class RegisterHelper
{
  public RegisterHelper() {}
  
  public static void registerBlock(Block block)
  {
    GameRegistry.registerBlock(block, "arcanearteries " + block.getUnlocalizedName().substring(5));
  }
  
  public static void registerItem(Item item)
  {
    GameRegistry.registerItem(item, "arcanearteries " + item.getUnlocalizedName().substring(5));
  }
  
  public static void registerOreDict(Item item, String name)
  {
    OreDictionary.registerOre(name, new ItemStack(item));
  }
}
