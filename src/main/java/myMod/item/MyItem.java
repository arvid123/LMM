package myMod.item;

import myMod.util.Reference;
import net.minecraft.item.Item;

public abstract class MyItem extends Item
{
    public MyItem(String unlocalizedName)
    {
	super();
	setTextureName(Reference.MOD_ID + ":" + unlocalizedName);
	setUnlocalizedName(unlocalizedName);
	setMaxStackSize(1);
    }
}
