package gregtech.api.threads;import gregtech.api.interfaces.metatileentity.IMetaTileEntity;import gregtech.api.interfaces.tileentity.IGregTechTileEntity;import gregtech.common.tileentities.machines.basic.GT_MetaTileEntity_Terminal;import gregtech.common.tileentities.machines.multi.GT_MetaTileEntity_TeslaTower;import net.minecraft.block.Block;public class GT_Runnable_CheckNearbyBlocks implements Runnable {    public int xCenter,yCenter,zCenter,height;    IGregTechTileEntity baseTile;    Block exeption;    byte meta;    int xp,xm,zp,zm;    int[] aArray;    GT_MetaTileEntity_TeslaTower mTower;    public  GT_Runnable_CheckNearbyBlocks(GT_MetaTileEntity_TeslaTower aTower){        mTower = aTower;        System.out.println("created thread");    }    public int[] getMearbyBlocks(){        for(int i = xCenter-height;i<xCenter+height;i++){            for(int j = zCenter-height;i<zCenter+height;j++) {                for(int h = yCenter-height;i<yCenter+height;h++) {                    if(i>xm&&i<xp&&i>zm&&i<zp) {                        System.out.println("inner "+i+" "+h+" "+j);                        continue;                    }                    Block aBlock = baseTile.getBlock(i,h,j);                    System.out.println("aBlock "+(aBlock!=null));                    if(!(aBlock!=null&&(aBlock!=exeption&&baseTile.getMetaID(i,h,j)!=meta))){                        System.out.println("wrong block!!!");                        return new int[]{i,h,j};                    }                }            }        }        return null;    }    @Override    public void run() {        mTower.getMearbyBlocks();    }}