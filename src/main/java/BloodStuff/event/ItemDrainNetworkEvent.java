package BloodStuff.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;








@Cancelable
public class ItemDrainNetworkEvent
  extends PlayerDrainNetworkEvent
{
  public final ItemStack itemStack;
  public boolean shouldDamage;
  public float damageAmount;
  
  public ItemDrainNetworkEvent(EntityPlayer player, String ownerNetwork, ItemStack itemStack, int drainAmount)
  {
    super(player, ownerNetwork, drainAmount);
    this.itemStack = itemStack;
    shouldDamage = false;
    damageAmount = (drainAmount / 100.0F);
  }
}
