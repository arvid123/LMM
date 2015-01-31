package myMod.item;

import myMod.common.MyMod;
import myMod.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class MyArmor extends ItemArmor
{
    public MyArmor(ArmorMaterial armorMaterial, int par3, int par4)
    {
	super(armorMaterial, par3, par4);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
	if (stack.getItem() == MyMod.myHelmet || stack.getItem() == MyMod.myChestplate|| stack.getItem() == MyMod.myBoots)
	{
	    return Reference.MY_ARMOR_1_TEXTURE;
	} else if (stack.getItem() == MyMod.myLeggings)
	{
	    return Reference.MY_ARMOR_2_TEXTURE;
	} else
	    return null;
    }
}
