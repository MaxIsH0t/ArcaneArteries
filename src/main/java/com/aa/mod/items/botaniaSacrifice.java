package com.aa.mod.items;

import WayofTime.alchemicalWizardry.common.IDemon;
import WayofTime.alchemicalWizardry.common.demonVillage.demonHoard.demon.IHoardDemon;
import WayofTime.alchemicalWizardry.common.items.DaggerOfSacrifice;
import WayofTime.alchemicalWizardry.common.spell.complex.effect.SpellHelper;
import com.aa.mod.JordTab;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class botaniaSacrifice extends DaggerOfSacrifice {
  private float weaponDamage;
  private static final int COST = 100;

  public botaniaSacrifice() {
    this.maxStackSize = 1;
    this.setCreativeTab(JordTab.JordTab);
    this.setEnergyUsed(100);
    this.setFull3D();
    this.setMaxDamage(100);
    this.weaponDamage = 1.0F;
    this.setUnlocalizedName("botaniaSacrifice");
    this.setTextureName("arcanearteries:" + this.getUnlocalizedName().substring(5));
  }

  @SideOnly(Side.CLIENT)
  public void registerIcons(IIconRegister iconRegister) {
    this.itemIcon = iconRegister.registerIcon("arcanearteries:botaniaSacrifice");
  }

  public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) {
    if (par3EntityLivingBase != null && par2EntityLivingBase != null && !par3EntityLivingBase.worldObj.isRemote && (!(par3EntityLivingBase instanceof EntityPlayer) || !SpellHelper.isFakePlayer(par3EntityLivingBase.worldObj, (EntityPlayer)par3EntityLivingBase))) {
      if (par2EntityLivingBase instanceof IHoardDemon) {
        return false;
      } else if (!par2EntityLivingBase.isChild() && !(par2EntityLivingBase instanceof EntityPlayer) && !(par2EntityLivingBase instanceof IBossDisplayData)) {
        World world = par2EntityLivingBase.worldObj;
        if (!par2EntityLivingBase.isDead && par2EntityLivingBase.getHealth() >= 0.5F) {
          if (par2EntityLivingBase instanceof IDemon) {
            ((IDemon)par2EntityLivingBase).setDropCrystal(false);
            this.findAndNotifyAltarOfDemon(world, par2EntityLivingBase);
          }

          int lifeEssence = 1000;
          if (par2EntityLivingBase instanceof EntityVillager) {
            lifeEssence = 4000;
          } else if (par2EntityLivingBase instanceof EntitySlime) {
            lifeEssence = 300;
          } else if (par2EntityLivingBase instanceof EntityEnderman) {
            lifeEssence = 400;
          } else if (par2EntityLivingBase instanceof EntityAnimal) {
            lifeEssence = 500;
          }

          if (this.findAndFillAltar(par2EntityLivingBase.worldObj, par2EntityLivingBase, lifeEssence)) {
            double posX = par2EntityLivingBase.posX;
            double posY = par2EntityLivingBase.posY;
            double posZ = par2EntityLivingBase.posZ;

            for(int i = 0; i < 8; ++i) {
              SpellHelper.sendIndexedParticleToAllAround(world, posX, posY, posZ, 20, world.provider.dimensionId, 1, posX, posY, posZ);
            }

            par2EntityLivingBase.setHealth(-1.0F);
            par2EntityLivingBase.onDeath(DamageSource.generic);
          }

          return false;
        } else {
          return false;
        }
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  public float func_82803_g() {
    return 4.0F;
  }

  public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
    par3List.add(StatCollector.translateToLocal("A prick of a flower so sweet"));
    par3List.add(StatCollector.translateToLocal("To draw blood from thy meat"));
  }
}
