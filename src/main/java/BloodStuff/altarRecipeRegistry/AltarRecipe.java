package BloodStuff.altarRecipeRegistry;

import java.util.Set;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;


public class AltarRecipe
{
  public int minTier;
  public int liquidRequired;
  public boolean canBeFilled;
  public int consumptionRate;
  public int drainRate;
  public ItemStack requiredItem;
  public ItemStack result;
  public boolean useTag;
  
  public AltarRecipe(ItemStack result, ItemStack requiredItem, int minTier, int liquidRequired, int consumptionRate, int drainRate, boolean canBeFilled)
  {
    this(result, requiredItem, minTier, liquidRequired, consumptionRate, drainRate, canBeFilled, false);
  }
  
  public AltarRecipe(ItemStack result, ItemStack requiredItem, int minTier, int liquidRequired, int consumptionRate, int drainRate, boolean canBeFilled, boolean useTag)
  {
    this.result = result;
    this.requiredItem = requiredItem;
    this.minTier = minTier;
    this.liquidRequired = liquidRequired;
    this.consumptionRate = consumptionRate;
    this.drainRate = drainRate;
    this.canBeFilled = canBeFilled;
    this.useTag = useTag;
  }
  
  public ItemStack getResult()
  {
    return result;
  }
  
  public ItemStack getRequiredItem()
  {
    return requiredItem;
  }
  
  public boolean doesRequiredItemMatch(ItemStack comparedStack, int tierCheck)
  {
    if ((comparedStack == null) || (requiredItem == null))
    {
      return false;
    }
    
    return (tierCheck >= minTier) && (requiredItem.isItemEqual(comparedStack)) && ((!useTag) || (areRequiredTagsEqual(comparedStack)));
  }
  
  public boolean areRequiredTagsEqual(ItemStack comparedStack)
  {
    if (requiredItem.hasTagCompound())
    {
      NBTTagCompound tag = requiredItem.getTagCompound();
      if (!comparedStack.hasTagCompound())
      {
        return false;
      }
      
      NBTTagCompound comparedTag = comparedStack.getTagCompound();
      
      return areTagsEqual(tag, comparedTag);
    }
    
    return true;
  }
  
  protected boolean areTagsEqual(NBTTagCompound tag, NBTTagCompound comparedTag)
  {
    Set set = tag.func_150296_c();
    
    for (Object obj : set)
    {
      if ((obj instanceof String))
      {
        String str = (String)obj;
        
        NBTBase baseTag = comparedTag.getTag(str);
        
        if ((baseTag instanceof NBTTagCompound))
        {
          NBTBase comparedBaseTag = comparedTag.getTag(str);
          if ((comparedBaseTag instanceof NBTTagCompound))
          {
            if (!areTagsEqual(tag, comparedTag))
            {
              return false;
            }
            
          }
        }
        else if ((baseTag != null) && (!baseTag.equals(comparedTag.getTag(str))))
        {
          return false;
        }
      }
    }
    

    return true;
  }
  
  public int getMinTier()
  {
    return minTier;
  }
  
  public int getLiquidRequired()
  {
    return liquidRequired;
  }
  
  public int getConsumptionRate()
  {
    return consumptionRate;
  }
  
  public int getDrainRate()
  {
    return drainRate;
  }
  
  public boolean getCanBeFilled()
  {
    return canBeFilled;
  }
}
