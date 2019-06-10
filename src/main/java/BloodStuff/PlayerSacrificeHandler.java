//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package BloodStuff;

import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.tile.IBloodAltar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class PlayerSacrificeHandler {
  public static float scalingOfSacrifice = 0.001F;
  public static int soulFrayDuration = 400;

  public PlayerSacrificeHandler() {
  }

  public static float getPlayerIncense(EntityPlayer player) {
    return APISpellHelper.getCurrentIncense(player);
  }

  public static void setPlayerIncense(EntityPlayer player, float amount) {
    APISpellHelper.setCurrentIncense(player, amount);
  }

  public static boolean incrementIncense(EntityPlayer player, float min, float max, float increment) {
    float amount = getPlayerIncense(player);
    if (amount >= min && amount < max) {
      amount += Math.min(increment, max - amount);
      setPlayerIncense(player, amount);
      return true;
    } else {
      return false;
    }
  }

  public static boolean sacrificePlayerHealth(EntityPlayer player) {
    if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray)) {
      return false;
    } else {
      float amount = getPlayerIncense(player);
      if (amount >= 0.0F) {
        float health = player.getHealth();
        float maxHealth = player.getMaxHealth();
        if ((double)health > (double)maxHealth / 10.0D) {
          float sacrificedHealth = health - maxHealth / 10.0F;
          if (findAndFillAltar(player.getEntityWorld(), player, (int)(sacrificedHealth * 100.0F * getModifier(amount)))) {
            player.setHealth(maxHealth / 10.0F);
            setPlayerIncense(player, 0.0F);
            player.addPotionEffect(new PotionEffect(AlchemicalWizardry.customPotionSoulFray.id, soulFrayDuration));
            return true;
          }
        }
      }

      return false;
    }
  }

  public static float getModifier(float amount) {
    return 1.0F + amount * scalingOfSacrifice;
  }

  public static boolean findAndFillAltar(World world, EntityPlayer player, int amount) {
    int posX = (int)Math.round(player.posX - 0.5D);
    int posY = (int)player.posY;
    int posZ = (int)Math.round(player.posZ - 0.5D);
    IBloodAltar altarEntity = getAltar(world, posX, posY, posZ);
    return altarEntity != null;
  }

  public static IBloodAltar getAltar(World world, int x, int y, int z) {
    TileEntity tileEntity = null;

    for(int i = -2; i <= 2; ++i) {
      for(int j = -2; j <= 2; ++j) {
        for(int k = -2; k <= 1; ++k) {
          tileEntity = world.getTileEntity(i + x, k + y, j + z);
          if (tileEntity instanceof IBloodAltar) {
            return (IBloodAltar)tileEntity;
          }
        }
      }
    }

    return null;
  }
}
