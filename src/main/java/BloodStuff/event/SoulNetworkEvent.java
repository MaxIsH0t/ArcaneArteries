package BloodStuff.event;

import cpw.mods.fml.common.eventhandler.Event;

public class SoulNetworkEvent
  extends Event
{
  public String ownerNetwork;
  public int drainAmount;
  
  public SoulNetworkEvent(String ownerNetwork, int drainAmount)
  {
    this.ownerNetwork = ownerNetwork;
    this.drainAmount = drainAmount;
  }
  
  public String getOwnerNetwork()
  {
    return ownerNetwork;
  }
  
  public int getDrainAmount()
  {
    return drainAmount;
  }
}
