package myMod.item;

import java.util.Set;

import myMod.common.MyMod;
import myMod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

public class MyPickaxe extends ItemTool
{
	private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{Blocks.cobblestone, Blocks.double_stone_slab, Blocks.stone_slab, Blocks.stone, Blocks.sandstone, Blocks.mossy_cobblestone, Blocks.iron_ore, Blocks.iron_block, Blocks.coal_ore, Blocks.gold_block, Blocks.gold_ore, Blocks.diamond_ore, Blocks.diamond_block, Blocks.ice, Blocks.netherrack, Blocks.lapis_ore, Blocks.lapis_block, Blocks.redstone_ore, Blocks.lit_redstone_ore, Blocks.rail, Blocks.detector_rail, Blocks.golden_rail, Blocks.activator_rail});

	public MyPickaxe()
	{
		/* 
		 * The zero denotes if the item should do any extra damage in addition to the default for iron tools.
		 * The ToolMaterial.IRON just means that this tool is made out of our own material that we made.
		 * The blocksEffectiveAgainst is an array of blocks which tells Minecraft which blocks this pickaxe will be able to mine efficiently.
		*/
		super(0, ToolMaterial.IRON, blocksEffectiveAgainst);
		// The identifier of this item.
		setUnlocalizedName(Reference.MY_PICKAXE_UNLOCALIZED_NAME);
		// The harvest level of the pickaxe, "pickaxe" means it's a pickaxe and the "2" means it can mine the same ores as an iron pickaxe.
		setHarvestLevel("pickaxe", 2);
	}
}
