package BloodStuff.event;

import WayofTime.alchemicalWizardry.api.rituals.RitualBreakMethod;

public class RitualStopEvent extends RitualEvent
{
  public final RitualBreakMethod method;
  
  public RitualStopEvent(WayofTime.alchemicalWizardry.api.rituals.IMasterRitualStone mrs, String ownerKey, String ritualKey, RitualBreakMethod method)
  {
    super(mrs, ownerKey, ritualKey);
    
    this.method = method;
  }
}
