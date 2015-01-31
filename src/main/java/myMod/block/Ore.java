package myMod.block;

import myMod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class Ore extends Block
{
    public Ore(String unlocalizedName)
    {
	// Calls the super class's constructor and indicates that your ore is of the iron material.
	super(Material.iron);
	// Set the hardness of the block to determine how hard it is to mine.
	setHardness(3.5f);
	// This is the resistance to explosions.
	setResistance(5.0f);
	// The sound the block makes when you step on it.
	setStepSound(Block.soundTypeStone);
	// Unlocalized name.
	setBlockName(unlocalizedName);
	// Setting the creative tab to the block tab.
	setCreativeTab(CreativeTabs.tabBlock);
	// Location of the texture.
	setBlockTextureName(Reference.MOD_ID + ":" + unlocalizedName);
	// Which tool you need to harvest this ore.
	setHarvestLevel("pickaxe", 2);
    }
}
