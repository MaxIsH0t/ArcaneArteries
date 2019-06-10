package BloodStuff.event;

import net.minecraft.item.ItemStack;

@cpw.mods.fml.common.eventhandler.Cancelable
public class ItemDrainInContainerEvent extends SoulNetworkEvent
{
  public ItemStack stack;
  
  public ItemDrainInContainerEvent(ItemStack stack, String ownerNetwork, int drainAmount)
  {
    super(ownerNetwork, drainAmount);
    this.stack = stack;
  }
}
