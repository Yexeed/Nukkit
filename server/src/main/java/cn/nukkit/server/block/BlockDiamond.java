package cn.nukkit.server.block;

import cn.nukkit.server.item.Item;
import cn.nukkit.server.item.ItemTool;
import cn.nukkit.server.utils.BlockColor;

/**
 * @author Nukkit Project Team
 */
public class BlockDiamond extends BlockSolid {

    public BlockDiamond(int meta) {
        super(0);
    }

    public BlockDiamond() {
        this(0);
    }

    @Override
    public double getHardness() {
        return 5;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getId() {
        return DIAMOND_BLOCK;
    }

    @Override
    public String getName() {
        return "Diamond BlockType";
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() > ItemTool.TIER_IRON) {
            return new Item[]{
                    toItem()
            };
        } else {
            return new Item[0];
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIAMOND_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }
}