package myMod.block;

import myMod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RainbowWool extends Block
{
    public RainbowWool()
    {
	super(Material.cloth);
	setBlockName(Reference.RAINBOW_WOOL_UNLOCALIZED_NAME);
	setBlockTextureName(Reference.MOD_ID + ":" + Reference.RAINBOW_WOOL_UNLOCALIZED_NAME);
	setStepSound(soundTypeCloth);
    }
}
