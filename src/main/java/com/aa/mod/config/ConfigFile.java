package com.aa.mod.config;

import net.minecraftforge.common.config.Configuration;

public class ConfigFile
{
  public static ConfigFile INSTANCE = new ConfigFile();
  
  public static boolean thaumcraftDagger;
  
  public static boolean botaniaDagger;
  
  public static boolean razorBlade;
  
  public static boolean configSacrifice;
  
  public static boolean evilDagger;
  
  public static boolean slates;
  
  public static boolean slateRecipe;
  
  public static int rbDamage;
  
  public static int rbDamageSF;
  
  public static int rbDamageH;
  
  public static String rbDesc;
  
  public static String rbNameOrb;
  
  public static String rbNameKnife;
  
  public static int cDaggerLP;
  
  public static int cDaggerVillager;
  
  public static int cDaggerSlime;
  
  public static int cDaggerEnderman;
  public static int cDaggerAnimal;
  public static String cDesc;
  public static String cName;
  public static boolean hardCrafting;
  public static boolean hardDaggers;
  public static boolean manadagger;
  public static int manaused;
  public static boolean disableSac;
  public static boolean disableSelfSac;
  public static final boolean enable = true;
  public static final boolean disable = false;
  
  public ConfigFile() {}
  
  public void syncConfig()
  {
    String HARDCRAFTING = "general" + "." + "Hard Mode";
    com.aa.mod.Main.config.addCustomCategoryComment(HARDCRAFTING, "Turn on hardmode");
    hardCrafting = com.aa.mod.Main.config.get(HARDCRAFTING, "Use hardmode crafting recipes?", false).getBoolean(false);
    
    String HARDDAGGERS = "general" + "." + "Hard Mode";
    hardDaggers = com.aa.mod.Main.config.get(HARDDAGGERS, "Arcane Arteries daggers/knives will give less LP?", false).getBoolean(false);
    
    String MANADAGGER = "general" + "." + "Hard Mode";
    manadagger = com.aa.mod.Main.config.get(MANADAGGER, "The Botantical knife should require mana?", true).getBoolean(true);
    
    String MANADAGGERUSED = "general" + "." + "Hard Mode";
    manaused = com.aa.mod.Main.config.get(MANADAGGERUSED, "The Botantical knife should use X mana?", 100).getInt();
    


    String THAUM = "general" + "." + "Daggers";
    com.aa.mod.Main.config.addCustomCategoryComment(THAUM, "Disable different dagger types here");
    thaumcraftDagger = com.aa.mod.Main.config.get(THAUM, "Enable Thaumic Dagger", true).getBoolean(true);
    


    String BOT = "general" + "." + "Daggers";
    com.aa.mod.Main.config.addCustomCategoryComment(BOT, "Disable different dagger types here");
    botaniaDagger = com.aa.mod.Main.config.get(BOT, "Enable Botania Dagger", true).getBoolean(true);
    


    String EVIL = "general" + "." + "Daggers";
    evilDagger = com.aa.mod.Main.config.get(EVIL, "Enable EvilCraft Dagger", true).getBoolean(true);
    


    String RAZ = "general" + "." + "Daggers";
    razorBlade = com.aa.mod.Main.config.get(RAZ, "Do you want the configurable 'dagger' to be disabled?", true).getBoolean(true);
    

    String SELFSAC = "general" + "." + "Daggers";
    disableSelfSac = com.aa.mod.Main.config.get(SELFSAC, "Enable all Daggers of Self Sacrifice?", true).getBoolean(true);
    
    String SAC = "general" + "." + "Daggers";
    disableSac = com.aa.mod.Main.config.get(SAC, "Enable all Daggers of Sacrifice?", true).getBoolean(true);
    


    String RAZMAIN = "general" + "." + "Custom Dagger";
    com.aa.mod.Main.config.addCustomCategoryComment(RAZMAIN, "Configure the custom dagger here");
    rbDamage = com.aa.mod.Main.config.get(RAZMAIN, "How much LP should you get without Soul Fray?", 100).getInt();
    

    String RAZSF = "general" + "." + "Custom Dagger";
    rbDamageSF = com.aa.mod.Main.config.get(RAZSF, "How much LP should you get with Soul Fray?", 10).getInt();
    

    String RAZD = "general" + "." + "Custom Dagger";
    rbDamageH = com.aa.mod.Main.config.get(RAZD, "How many half hearts should a prick damge the player by?", 2).getInt();
    

    String RAZI = "general" + "." + "Custom Dagger";
    rbDesc = com.aa.mod.Main.config.get(RAZI, "What should the blade info be?", "Slice 'n' Dice!").getString();
    

    String RAZON = "general" + "." + "Custom Dagger";
    rbNameOrb = com.aa.mod.Main.config.get(RAZON, "What should the blade be called, if Blood Magic is in Wimp-mode?", "Special Orb").getString();
    


    String RAZDN = "general" + "." + "Custom Dagger";
    rbNameKnife = com.aa.mod.Main.config.get(RAZDN, "What should the blade be called?", "Razor Blade").getString();
    


    String SLATES = "general" + "." + "Slates";
    com.aa.mod.Main.config.addCustomCategoryComment(SLATES, "Configs to do with custom slates");
    slates = com.aa.mod.Main.config.get(SLATES, "Enable different basic slates, and runes", true).getBoolean(true);
    
    String SLATERECIPE = "general" + "." + "Slates";
    slateRecipe = com.aa.mod.Main.config.get(SLATERECIPE, "Enable non-Blood Magic -> Reinforced Slate recipe", true).getBoolean(true);
    



    String CD = "general" + "." + "Custom Dagger of Sacrifice";
    com.aa.mod.Main.config.addCustomCategoryComment(CD, "Configure the custom dagger of sacrifice here");
    configSacrifice = com.aa.mod.Main.config.get(CD, "Do you want the configurable Dagger of Self Sacrifice to be disabled?", true).getBoolean(true);
    
    String CDLP = "general" + "." + "Custom Dagger of Sacrifice";
    cDaggerLP = com.aa.mod.Main.config.get(CDLP, "How much LP should any mob not configured below give per hit?", 500).getInt();
    
    String CDV = "general" + "." + "Custom Dagger of Sacrifice";
    cDaggerVillager = com.aa.mod.Main.config.get(CDV, "How much should LP should a villager give?", 2000).getInt();
    
    String CDS = "general" + "." + "Custom Dagger of Sacrifice";
    cDaggerSlime = com.aa.mod.Main.config.get(CDS, "How much should LP should a slime give?", 150).getInt();
    
    String CDE = "general" + "." + "Custom Dagger of Sacrifice";
    cDaggerEnderman = com.aa.mod.Main.config.get(CDE, "How much should LP should an Enderman give?", 200).getInt();
    
    String CDA = "general" + "." + "Custom Dagger of Sacrifice";
    cDaggerAnimal = com.aa.mod.Main.config.get(CDA, "How much should LP should Animals give?", 150).getInt();
    
    String CDD = "general" + "." + "Custom Dagger of Sacrifice";
    cDesc = com.aa.mod.Main.config.get(CDD, "What should the dagger info be?", "Deafault Message").getString();
    
    String CDN = "general" + "." + "Custom Dagger of Sacrifice";
    cName = com.aa.mod.Main.config.get(CDN, "What should the dagger be called?", "Default Name").getString();
    


    if (com.aa.mod.Main.config.hasChanged()) {
      com.aa.mod.Main.config.save();
    }
  }
}
