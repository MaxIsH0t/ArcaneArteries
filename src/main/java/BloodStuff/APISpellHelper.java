package BloodStuff;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.alchemy.energy.Reagent;
import WayofTime.alchemicalWizardry.api.alchemy.energy.ReagentRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;





public class APISpellHelper
{
  public APISpellHelper() {}
  
  private static NBTTagCompound getPersistentDataTag(EntityPlayer player)
  {
    NBTTagCompound forgeData = player.getEntityData().getCompoundTag("PlayerPersisted");
    NBTTagCompound beaconData = forgeData.getCompoundTag("BloodMagic");
    

    if (!forgeData.hasKey("BloodMagic")) forgeData.setTag("BloodMagic", beaconData);
    if (!player.getEntityData().hasKey("PlayerPersisted")) { player.getEntityData().setTag("PlayerPersisted", forgeData);
    }
    return beaconData;
  }
  
  public static float getCurrentIncense(EntityPlayer player)
  {
    NBTTagCompound data = player.getEntityData();
    if (data.hasKey("BM:CurrentIncense"))
    {
      return data.getFloat("BM:CurrentIncense");
    }
    
    return 0.0F;
  }
  
  public static void setCurrentIncense(EntityPlayer player, float amount)
  {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:CurrentIncense", amount);
  }
  
  public static int getPlayerLPTag(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:StoredLP"))
    {
      return data.getInteger("BM:StoredLP");
    }
    
    return 0;
  }
  
