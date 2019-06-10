package com.aa.mod.config;

import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
import cpw.mods.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;


public class GUIFactory
  implements IModGuiFactory
{
  public GUIFactory() {}
  
  public void initialize(Minecraft minecraftInstance) {}
  
  public Class<? extends GuiScreen> mainConfigGuiClass()
  {
    return ConfigGUI.class;
  }
  

  public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories()
  {
    return null;
  }
  

  public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element)
  {
    return null;
  }
}
