package myMod.block;

import myMod.util.Reference;

public class MyOre extends Ore
{
    public MyOre()
    {
	super(Reference.MY_ORE_UNLOCALIZED_NAME);
	setHarvestLevel("pickaxe", 3);
    }
}
