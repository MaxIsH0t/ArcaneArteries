package BloodStuff;

import net.minecraft.item.ItemStack;

public class RoutingFocusLogic {
  public RoutingFocusLogic() {}
  
  public boolean getDefaultMatch(ItemStack keyStack, ItemStack checkedStack) {
    return (checkedStack != null) && (keyStack.getItem() == checkedStack.getItem()) && ((!keyStack.getItem().getHasSubtypes()) || (keyStack.getItemDamage() == checkedStack.getItemDamage()));
  }
  
  public boolean doesItemMatch(boolean previous, ItemStack keyStack, ItemStack checkedStack)
  {
    return (previous) || (getDefaultMatch(keyStack, checkedStack));
  }
}
