package myMod.item;

import myMod.util.Reference;
import net.minecraft.item.*;

public class MyFood extends ItemFood
{

    public MyFood(int healAmount, boolean isWolfsFavoriteMeat, String textureName)
    {
	super(healAmount, isWolfsFavoriteMeat);
	setTextureName(textureName);
    }

}
