package me.john000708.barrels.block;

import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import me.john000708.barrels.items.BarrelItems;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import me.john000708.barrels.DisplayItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

import java.util.List;

class BarrelsBlockHandler extends BlockBreakHandler {

    private final Barrel barrel;

    public BarrelsBlockHandler(Barrel barrel, boolean allowAndroids, boolean allowExplosions) {
        super(allowAndroids, allowExplosions);
        this.barrel = barrel;
    }

    @Override
    public void onPlayerBreak(BlockBreakEvent e, ItemStack tool, List<ItemStack> drops) {
        Player player = e.getPlayer();
        Block b = e.getBlock();

        // Only the Owner or OP-Player may break this Barrel
        String owner = BlockStorage.getLocationInfo(b.getLocation(), "owner");
        if (!player.isOp() && owner != null && !owner.equals(player.getUniqueId().toString())) {
            e.setCancelled(true);
            return;
        }

        DisplayItem.removeDisplayItem(b);

        BlockMenu inv = BlockStorage.getInventory(b);


        if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_1") != null) {
            drops.add(BarrelItems.structUpgrade1);
        }

        if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_2") != null) {
            drops.add(BarrelItems.structUpgrade2);
        }

        if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_3") != null) {
            drops.add(BarrelItems.structUpgrade3);
        }

        if (BlockStorage.getLocationInfo(b.getLocation(), "protected") != null) {
            drops.add(BarrelItems.biometricProtectionModule);
        }

        for (int slot : barrel.getInputSlots()) {
            drops.add(inv.getItemInSlot(slot));
        }
        for (int slot : barrel.getOutputSlots()) {
            drops.add(inv.getItemInSlot(slot));
        }

        String storedAmountString = BlockStorage.getLocationInfo(b.getLocation(), "storedItems");
        if (storedAmountString == null) {
            return;
        }
        int storedAmount = Integer.parseInt(storedAmountString);

        ItemStack itemStored = inv.getItemInSlot(22);

        while (storedAmount > 0) {
            int amount = Math.min(storedAmount, itemStored.getMaxStackSize());
            storedAmount -= amount;

            drops.add(new CustomItem(itemStored, amount));
        }
        BlockStorage.addBlockInfo(b, "storedItems", null);
    }

}
