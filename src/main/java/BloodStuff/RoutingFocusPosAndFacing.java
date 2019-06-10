package BloodStuff;

import net.minecraftforge.common.util.ForgeDirection;

public class RoutingFocusPosAndFacing
{
  public Int3 location;
  public ForgeDirection facing;
  
  public RoutingFocusPosAndFacing(Int3 location, ForgeDirection facing)
  {
    this.location = location;
    this.facing = facing;
  }
  

  public boolean equals(Object obj)
  {
    return (facing.equals(facing)) && (location.equals(location));
  }
}