  public static void setPlayerLPTag(EntityPlayer player, int amount)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:StoredLP", amount);
  }
  
  public static int getPlayerMaxLPTag(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:MaxStoredLP"))
    {
      return data.getInteger("BM:MaxStoredLP");
    }
    
    return 0;
  }
  
  public static void setPlayerMaxLPTag(EntityPlayer player, int amount)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:MaxStoredLP", amount);
  }
  
  public static float getPlayerCurrentReagentAmount(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:StoredReagentAmount"))
    {
      return data.getFloat("BM:StoredReagentAmount");
    }
    
    return 0.0F;
  }
  
  public static void setPlayerCurrentReagentAmount(EntityPlayer player, float amount)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setFloat("BM:StoredReagentAmount", amount);
  }
  
  public static float getPlayerMaxReagentAmount(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:MaxReagentAmount"))
    {
      return data.getFloat("BM:MaxReagentAmount");
    }
    
    return 0.0F;
  }
  
  public static void setPlayerMaxReagentAmount(EntityPlayer player, float amount)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setFloat("BM:MaxReagentAmount", amount);
  }
  
  public static Reagent getPlayerReagentType(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:ReagentType"))
    {
      return ReagentRegistry.getReagentForKey(data.getString("BM:ReagentType"));
    }
    
    return null;
  }
  
  public static void setPlayerReagentType(EntityPlayer player, String str)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setString("BM:ReagentType", str);
  }
  
  public static void setPlayerReagentType(EntityPlayer player, Reagent reagent)
  {
    setPlayerReagentType(player, ReagentRegistry.getKeyForReagent(reagent));
  }
  
  public static float getCurrentAdditionalHP(EntityPlayer player)
  {
    NBTTagCompound data = player.getEntityData();
    if (data.hasKey("BM:CurrentAddedHP"))
    {
      return data.getFloat("BM:CurrentAddedHP");
    }
    
    return 0.0F;
  }
  
  public static void setCurrentAdditionalHP(EntityPlayer player, float amount)
  {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:CurrentAddedHP", amount);
  }
  
  public static float getCurrentAdditionalMaxHP(EntityPlayer player)
  {
    NBTTagCompound data = player.getEntityData();
    if (data.hasKey("BM:MaxAddedHP"))
    {
      return data.getFloat("BM:MaxAddedHP");
    }
    
    return 0.0F;
  }
  
  public static void setCurrentAdditionalMaxHP(EntityPlayer player, float maxHP)
  {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:MaxAddedHP", maxHP);
  }
  
  public static int getPlayerReagentRegenCooldownTag(EntityPlayer player)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    if (data.hasKey("BM:ReagentRegenCooldown"))
    {
      return data.getInteger("BM:ReagentRegenCooldown");
    }
    
    return 0;
  }
  
  public static void setPlayerReagentRegenCooldownTag(EntityPlayer player, int amount)
  {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:ReagentRegenCooldown", amount);
  }
  
  public static ItemStack getOrbForLevel(int level)
  {
    switch (level)
    {
    case 1: 
      return new ItemStack(ModItems.weakBloodOrb);
    case 2: 
      return new ItemStack(ModItems.apprenticeBloodOrb);
    case 3: 
      return new ItemStack(ModItems.magicianBloodOrb);
    case 4: 
      return new ItemStack(ModItems.masterBloodOrb);
    case 5: 
      return new ItemStack(ModItems.archmageBloodOrb);
    case 6: 
      return new ItemStack(ModItems.transcendentBloodOrb);
    }
    return new ItemStack(Blocks.fire);
  }
  
  public static Vec3 createVec3(double x, double y, double z)
  {
    return Vec3.createVectorHelper(x, y, z);
  }
  
  public static List<ItemStack> getItemsFromBlock(World world, Block block, int x, int y, int z, int meta, boolean silkTouch, int fortune)
  {
    boolean canSilk = block.canSilkHarvest(world, null, x, y, z, meta);
    
    if ((canSilk) && (silkTouch))
    {
      ArrayList<ItemStack> items = new ArrayList();
      ItemStack item = new ItemStack(block, 1, meta);
      
      items.add(item);
      
      return items;
    }
    
    return block.getDrops(world, x, y, z, meta, fortune);
  }
  

  public static void spawnItemListInWorld(List<ItemStack> items, World world, float x, float y, float z)
  {
    for (ItemStack stack : items)
    {

      EntityItem entityitem = new EntityItem(world, x, y, z);
      entityitem.delayBeforeCanPickup = 10;
      world.spawnEntityInWorld(entityitem);
    }
  }
  
  public static String getNumeralForInt(int num)
  {
    switch (num)
    {
    case 1: 
      return "I";
    case 2: 
      return "II";
    case 3: 
      return "III";
    case 4: 
      return "IV";
    case 5: 
      return "V";
    case 6: 
      return "VI";
    case 7: 
      return "VII";
    case 8: 
      return "VIII";
    case 9: 
      return "IX";
    case 10: 
      return "X";
    }
    return "";
  }
  

  public static Block getBlockForString(String str)
  {
    String[] parts = str.split(":");
    String modId = parts[0];
    String name = parts[1];
    return GameRegistry.findBlock(modId, name);
  }
  
  public static Item getItemForString(String str)
  {
    String[] parts = str.split(":");
    String modId = parts[0];
    String name = parts[1];
    return GameRegistry.findItem(modId, name);
  }
  
  public static ItemStack getItemStackForString(String str)
  {
    String[] parts = str.split(":");
    int meta = 0;
    if (parts.length >= 3)
    {
      meta = Integer.decode(parts[2]).intValue();
    } else if (parts.length < 2)
    {
      return null;
    }
    String modId = parts[0];
    String name = parts[1];
    
    String itemString = modId + ":" + name;
    Item item = getItemForString(itemString);
    if (item != null)
    {
      return new ItemStack(item, 1, meta);
    }
    
    Block block = getBlockForString(itemString);
    if (block != null)
    {
      return new ItemStack(block, 1, meta);
    }
    
    return null;
  }
  
  public static IRecipe getRecipeForItemStack(ItemStack reqStack)
  {
    if (reqStack == null)
    {
      return null;
    }
    List craftingList = CraftingManager.getInstance().getRecipeList();
    for (Object posRecipe : craftingList)
    {
      if ((posRecipe instanceof IRecipe))
      {
        ItemStack outputStack = ((IRecipe)posRecipe).getRecipeOutput();
        if (outputStack != null)
        {
          if ((outputStack.getItem() == reqStack.getItem()) && ((!outputStack.getItem().getHasSubtypes()) || (outputStack.getItemDamage() == reqStack.getItemDamage())))
          {
            return (IRecipe)posRecipe;
          }
        }
      }
    }
    
    return null;
  }
}
