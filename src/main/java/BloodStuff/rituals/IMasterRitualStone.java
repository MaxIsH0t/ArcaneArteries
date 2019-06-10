package BloodStuff.rituals;

import WayofTime.alchemicalWizardry.api.alchemy.energy.ISegmentedReagentHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract interface IMasterRitualStone
  extends ISegmentedReagentHandler
{
  public abstract void performRitual(World paramWorld, int paramInt1, int paramInt2, int paramInt3, String paramString);
  
  public abstract String getOwner();
  
  public abstract void setCooldown(int paramInt);
  
  public abstract int getCooldown();
  
  public abstract void setVar1(int paramInt);
  
  public abstract int getVar1();
  
  public abstract void setActive(boolean paramBoolean);
  
  public abstract int getDirection();
  
  public abstract World getWorld();
  
  public abstract int getXCoord();
  
  public abstract int getYCoord();
  
  public abstract int getZCoord();
  
  public abstract NBTTagCompound getCustomRitualTag();
  
  public abstract void setCustomRitualTag(NBTTagCompound paramNBTTagCompound);
  
  public abstract boolean areTanksEmpty();
  
  public abstract int getRunningTime();
  
  public abstract LocalRitualStorage getLocalStorage();
  
  public abstract void setLocalStorage(LocalRitualStorage paramLocalRitualStorage);
}
