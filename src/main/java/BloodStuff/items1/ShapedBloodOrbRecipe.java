//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package BloodStuff.items1;

import WayofTime.alchemicalWizardry.api.items.interfaces.IBloodOrb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ShapedBloodOrbRecipe implements IRecipe {
  private static final int MAX_CRAFT_GRID_WIDTH = 3;
  private static final int MAX_CRAFT_GRID_HEIGHT = 3;
  private ItemStack output;
  private Object[] input;
  public int width;
  public int height;
  private boolean mirrored;

  public ShapedBloodOrbRecipe(Block result, Object... recipe) {
    this(new ItemStack(result), recipe);
  }

  public ShapedBloodOrbRecipe(Item result, Object... recipe) {
    this(new ItemStack(result), recipe);
  }

  public ShapedBloodOrbRecipe(ItemStack result, Object... recipe) {
    this.output = null;
    this.input = null;
    this.width = 0;
    this.height = 0;
    this.mirrored = true;
    this.output = result.copy();
    String shape = "";
    int idx = 0;
    if (recipe[idx] instanceof Boolean) {
      this.mirrored = (Boolean)recipe[idx];
      if (recipe[idx + 1] instanceof Object[]) {
        recipe = (Object[])((Object[])recipe[idx + 1]);
      } else {
        idx = 1;
      }
    }

    String ret;
    int len$;
    if (recipe[idx] instanceof String[]) {
      String[] parts = (String[])((String[])recipe[idx++]);
      String[] arr$ = parts;
      len$ = parts.length;

      for(len$ = 0; len$ < len$; ++len$) {
        String s = arr$[len$];
        this.width = s.length();
        shape = shape + s;
      }

      this.height = parts.length;
    } else {
      while(recipe[idx] instanceof String) {
        ret = (String)recipe[idx++];
        shape = shape + ret;
        this.width = ret.length();
        ++this.height;
      }
    }

    if (this.width * this.height != shape.length()) {
      ret = "Invalid shaped ore recipe: ";
      Object[] arr$ = recipe;
      len$ = recipe.length;

      for(len$ = 0; len$ < len$; ++len$) {
        Object tmp = arr$[len$];
        ret = ret + tmp + ", ";
      }

      ret = ret + this.output;
      throw new RuntimeException(ret);
    } else {
      HashMap itemMap;
      for(itemMap = new HashMap(); idx < recipe.length; idx += 2) {
        Character chr = (Character)recipe[idx];
        Object in = recipe[idx + 1];
        if (in instanceof IBloodOrb || in instanceof ItemStack && ((ItemStack)in).getItem() instanceof IBloodOrb) {
          if (in instanceof ItemStack) {
            itemMap.put(chr, ((IBloodOrb)((ItemStack)in).getItem()).getOrbLevel());
          } else {
            itemMap.put(chr, ((IBloodOrb)in).getOrbLevel());
          }
        } else if (in instanceof ItemStack) {
          itemMap.put(chr, ((ItemStack)in).copy());
        } else if (in instanceof Item) {
          itemMap.put(chr, new ItemStack((Item)in));
        } else if (in instanceof Block) {
          itemMap.put(chr, new ItemStack((Block)in, 1, 32767));
        } else {
          if (!(in instanceof String)) {
            String ret1 = "Invalid shaped ore recipe: ";
            Object[] arr$ = recipe;
            int len1 = recipe.length;

            for(int i$ = 0; i$ < len1; ++i$) {
              Object tmp = arr$[i$];
              ret = ret1 + tmp + ", ";
            }

            ret = ret1 + this.output;
            throw new RuntimeException(ret);
          }

          itemMap.put(chr, OreDictionary.getOres((String)in));
        }
      }

      this.input = new Object[this.width * this.height];
      int x = 0;
      char[] arr$ = shape.toCharArray();
      len$ = arr$.length;

      for(int i$ = 0; i$ < len$; ++i$) {
        char chr = arr$[i$];
        this.input[x++] = itemMap.get(chr);
      }

    }
  }

  ShapedBloodOrbRecipe(ShapedRecipes recipe, Map<ItemStack, String> replacements) {
    this.output = null;
    this.input = null;
    this.width = 0;
    this.height = 0;
    this.mirrored = true;
    this.output = recipe.getRecipeOutput();
    this.width = recipe.recipeWidth;
    this.height = recipe.recipeHeight;
    this.input = new Object[recipe.recipeItems.length];

    for(int i = 0; i < this.input.length; ++i) {
      ItemStack ingred = recipe.recipeItems[i];
      if (ingred != null) {
        this.input[i] = recipe.recipeItems[i];
        Iterator i$ = replacements.entrySet().iterator();

        while(i$.hasNext()) {
          Entry<ItemStack, String> replace = (Entry)i$.next();
          if (OreDictionary.itemMatches((ItemStack)replace.getKey(), ingred, true)) {
            this.input[i] = OreDictionary.getOres((String)replace.getValue());
            break;
          }
        }
      }
    }

  }

  public ItemStack getCraftingResult(InventoryCrafting var1) {
    return this.output.copy();
  }

  public int getRecipeSize() {
    return this.input.length;
  }

  public ItemStack getRecipeOutput() {
    return this.output;
  }

  public boolean matches(InventoryCrafting inv, World world) {
    for(int x = 0; x <= 3 - this.width; ++x) {
      for(int y = 0; y <= 3 - this.height; ++y) {
        if (this.checkMatch(inv, x, y, false)) {
          return true;
        }

        if (this.mirrored && this.checkMatch(inv, x, y, true)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean checkMatch(InventoryCrafting inv, int startX, int startY, boolean mirror) {
    for(int x = 0; x < 3; ++x) {
      for(int y = 0; y < 3; ++y) {
        int subX = x - startX;
        int subY = y - startY;
        Object target = null;
        if (subX >= 0 && subY >= 0 && subX < this.width && subY < this.height) {
          if (mirror) {
            target = this.input[this.width - subX - 1 + subY * this.width];
          } else {
            target = this.input[subX + subY * this.width];
          }
        }

        ItemStack slot = inv.getStackInRowAndColumn(x, y);
        if (target instanceof Integer) {
          if (slot == null || !(slot.getItem() instanceof IBloodOrb)) {
            return false;
          }

          IBloodOrb orb = (IBloodOrb)slot.getItem();
          if (orb.getOrbLevel() < (Integer)target) {
            return false;
          }
        } else if (target instanceof ItemStack) {
          if (!OreDictionary.itemMatches((ItemStack)target, slot, false)) {
            return false;
          }
        } else if (target instanceof ArrayList) {
          boolean matched = false;

          for(Iterator itr = ((ArrayList)target).iterator(); itr.hasNext() && !matched; matched = OreDictionary.itemMatches((ItemStack)itr.next(), slot, false)) {
          }

          if (!matched) {
            return false;
          }
        } else if (target == null && slot != null) {
          return false;
        }
      }
    }

    return true;
  }

  public ShapedBloodOrbRecipe setMirrored(boolean mirror) {
    this.mirrored = mirror;
    return this;
  }

  public Object[] getInput() {
    return this.input;
  }
}
