//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package BloodStuff.items1;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ShapelessBloodOrbRecipe implements IRecipe {
  private ItemStack output;
  private ArrayList<Object> input;

  public ShapelessBloodOrbRecipe(Block result, Object... recipe) {
    this(new ItemStack(result), recipe);
  }

  public ShapelessBloodOrbRecipe(Item result, Object... recipe) {
    this(new ItemStack(result), recipe);
  }

  public ShapelessBloodOrbRecipe(ItemStack result, Object... recipe) {
    this.output = null;
    this.input = new ArrayList();
    this.output = result.copy();
    Object[] arr1 = recipe;
    int len$ = recipe.length;

    for(int i$ = 0; i$ < len$; ++i$) {
      Object in = arr1[i$];
      if (in instanceof IBloodOrb) {
        this.input.add(((IBloodOrb)in).getOrbLevel());
      } else if (in instanceof ItemStack) {
        if (((ItemStack)in).getItem() instanceof IBloodOrb) {
          this.input.add(((IBloodOrb)((ItemStack)in).getItem()).getOrbLevel());
        } else {
          this.input.add(((ItemStack)in).copy());
        }
      } else if (in instanceof Item) {
        this.input.add(new ItemStack((Item)in));
      } else if (in instanceof Block) {
        this.input.add(new ItemStack((Block)in));
      } else {
        if (!(in instanceof String)) {
          String ret = "Invalid shapeless ore recipe: ";
          Object[] arr$ = recipe;
          int len1 = recipe.length;

          for(int i1 = 0; i1 < len1; ++i$) {
            Object tmp = arr$[i1];
            ret = ret + tmp + ", ";
          }

          ret = ret + this.output;
          throw new RuntimeException(ret);
        }

        this.input.add(OreDictionary.getOres((String)in));
      }
    }

  }

  ShapelessBloodOrbRecipe(ShapelessRecipes recipe, Map<ItemStack, String> replacements) {
    this.output = null;
    this.input = new ArrayList();
    this.output = recipe.getRecipeOutput();

    Object finalObj;
    for(Iterator i$ = recipe.recipeItems.iterator(); i$.hasNext(); this.input.add(finalObj)) {
      ItemStack ingred = (ItemStack)i$.next();
      finalObj = ingred;
      Iterator i1 = replacements.entrySet().iterator();

      while(i$.hasNext()) {
        Entry<ItemStack, String> replace = (Entry)i$.next();
        if (OreDictionary.itemMatches((ItemStack)replace.getKey(), ingred, false)) {
          finalObj = OreDictionary.getOres((String)replace.getValue());
          break;
        }
      }
    }

  }

  public int getRecipeSize() {
    return this.input.size();
  }

  public ItemStack getRecipeOutput() {
    return this.output;
  }

  public ItemStack getCraftingResult(InventoryCrafting var1) {
    return this.output.copy();
  }

  public boolean matches(InventoryCrafting var1, World world) {
    ArrayList<Object> required = new ArrayList(this.input);

    for(int x = 0; x < var1.getSizeInventory(); ++x) {
      ItemStack slot = var1.getStackInSlot(x);
      if (slot != null) {
        boolean inRecipe = false;
        Iterator req = required.iterator();

        while(req.hasNext()) {
          boolean match = false;
          Object next = req.next();
          if (next instanceof Integer) {
            if (slot == null || !(slot.getItem() instanceof IBloodOrb)) {
              return false;
            }

            IBloodOrb orb = (IBloodOrb)slot.getItem();
            if (orb.getOrbLevel() < (Integer)next) {
              return false;
            }

            match = true;
          } else if (next instanceof ItemStack) {
            match = OreDictionary.itemMatches((ItemStack)next, slot, false);
          } else if (next instanceof ArrayList) {
            for(Iterator itr = ((ArrayList)next).iterator(); itr.hasNext() && !match; match = OreDictionary.itemMatches((ItemStack)itr.next(), slot, false)) {
            }
          }

          if (match) {
            inRecipe = true;
            required.remove(next);
            break;
          }
        }

        if (!inRecipe) {
          return false;
        }
      }
    }

    return required.isEmpty();
  }

  public ArrayList<Object> getInput() {
    return this.input;
  }
}
