package com.example.foliacakefix;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Cake;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

import java.util.EnumSet;
import java.util.Set;

public class CakePlaceListener implements Listener {

    private final Plugin a;

    private static final Set<BlockFace> b = EnumSet.of(
            BlockFace.NORTH, BlockFace.SOUTH, BlockFace.EAST, BlockFace.WEST
    );

    public CakePlaceListener(Plugin a) {
        this.a = a;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void c(BlockPlaceEvent d) {
        Block e = d.getBlockPlaced();
        if (e.getType() != Material.CAKE) return;

        Location f = e.getLocation().clone();
        BlockData g = e.getBlockData().clone();

        Bukkit.getRegionScheduler().runDelayed(a, f, h -> {
            Block i = f.getBlock();
            if (i.getType() != Material.CAKE) return;
            if (!j(g, i.getBlockData())) return;

            for (BlockFace k : b) {
                Block l = i.getRelative(k);
                if (l.getType() == Material.COMPARATOR
                        && m(l, k.getOppositeFace())) {
                    n(l);
                }

                Block o = i.getRelative(k);
                if (o.getType().isOccluding()) {
                    Block p = o.getRelative(k);
                    if (p.getType() == Material.COMPARATOR
                            && m(p, k.getOppositeFace())) {
                        n(p);
                        q(o);
                    }
                }
            }
        }, 1L);
    }

    private boolean m(Block r, BlockFace s) {
        if (r.getType() != Material.COMPARATOR) return false;
        try {
            org.bukkit.block.data.type.Comparator t =
                    (org.bukkit.block.data.type.Comparator) r.getBlockData();
            return t.getFacing() == s.getOppositeFace();
        } catch (ClassCastException u) {
            return false;
        }
    }

    private void n(Block v) {
        Location w = v.getLocation().clone();
        Bukkit.getRegionScheduler().runDelayed(a, w, h -> {
            Block x = w.getBlock();
            if (x.getType() != Material.COMPARATOR) return;
            x.setBlockData(x.getBlockData(), false);
            for (BlockFace k : b) {
                Block y = x.getRelative(k);
                if (y.getType() != Material.AIR) q(y);
            }
        }, 1L);
    }

    private void q(Block z) {
        Location aa = z.getLocation().clone();
        Bukkit.getRegionScheduler().runDelayed(a, aa, h -> {
            Block ab = aa.getBlock();
            ab.setBlockData(ab.getBlockData(), false);
        }, 1L);
    }

    private boolean j(BlockData ac, BlockData ad) {
        if (!(ac instanceof Cake) || !(ad instanceof Cake)) return false;
        return ((Cake) ac).getBites() == ((Cake) ad).getBites();
    }
}