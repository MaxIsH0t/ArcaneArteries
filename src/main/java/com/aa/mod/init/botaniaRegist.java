//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.init;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.api.recipe.RecipeRuneAltar;

public class botaniaRegist {
  public static RecipeRuneAltar botaniaDaggerRecipe;
  public static RecipeRuneAltar botaniaSDaggerRecipe;
  public static RecipeManaInfusion manaSlateRecipe;
  public static RecipeManaInfusion botaniaSacrificeRecipe;

  public botaniaRegist() {
  }

  public static void Register() {
    if (Loader.isModLoaded("Botania")) {
      if (ConfigFile.botaniaDagger) {
        Item dagger;
        if (!ConfigFile.hardCrafting) {
          dagger = (Item)Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
          if (ConfigFile.disableSelfSac) {
            botaniaDaggerRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(itemRegist.knife), 2000, new Object[]{"ingotElvenElementium", "ingotElvenElementium", new ItemStack(dagger)});
          }

          if (ConfigFile.disableSac) {
            botaniaSacrificeRecipe = BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(itemRegist.botaniaSacrifice), new ItemStack(itemRegist.knife), 6000);
          }
        }

        if (ConfigFile.hardCrafting) {
          dagger = (Item)Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
          if (ConfigFile.disableSelfSac) {
            botaniaDaggerRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(itemRegist.knife), 50000, new Object[]{"gaiaIngot", "gaiaIngot", "elvenPixieDust", "ingotTerrasteel", new ItemStack(dagger)});
          }

          if (ConfigFile.disableSac) {
            botaniaSDaggerRecipe = BotaniaAPI.registerRuneAltarRecipe(new ItemStack(itemRegist.botaniaSacrifice), 55000, new Object[]{"gaiaIngot", "dreamwoodTwig", "elvenPixieDust", new ItemStack(itemRegist.knife)});
          }
        }
      }

      if (ConfigFile.slates) {
        manaSlateRecipe = BotaniaAPI.registerManaInfusionRecipe(new ItemStack(itemRegist.manaSlate, 1), new ItemStack(Blocks.stone), 3000);
        GameRegistry.addRecipe(new ItemStack(blockRegist.manaRune), new Object[]{" S ", "RGR", " S ", 'S', itemRegist.manaSlate, 'R', Blocks.stone, 'G', Items.gold_ingot});
      }
    }

    if (ConfigFile.slateRecipe) {
      AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ModItems.reinforcedSlate), new ItemStack(itemRegist.manaSlate), 2, 1500, 20, 20, false);
    }

  }
}
