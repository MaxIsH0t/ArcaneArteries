package BloodStuff.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;









@Cancelable
public class AddToNetworkEvent
  extends Event
{
  public String ownerNetwork;
  public int addedAmount;
  public int maximum;
  
  public AddToNetworkEvent(String ownerNetwork, int addedAmount, int maximum)
  {
    this.ownerNetwork = ownerNetwork;
    this.addedAmount = addedAmount;
    this.maximum = maximum;
  }
  
  public String getOwnerNetwork()
  {
    return ownerNetwork;
  }
  
  public int getAddedAmount()
  {
    return addedAmount;
  }
}
