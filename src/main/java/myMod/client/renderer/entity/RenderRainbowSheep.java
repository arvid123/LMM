package myMod.client.renderer.entity;

import myMod.entity.EntityRainbowSheep;
import myMod.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRainbowSheep extends RenderLiving
{
    private static final ResourceLocation sheepTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/sheep/rainbowSheep_fur.png");
    private static final ResourceLocation shearedSheepTextures = new ResourceLocation(Reference.MOD_ID + ":" + "textures/entity/sheep/rainbowSheep.png");
    private static final String __OBFID = "CL_00001021";

    public RenderRainbowSheep(ModelBase p_i1266_1_, ModelBase p_i1266_2_, float p_i1266_3_)
    {
        super(p_i1266_1_, p_i1266_3_);
        this.setRenderPassModel(p_i1266_2_);
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityRainbowSheep entity, int p_77032_2_, float p_77032_3_)
    {
	System.out.println(p_77032_2_);
        if (p_77032_2_ == 2 && !entity.getSheared())
        {
            this.bindTexture(sheepTextures);

            if (entity.hasCustomNameTag() && ("jeb_".equals(entity.getCustomNameTag()) || "arvid1235".equals(entity.getCustomNameTag())))
            {
                boolean flag = true;
            }

            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityRainbowSheep p_110775_1_)
    {
        return shearedSheepTextures;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityRainbowSheep)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityRainbowSheep)p_110775_1_);
    }
}
