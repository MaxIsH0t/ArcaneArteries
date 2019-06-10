package BloodStuff.sacrifice;

import net.minecraft.item.ItemStack;

public abstract interface IIncense
{
  public abstract int getMinLevel(ItemStack paramItemStack);
  
  public abstract int getMaxLevel(ItemStack paramItemStack);
  
  public abstract int getIncenseDuration(ItemStack paramItemStack);
  
  public abstract float getRedColour(ItemStack paramItemStack);
  
  public abstract float getGreenColour(ItemStack paramItemStack);
  
  public abstract float getBlueColour(ItemStack paramItemStack);
  
  public abstract float getTickRate(ItemStack paramItemStack);
}
