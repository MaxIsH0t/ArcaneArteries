//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.init;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.altarRecipeRegistry.AltarRecipeRegistry;
import com.aa.mod.blocks.blockRegist;
import com.aa.mod.config.ConfigFile;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import java.util.HashMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchItem;
import thaumcraft.api.research.ResearchPage;

public class thaumRegist {
  public static HashMap recipes = new HashMap();
  public static Item dagger;
  public static Item aspectSigil;

  public thaumRegist() {
  }

  public static void Register(FMLPostInitializationEvent event) {
    ResearchCategories.registerCategory("ZARTERIES", new ResourceLocation("arcanearteries", "textures/items/thaumicKnife.png"), new ResourceLocation("thaumcraft", "textures/gui/gui_researchback.png"));
    if (ConfigFile.thaumcraftDagger) {
      if (!ConfigFile.hardCrafting) {
        if (ConfigFile.disableSelfSac) {
          recipes.put("Dagger", ThaumcraftApi.addInfusionCraftingRecipe("DAGGER", new ItemStack(itemRegist.thaumicKnife, 1), 2, (new AspectList()).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 6), new ItemStack(dagger), new ItemStack[]{ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)}));
          (new ResearchItem("DAGGER", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 4).add(Aspect.LIFE, 3).add(Aspect.MAGIC, 1), 0, 0, 2, new ResourceLocation("arcanearteries", "textures/items/thaumicKnife.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.DAGGER"), new ResearchPage((InfusionRecipe)recipes.get("Dagger"))}).setParents(new String[0]).registerResearchItem();
        }

        if (ConfigFile.disableSac) {
          recipes.put("SacrificeDagger", ThaumcraftApi.addInfusionCraftingRecipe("SACRIFICEDAGGER", new ItemStack(itemRegist.thaumcraftSacrifice, 1), 2, (new AspectList()).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 6).add(Aspect.DEATH, 8), new ItemStack(itemRegist.thaumicKnife), new ItemStack[]{ItemApi.getItem("itemResource", 2), ItemApi.getItem("itemResource", 2)}));
          (new ResearchItem("SACRIFICEDAGGER", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 7).add(Aspect.LIFE, 12).add(Aspect.MAGIC, 6).add(Aspect.DEATH, 10), 1, 0, 2, new ResourceLocation("arcanearteries", "textures/items/thaumcraftSacrifice.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.SACRIFICEDAGGER"), new ResearchPage((InfusionRecipe)recipes.get("SacrificeDagger"))}).setParents(new String[0]).registerResearchItem();
        }
      }

      if (ConfigFile.hardCrafting) {
        if (ConfigFile.disableSelfSac) {
          recipes.put("DaggerH", ThaumcraftApi.addInfusionCraftingRecipe("DAGGERH", new ItemStack(itemRegist.thaumicKnife, 1), 7, (new AspectList()).add(Aspect.MAGIC, 15).add(Aspect.LIFE, 13), new ItemStack(dagger), new ItemStack[]{ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)}));
          (new ResearchItem("DAGGERH", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 8).add(Aspect.LIFE, 6).add(Aspect.MAGIC, 10), 0, 0, 2, new ResourceLocation("arcanearteries", "textures/items/thaumicKnife.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.DAGGERH"), new ResearchPage((InfusionRecipe)recipes.get("DaggerH"))}).setParents(new String[0]).registerResearchItem();
        }

        if (ConfigFile.disableSac) {
          recipes.put("SacrificeDaggerH", ThaumcraftApi.addInfusionCraftingRecipe("SACRIFICEDAGGERH", new ItemStack(itemRegist.thaumcraftSacrifice, 1), 8, (new AspectList()).add(Aspect.MAGIC, 15).add(Aspect.LIFE, 13).add(Aspect.DEATH, 20), new ItemStack(itemRegist.thaumicKnife), new ItemStack[]{ItemApi.getItem("itemResource", 16), ItemApi.getItem("itemResource", 16)}));
          (new ResearchItem("SACRIFICEDAGGERH", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 7).add(Aspect.LIFE, 15).add(Aspect.MAGIC, 10).add(Aspect.DEATH, 15), 1, 0, 2, new ResourceLocation("arcanearteries", "textures/items/thaumcraftSacrifice.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.SACRIFICEDAGGERH"), new ResearchPage((InfusionRecipe)recipes.get("SacrificeDaggerH"))}).setParents(new String[0]).registerResearchItem();
        }
      }
    }

    if (ConfigFile.slates) {
      recipes.put("Slate", ThaumcraftApi.addInfusionCraftingRecipe("SLATE", new ItemStack(itemRegist.thaumicSlate, 3), 2, (new AspectList()).add(Aspect.MAGIC, 4).add(Aspect.LIFE, 2), new ItemStack(Blocks.stone), new ItemStack[]{ItemApi.getItem("itemResource", 2), new ItemStack(Blocks.stone), ItemApi.getItem("itemResource", 2), new ItemStack(Blocks.stone)}));
      (new ResearchItem("SLATE", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 3).add(Aspect.LIFE, 2).add(Aspect.MAGIC, 1), 2, 1, 1, new ResourceLocation("arcanearteries", "textures/items/thaumicSlate.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.SLATE"), new ResearchPage((InfusionRecipe)recipes.get("Slate"))}).setParents(new String[0]).registerResearchItem();
      recipes.put("Rune", ThaumcraftApi.addInfusionCraftingRecipe("RUNE", new ItemStack(blockRegist.thaumicRune, 1), 2, (new AspectList()).add(Aspect.MAGIC, 6).add(Aspect.LIFE, 7).add(Aspect.ORDER, 6), new ItemStack(Blocks.stone), new ItemStack[]{ItemApi.getItem("itemResource", 2), new ItemStack(itemRegist.thaumicSlate), ItemApi.getItem("itemResource", 2), new ItemStack(itemRegist.thaumicSlate)}));
      (new ResearchItem("RUNE", "ZARTERIES", (new AspectList()).add(Aspect.ENTROPY, 6).add(Aspect.LIFE, 10).add(Aspect.MAGIC, 4).add(Aspect.ORDER, 6), -3, -1, 1, new ResourceLocation("arcanearteries", "textures/blocks/thaumicRune.png"))).setPages(new ResearchPage[]{new ResearchPage("aa.research_page.Rune"), new ResearchPage((InfusionRecipe)recipes.get("Rune"))}).setParents(new String[0]).registerResearchItem();
    }

    if (ConfigFile.slateRecipe) {
      AltarRecipeRegistry.registerAltarRecipe(new ItemStack(ModItems.reinforcedSlate), new ItemStack(itemRegist.thaumicSlate), 2, 1500, 20, 20, false);
    }

  }

  static {
    dagger = (Item)Item.itemRegistry.getObject("AWWayofTime:sacrificialKnife");
  }
}
