package myMod.entity;

import java.util.ArrayList;
import java.util.Random;

import myMod.common.MyMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityRainbowSheep extends EntityAnimal implements IShearable
{
    private final InventoryCrafting field_90016_e = new InventoryCrafting(new Container()
    {
	private static final String __OBFID = "CL_00001649";

	public boolean canInteractWith(EntityPlayer p_75145_1_)
	{
	    return false;
	}
    }, 2, 1);
    /**
     * Used to control movement as well as wool regrowth. Set to 40 on
     * handleHealthUpdate and counts down with each tick.
     */
    private int sheepTimer;
    private EntityAIEatGrass field_146087_bs = new EntityAIEatGrass(this);
    private static final String __OBFID = "CL_00001648";

    public EntityRainbowSheep(World p_i1691_1_)
    {
	super(p_i1691_1_);
	this.setSize(0.9F, 1.3F);
	this.getNavigator().setAvoidsWater(true);
	this.tasks.addTask(0, new EntityAISwimming(this));
	this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
	this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
	this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.wheat, false));
	this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
	this.tasks.addTask(5, this.field_146087_bs);
	this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
	this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	this.tasks.addTask(8, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
	return true;
    }

    protected void updateAITasks()
    {
	this.sheepTimer = this.field_146087_bs.func_151499_f();
	super.updateAITasks();
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
	if (this.worldObj.isRemote)
	{
	    this.sheepTimer = Math.max(0, this.sheepTimer - 1);
	}

	super.onLivingUpdate();
    }

    protected void applyEntityAttributes()
    {
	super.applyEntityAttributes();
	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    }

    protected void entityInit()
    {
	super.entityInit();
	this.dataWatcher.addObject(16, new Byte((byte)0));
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity
     * has recently been hit by a player. @param par2 - Level of Looting used to
     * kill this mob.
     */
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
    {
	if (!this.getSheared())
	{
	    this.entityDropItem(new ItemStack(MyMod.rainbowWool, 1), 0.0F);
	}
    }

    protected Item getDropItem()
    {
	return Item.getItemFromBlock(MyMod.rainbowWool);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
	if (p_70103_1_ == 10)
	{
	    this.sheepTimer = 40;
	} else
	{
	    super.handleHealthUpdate(p_70103_1_);
	}
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow,
     * gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer p_70085_1_)
    {
	return super.interact(p_70085_1_);
    }

    @SideOnly(Side.CLIENT)
    public float func_70894_j(float p_70894_1_)
    {
	return this.sheepTimer <= 0 ? 0.0F : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0F : (this.sheepTimer < 4 ? ((float) this.sheepTimer - p_70894_1_) / 4.0F : -((float) (this.sheepTimer - 40) - p_70894_1_) / 4.0F));
    }

    @SideOnly(Side.CLIENT)
    public float func_70890_k(float p_70890_1_)
    {
	if (this.sheepTimer > 4 && this.sheepTimer <= 36)
	{
	    float f1 = ((float) (this.sheepTimer - 4) - p_70890_1_) / 32.0F;
	    return ((float) Math.PI / 5F) + ((float) Math.PI * 7F / 100F) * MathHelper.sin(f1 * 28.7F);
	} else
	{
	    return this.sheepTimer > 0 ? ((float) Math.PI / 5F) : this.rotationPitch / (180F / (float) Math.PI);
	}
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
	super.writeEntityToNBT(p_70014_1_);
	p_70014_1_.setBoolean("Sheared", this.getSheared());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
	super.readEntityFromNBT(p_70037_1_);
	this.setSheared(p_70037_1_.getBoolean("Sheared"));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
	return "mob.sheep.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
	return "mob.sheep.say";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
	return "mob.sheep.say";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
	this.playSound("mob.sheep.step", 0.15F, 1.0F);
    }

    /**
     * returns true if a sheeps wool has been sheared
     */
    public boolean getSheared()
    {
	return (this.dataWatcher.getWatchableObjectByte(16) & 16) != 0;
    }

    /**
     * make a sheep sheared if set to true
     */
    public void setSheared(boolean p_70893_1_)
    {
	byte b0 = this.dataWatcher.getWatchableObjectByte(16);

	if (p_70893_1_)
	{
	    this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 | 16)));
	} else
	{
	    this.dataWatcher.updateObject(16, Byte.valueOf((byte) (b0 & -17)));
	}
    }

    public EntityRainbowSheep createChild(EntityAgeable p_90011_1_)
    {
	return new EntityRainbowSheep(worldObj);
    }

    /**
     * This function applies the benefits of growing back wool and faster
     * growing up to the acting entity. (This function is used in the
     * AIEatGrass)
     */
    public void eatGrassBonus()
    {
	this.setSheared(false);

	if (this.isChild())
	{
	    this.addGrowth(60);
	}
    }

    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
	p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
	return p_110161_1_;
    }

    private int func_90014_a(EntityAnimal p_90014_1_, EntityAnimal p_90014_2_)
    {
	return (new Random().nextInt(16));
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z)
    {
	return !getSheared() && !isChild();
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune)
    {
	ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
	setSheared(true);
	ret.add(new ItemStack(MyMod.rainbowWool));
	this.playSound("mob.sheep.shear", 1.0F, 1.0F);
	return ret;
    }
}
