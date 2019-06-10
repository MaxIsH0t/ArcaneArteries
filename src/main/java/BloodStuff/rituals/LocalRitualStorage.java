package BloodStuff.rituals;

import WayofTime.alchemicalWizardry.api.Int3;
import net.minecraft.nbt.NBTTagCompound;




public class LocalRitualStorage
{
  public int xCoord;
  public int yCoord;
  public int zCoord;
  
  public LocalRitualStorage() {}
  
  public void writeToNBT(NBTTagCompound tag)
  {
    tag.setInteger("xCoord", xCoord);
    tag.setInteger("yCoord", yCoord);
    tag.setInteger("zCoord", zCoord);
  }
  
  public void readFromNBT(NBTTagCompound tag)
  {
    xCoord = tag.getInteger("xCoord");
    yCoord = tag.getInteger("yCoord");
    zCoord = tag.getInteger("zCoord");
  }
  
  public Int3 getLocation()
  {
    return new Int3(xCoord, yCoord, zCoord);
  }
  
  public void setLocation(Int3 location)
  {
    xCoord = xCoord;
    yCoord = yCoord;
    zCoord = zCoord;
  }
}
