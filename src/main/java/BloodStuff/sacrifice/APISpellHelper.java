//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package BloodStuff.sacrifice;

import WayofTime.alchemicalWizardry.ModItems;
import WayofTime.alchemicalWizardry.api.alchemy.energy.Reagent;
import WayofTime.alchemicalWizardry.api.alchemy.energy.ReagentRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import java.util.ArrayList;
import java.util.Iterator;
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

public class APISpellHelper {
  public APISpellHelper() {
  }

  private static NBTTagCompound getPersistentDataTag(EntityPlayer player) {
    NBTTagCompound forgeData = player.getEntityData().getCompoundTag("PlayerPersisted");
    NBTTagCompound beaconData = forgeData.getCompoundTag("BloodMagic");
    if (!forgeData.hasKey("BloodMagic")) {
      forgeData.setTag("BloodMagic", beaconData);
    }

    if (!player.getEntityData().hasKey("PlayerPersisted")) {
      player.getEntityData().setTag("PlayerPersisted", forgeData);
    }

    return beaconData;
  }

  public static float getCurrentIncense(EntityPlayer player) {
    NBTTagCompound data = player.getEntityData();
    return data.hasKey("BM:CurrentIncense") ? data.getFloat("BM:CurrentIncense") : 0.0F;
  }

  public static void setCurrentIncense(EntityPlayer player, float amount) {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:CurrentIncense", amount);
  }

  public static int getPlayerLPTag(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:StoredLP") ? data.getInteger("BM:StoredLP") : 0;
  }

