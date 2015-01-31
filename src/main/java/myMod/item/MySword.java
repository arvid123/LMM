package myMod.item;

import myMod.common.MyMod;
import myMod.util.Reference;
import net.minecraft.item.ItemSword;

public class MySword extends ItemSword 
{

	public MySword()
	{
		// The material which is created in the MyMod main class.
		super(MyMod.myMaterial);
		// This is the identifier of this item.
		setUnlocalizedName(Reference.MY_SWORD_UNLOCALIZED_NAME);
		// This tells Minecraft where the texture for this item is located.
		setTextureName(Reference.MOD_ID + ":" + getUnlocalizedName());
	}
}
