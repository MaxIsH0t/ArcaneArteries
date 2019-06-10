//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.proxies;

import com.aa.mod.Main;
import com.aa.mod.updateChecker.CheckVersion;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {
  public ClientProxy() {
  }

  public void postInit(FMLPostInitializationEvent event) {
    super.postInit(event);
    Main.versionChecker = new CheckVersion();
    Thread versionCheckThread = new Thread(Main.versionChecker, "Version Check");
    versionCheckThread.start();
  }
}
