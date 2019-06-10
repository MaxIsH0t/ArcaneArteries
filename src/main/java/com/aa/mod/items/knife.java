//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.aa.mod.items;

import BloodStuff.PlayerSacrificeHandler;
import WayofTime.alchemicalWizardry.AlchemicalWizardry;
import WayofTime.alchemicalWizardry.api.event.SacrificeKnifeUsedEvent;
import WayofTime.alchemicalWizardry.common.items.SacrificialDagger;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import com.aa.mod.JordTab;
import com.aa.mod.config.ConfigFile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.FakePlayer;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

public class knife extends SacrificialDagger implements IManaUsingItem {
  private static final int COST;

  public knife() {
    this.maxStackSize = 1;
    this.setCreativeTab(JordTab.JordTab);
    this.setFull3D();
    this.setUnlocalizedName("knife");
    this.setTextureName("arcanearteries:" + this.getUnlocalizedName().substring(5));
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    if (AlchemicalWizardry.wimpySettings) {
      this.itemIcon = iconRegister.registerIcon("arcanearteries:botanicalOrb");
    } else {
      this.itemIcon = iconRegister.registerIcon("arcanearteries:knife");
    }

  }

  public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    par3List.add("Do I make you thorny baby!");
  }

  public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int itemInUseCount) {
    PlayerSacrificeHandler.sacrificePlayerHealth(player);
  }

  public int getMaxItemUseDuration(ItemStack stack) {
    return 72000;
  }

  public EnumAction getItemUseAction(ItemStack stack) {
    return EnumAction.bow;
  }

  public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
    SacrificeKnifeUsedEvent evt;
    double posY;
    double posZ;
    float f;
    float f1;
    float f2;
    float f3;
    int l;
    double posX;
    if (ConfigFile.manadagger) {
      if (!world.isRemote && ManaItemHandler.requestManaExact(stack, player, COST, true)) {
        if (this.canUseForSacrifice(stack)) {
          player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
          return stack;
        }

        if (!player.capabilities.isCreativeMode) {
          evt = new SacrificeKnifeUsedEvent(player, true, true, 2);
          if (MinecraftForge.EVENT_BUS.post(evt)) {
            return stack;
          }

          if (evt.shouldDrainHealth) {
            player.setHealth(player.getHealth() - 2.0F);
          }

          if (!evt.shouldFillAltar) {
            return stack;
          }
        }

        if (player instanceof FakePlayer) {
          return stack;
        }

        posX = player.posX;
        posY = player.posY;
        posZ = player.posZ;
        world.playSoundEffect((double)((float)posX + 0.5F), (double)((float)posY + 0.5F), (double)((float)posZ + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
        f = 1.0F;
        f1 = f * 0.6F + 0.4F;
        f2 = f * f * 0.7F - 0.5F;
        f3 = f * f * 0.6F - 0.7F;

        for(l = 0; l < 8; ++l) {
          world.spawnParticle("reddust", posX + Math.random() - Math.random(), posY + Math.random() - Math.random(), posZ + Math.random() - Math.random(), (double)f1, (double)f2, (double)f3);
        }

        if (!world.isRemote && SpellHelper.isFakePlayer(world, player)) {
          return stack;
        }

        if (ConfigFile.hardDaggers) {
          if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray)) {
            this.findAndFillAltar(world, player, 100);
          } else {
            this.findAndFillAltar(world, player, 1000);
          }
        }

        if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray)) {
          this.findAndFillAltar(world, player, 50);
        } else {
          this.findAndFillAltar(world, player, 500);
        }

        if (player.getHealth() <= 0.001F) {
          player.onDeath(DamageSource.cactus);
        }
      }

      return stack;
    } else if (this.canUseForSacrifice(stack)) {
      player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
      return stack;
    } else {
      if (!player.capabilities.isCreativeMode) {
        evt = new SacrificeKnifeUsedEvent(player, true, true, 2);
        if (MinecraftForge.EVENT_BUS.post(evt)) {
          return stack;
        }

        if (evt.shouldDrainHealth) {
          player.setHealth(player.getHealth() - 2.0F);
        }

        if (!evt.shouldFillAltar) {
          return stack;
        }
      }

      if (player instanceof FakePlayer) {
        return stack;
      } else {
        posX = player.posX;
        posY = player.posY;
        posZ = player.posZ;
        world.playSoundEffect((double)((float)posX + 0.5F), (double)((float)posY + 0.5F), (double)((float)posZ + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
        f = 1.0F;
        f1 = f * 0.6F + 0.4F;
        f2 = f * f * 0.7F - 0.5F;
        f3 = f * f * 0.6F - 0.7F;

        for(l = 0; l < 8; ++l) {
          world.spawnParticle("reddust", posX + Math.random() - Math.random(), posY + Math.random() - Math.random(), posZ + Math.random() - Math.random(), (double)f1, (double)f2, (double)f3);
        }

        if (!world.isRemote && SpellHelper.isFakePlayer(world, player)) {
          return stack;
        } else {
          if (ConfigFile.hardDaggers) {
            if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray)) {
              this.findAndFillAltar(world, player, 100);
            } else {
              this.findAndFillAltar(world, player, 1000);
            }
          }

          if (player.isPotionActive(AlchemicalWizardry.customPotionSoulFray)) {
            this.findAndFillAltar(world, player, 50);
          } else {
            this.findAndFillAltar(world, player, 500);
          }

          if (player.getHealth() <= 0.001F) {
            player.onDeath(DamageSource.cactus);
          }

          return stack;
        }
      }
    }
  }

  public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
    if (!world.isRemote && entity instanceof EntityPlayer) {
      this.setUseForSacrifice(stack, this.isPlayerPreparedForSacrifice(world, (EntityPlayer)entity));
    }

  }

  public String getItemStackDisplayName(ItemStack stack) {
    return AlchemicalWizardry.wimpySettings ? "Botanical Orb" : super.getItemStackDisplayName(stack);
  }

  public boolean isPlayerPreparedForSacrifice(World world, EntityPlayer player) {
    return !world.isRemote && PlayerSacrificeHandler.getPlayerIncense(player) > 0.0F;
  }

  public boolean canUseForSacrifice(ItemStack stack) {
    NBTTagCompound tag = stack.getTagCompound();
    return tag == null ? false : tag.getBoolean("sacrifice");
  }

  public void setUseForSacrifice(ItemStack stack, boolean sacrifice) {
    NBTTagCompound tag = stack.getTagCompound();
    if (tag == null) {
      tag = new NBTTagCompound();
      stack.setTagCompound(tag);
    }

    tag.setBoolean("sacrifice", sacrifice);
  }

  @SideOnly(Side.CLIENT)
  public boolean hasEffect(ItemStack stack, int pass) {
    return this.canUseForSacrifice(stack) ? true : super.hasEffect(stack, pass);
  }

  public boolean usesMana(ItemStack stack) {
    return true;
  }

  static {
    COST = ConfigFile.manaused;
  }
}
