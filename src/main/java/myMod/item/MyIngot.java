package myMod.item;

import myMod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;

public class MyIngot extends MyItem
{
    public MyIngot()
    {
	super(Reference.MY_INGOT_UNLOCALIZED_NAME);
	setMaxStackSize(64);
	setCreativeTab(CreativeTabs.tabMaterials);
    }
}
