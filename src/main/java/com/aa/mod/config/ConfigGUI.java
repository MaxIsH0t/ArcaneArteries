package com.aa.mod.config;

import com.aa.mod.Main;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ConfigGUI
  extends GuiConfig
{
  public ConfigGUI(GuiScreen screen)
  {
    super(screen, new ConfigElement(Main.config.getCategory("general")).getChildElements(), "arcanearteries", false, false, 
      GuiConfig.getAbridgedConfigPath(Main.config.toString()));
  }
}
