package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.entity.item.EntityFirework;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockFace;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.DoubleTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;

/**
 * @author CreeperFace
 */
public class ItemFireworks extends Item {

    public ItemFireworks() {
        this(0);
    }

    public ItemFireworks(Integer meta) {
        this(meta, 1);
    }

    public ItemFireworks(Integer meta, int count) {
        super(FIREWORKS, meta, count, "Fireworks");
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz) {
        if (block.canPassThrough()) {
            CompoundTag nbt = new CompoundTag()
                    .putList(new ListTag<DoubleTag>("Pos")
                            .add(new DoubleTag("", block.x + 0.5))
                            .add(new DoubleTag("", block.y + 0.5))
                            .add(new DoubleTag("", block.z + 0.5)))
                    .putList(new ListTag<DoubleTag>("Motion")
                            .add(new DoubleTag("", 0))
                            .add(new DoubleTag("", 0))
                            .add(new DoubleTag("", 0)))
                    .putList(new ListTag<FloatTag>("Rotation")
                            .add(new FloatTag("", 0))
                            .add(new FloatTag("", 0)));

            EntityFirework entity = new EntityFirework(level.getChunk(block.getFloorX() >> 4, block.getFloorZ() >> 4), nbt);
            entity.spawnToAll();

            return true;
        }

        return false;
    }
}
