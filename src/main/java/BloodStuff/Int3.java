package BloodStuff;

import net.minecraft.nbt.NBTTagCompound;


public class Int3
{
  public int xCoord;
  public int yCoord;
  public int zCoord;
  
  public Int3(int xCoord, int yCoord, int zCoord)
  {
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    this.zCoord = zCoord;
  }
  
  public static Int3 readFromNBT(NBTTagCompound tag)
  {
    return new Int3(tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord"));
  }
  
  public NBTTagCompound writeToNBT(NBTTagCompound tag)
  {
    tag.setInteger("xCoord", xCoord);
    tag.setInteger("yCoord", yCoord);
    tag.setInteger("zCoord", zCoord);
    
    return tag;
  }
  

  public boolean equals(Object o)
  {
    return (xCoord == xCoord) && (yCoord == yCoord) && (zCoord == zCoord);
  }
  

  public int hashCode()
  {
    return xCoord + yCoord << 8 + zCoord << 16;
  }
}