  public static void setPlayerLPTag(EntityPlayer player, int amount) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:StoredLP", amount);
  }

  public static int getPlayerMaxLPTag(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:MaxStoredLP") ? data.getInteger("BM:MaxStoredLP") : 0;
  }

  public static void setPlayerMaxLPTag(EntityPlayer player, int amount) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:MaxStoredLP", amount);
  }

  public static float getPlayerCurrentReagentAmount(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:StoredReagentAmount") ? data.getFloat("BM:StoredReagentAmount") : 0.0F;
  }

  public static void setPlayerCurrentReagentAmount(EntityPlayer player, float amount) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setFloat("BM:StoredReagentAmount", amount);
  }

  public static float getPlayerMaxReagentAmount(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:MaxReagentAmount") ? data.getFloat("BM:MaxReagentAmount") : 0.0F;
  }

  public static void setPlayerMaxReagentAmount(EntityPlayer player, float amount) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setFloat("BM:MaxReagentAmount", amount);
  }

  public static Reagent getPlayerReagentType(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:ReagentType") ? ReagentRegistry.getReagentForKey(data.getString("BM:ReagentType")) : null;
  }

  public static void setPlayerReagentType(EntityPlayer player, String str) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setString("BM:ReagentType", str);
  }

  public static void setPlayerReagentType(EntityPlayer player, Reagent reagent) {
    setPlayerReagentType(player, ReagentRegistry.getKeyForReagent(reagent));
  }

  public static float getCurrentAdditionalHP(EntityPlayer player) {
    NBTTagCompound data = player.getEntityData();
    return data.hasKey("BM:CurrentAddedHP") ? data.getFloat("BM:CurrentAddedHP") : 0.0F;
  }

  public static void setCurrentAdditionalHP(EntityPlayer player, float amount) {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:CurrentAddedHP", amount);
  }

  public static float getCurrentAdditionalMaxHP(EntityPlayer player) {
    NBTTagCompound data = player.getEntityData();
    return data.hasKey("BM:MaxAddedHP") ? data.getFloat("BM:MaxAddedHP") : 0.0F;
  }

  public static void setCurrentAdditionalMaxHP(EntityPlayer player, float maxHP) {
    NBTTagCompound data = player.getEntityData();
    data.setFloat("BM:MaxAddedHP", maxHP);
  }

  public static int getPlayerReagentRegenCooldownTag(EntityPlayer player) {
    NBTTagCompound data = getPersistentDataTag(player);
    return data.hasKey("BM:ReagentRegenCooldown") ? data.getInteger("BM:ReagentRegenCooldown") : 0;
  }

  public static void setPlayerReagentRegenCooldownTag(EntityPlayer player, int amount) {
    NBTTagCompound data = getPersistentDataTag(player);
    data.setInteger("BM:ReagentRegenCooldown", amount);
  }

  public static ItemStack getOrbForLevel(int level) {
    switch(level) {
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
      default:
        return new ItemStack(Blocks.fire);
    }
  }

  public static MovingObjectPosition raytraceFromEntity(World world, Entity player, boolean par3, double range) {
    float f = 1.0F;
    float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
    float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
    double d0 = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
    double d1 = player.prevPosY + (player.posY - player.prevPosY) * (double)f;
    if (!world.isRemote && player instanceof EntityPlayer) {
      ++d1;
    }

    double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
    Vec3 vec3 = createVec3(d0, d1, d2);
    float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
    float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
    float f5 = -MathHelper.cos(-f1 * 0.017453292F);
    float f6 = MathHelper.sin(-f1 * 0.017453292F);
    float f7 = f4 * f5;
    float f8 = f3 * f5;
    if (player instanceof EntityPlayerMP) {
    }

    Vec3 vec31 = vec3.addVector((double)f7 * range, (double)f6 * range, (double)f8 * range);
    return world.func_147447_a(vec3, vec31, par3, !par3, par3);
  }

  public static Vec3 createVec3(double x, double y, double z) {
    return Vec3.createVectorHelper(x, y, z);
  }

  public static List<ItemStack> getItemsFromBlock(World world, Block block, int x, int y, int z, int meta, boolean silkTouch, int fortune) {
    boolean canSilk = block.canSilkHarvest(world, (EntityPlayer)null, x, y, z, meta);
    if (canSilk && silkTouch) {
      ArrayList<ItemStack> items = new ArrayList();
      ItemStack item = new ItemStack(block, 1, meta);
      items.add(item);
      return items;
    } else {
      return block.getDrops(world, x, y, z, meta, fortune);
    }
  }

  public static void spawnItemListInWorld(List<ItemStack> items, World world, float x, float y, float z) {
    Iterator i$ = items.iterator();

    while(i$.hasNext()) {
      ItemStack stack = (ItemStack)i$.next();
      EntityItem itemEntity = new EntityItem(world, (double)x, (double)y, (double)z, stack);
      itemEntity.delayBeforeCanPickup = 10;
      world.spawnEntityInWorld(itemEntity);
    }

  }

  public static String getNumeralForInt(int num) {
    switch(num) {
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
      default:
        return "";
    }
  }

  public static Block getBlockForString(String str) {
    String[] parts = str.split(":");
    String modId = parts[0];
    String name = parts[1];
    return GameRegistry.findBlock(modId, name);
  }

  public static Item getItemForString(String str) {
    String[] parts = str.split(":");
    String modId = parts[0];
    String name = parts[1];
    return GameRegistry.findItem(modId, name);
  }

  public static ItemStack getItemStackForString(String str) {
    String[] parts = str.split(":");
    int meta = 0;
    if (parts.length >= 3) {
      meta = Integer.decode(parts[2]);
    } else if (parts.length < 2) {
      return null;
    }

    String modId = parts[0];
    String name = parts[1];
    String itemString = modId + ":" + name;
    Item item = getItemForString(itemString);
    if (item != null) {
      return new ItemStack(item, 1, meta);
    } else {
      Block block = getBlockForString(itemString);
      return block != null ? new ItemStack(block, 1, meta) : null;
    }
  }

  public static IRecipe getRecipeForItemStack(ItemStack reqStack) {
    if (reqStack == null) {
      return null;
    } else {
      List craftingList = CraftingManager.getInstance().getRecipeList();
      Iterator i$ = craftingList.iterator();

      Object posRecipe;
      ItemStack outputStack;
      do {
        do {
          do {
            do {
              if (!i$.hasNext()) {
                return null;
              }

              posRecipe = i$.next();
            } while(!(posRecipe instanceof IRecipe));

            outputStack = ((IRecipe)posRecipe).getRecipeOutput();
          } while(outputStack == null);
        } while(outputStack.getItem() != reqStack.getItem());
      } while(outputStack.getItem().getHasSubtypes() && outputStack.getItemDamage() != reqStack.getItemDamage());

      return (IRecipe)posRecipe;
    }
  }
}
