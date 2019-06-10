package BloodStuff.event;

import net.minecraft.entity.player.EntityPlayer;

@cpw.mods.fml.common.eventhandler.Cancelable
public class PlayerDrainNetworkEvent extends SoulNetworkEvent
{
  public final EntityPlayer player;
  
  public PlayerDrainNetworkEvent(EntityPlayer player, String ownerNetwork, int drainAmount)
  {
    super(ownerNetwork, drainAmount);
    this.player = player;
  }
  
  public EntityPlayer getPlayer()
  {
    return player;
  }
}
