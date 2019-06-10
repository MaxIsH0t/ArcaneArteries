package BloodStuff;

import net.minecraft.nbt.NBTTagCompound;


public class ColourAndCoords
{
  public int colourRed;
  public int colourGreen;
  public int colourBlue;
  public int colourIntensity;
  public int xCoord;
  public int yCoord;
  public int zCoord;
  
  public ColourAndCoords(int red, int green, int blue, int intensity, int x, int y, int z)
  {
    colourRed = red;
    colourGreen = green;
    colourBlue = blue;
    colourIntensity = intensity;
    
    xCoord = x;
    yCoord = y;
    zCoord = z;
  }
  
  public static ColourAndCoords readFromNBT(NBTTagCompound tag)
  {
    return new ColourAndCoords(tag.getInteger("colourRed"), tag.getInteger("colourGreen"), tag.getInteger("colourBlue"), tag.getInteger("colourIntensity"), tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord"));
  }
  
  public NBTTagCompound writeToNBT(NBTTagCompound tag)
  {
    tag.setInteger("colourRed", colourRed);
    tag.setInteger("colourGreen", colourGreen);
    tag.setInteger("colourBlue", colourBlue);
    tag.setInteger("colourIntensity", colourIntensity);
    tag.setInteger("xCoord", xCoord);
    tag.setInteger("yCoord", yCoord);
    tag.setInteger("zCoord", zCoord);
    
    return tag;
  }
}
