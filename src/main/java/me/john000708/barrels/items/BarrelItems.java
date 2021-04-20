package me.john000708.barrels.items;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.john000708.barrels.Barrels;
import me.john000708.barrels.block.Barrel;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class BarrelItems {

    // Barrel
    public static final SlimefunItemStack barrelSmall = new SlimefunItemStack("BARREL_SMALL", Material.OAK_LOG, "&9Barrel &7- &eSmall", "", "&8\u21E8 &7Capacity: 64 Stacks");
    public static final SlimefunItemStack barrelMedium = new SlimefunItemStack("BARREL_MEDIUM", Material.SPRUCE_LOG, "&9Barrel &7- &eMedium", "", "&8\u21E8 &7Capacity: 128 Stacks");
    public static final SlimefunItemStack barrelBig = new SlimefunItemStack("BARREL_BIG", Material.DARK_OAK_LOG, "&9Barrel &7- &eBig", "", "&8\u21E8 &7Capacity: 256 Stacks");
    public static final SlimefunItemStack barrelLarge = new SlimefunItemStack("BARREL_LARGE", Material.ACACIA_LOG, "&9Barrel &7- &eLarge", "", "&8\u21E8 &7Capacity: 512 Stacks");
    public static final SlimefunItemStack deepStorageUnit = new SlimefunItemStack("BARREL_GIGANTIC", Material.DIAMOND_BLOCK, "&3Deep Storage Unit", "", "&4End-Game Storage Solution", "", "&8\u21E8 &7Capacity: 1048576 Stacks");

    // Upgrades
    public static final SlimefunItemStack biometricProtectionModule = new SlimefunItemStack("BARREL_BIO_PROTECTION", Material.ITEM_FRAME, "&9Biometric Protection", "", "&fPrevents other people", "&ffrom accessing your barrel.");
    public static final SlimefunItemStack idCard = new SlimefunItemStack("BARREL_ID_CARD", Material.PAPER, "&fID Card", "", "&fRight click to bind.");
    public static final SlimefunItemStack structUpgrade1 = new SlimefunItemStack("STRUCT_UPGRADE_1", Material.ITEM_FRAME, "&9Structural Upgrade &7- &eI", "&bSmall &8\u21E8 &bMedium");
    public static final SlimefunItemStack structUpgrade2 = new SlimefunItemStack("STRUCT_UPGRADE_2", Material.ITEM_FRAME, "&9Structural Upgrade &7- &eII", "&bMedium &8\u21E8 &bBig");
    public static final SlimefunItemStack structUpgrade3 = new SlimefunItemStack("STRUCT_UPGRADE_3", Material.ITEM_FRAME, "&9Structural Upgrade &7- &eIII", "&bBig &8\u21E8 &bLarge");


    public void setup(Barrels plugin) {
        Category barrelCat = new Category(new NamespacedKey(plugin, "barrels"), new CustomItem(Material.OAK_LOG, "&aBarrels", "", "&a> Click to open"), 2);

        new Barrel(barrelCat, barrelSmall, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.OAK_SLAB), Barrels.requirePlastic ? SlimefunItems.PLASTIC_SHEET : new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.CHEST), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), SlimefunItems.GILDED_IRON, new ItemStack(Material.OAK_SLAB) }, 4096).register(plugin);
        new Barrel(barrelCat, barrelMedium, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.OAK_SLAB), Barrels.requirePlastic ? SlimefunItems.PLASTIC_SHEET : new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), barrelSmall, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), SlimefunItems.GILDED_IRON, new ItemStack(Material.OAK_SLAB) }, 8192).register(plugin);
        new Barrel(barrelCat, barrelBig, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.OAK_SLAB), Barrels.requirePlastic ? SlimefunItems.PLASTIC_SHEET : new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), barrelMedium, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), SlimefunItems.GILDED_IRON, new ItemStack(Material.OAK_SLAB) }, 16384).register(plugin);
        new Barrel(barrelCat, barrelLarge, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.OAK_SLAB), Barrels.requirePlastic ? SlimefunItems.PLASTIC_SHEET : new ItemStack(Material.CAULDRON), new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), barrelBig, new ItemStack(Material.OAK_SLAB), new ItemStack(Material.OAK_SLAB), SlimefunItems.GILDED_IRON, new ItemStack(Material.OAK_SLAB) }, 32768).register(plugin);
        new Barrel(barrelCat, deepStorageUnit, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.ENDER_CHEST), SlimefunItems.REINFORCED_PLATE, SlimefunItems.PLASTIC_SHEET, barrelLarge, SlimefunItems.PLASTIC_SHEET, SlimefunItems.REINFORCED_PLATE, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE }, 1048576) {}.register(plugin);


        new BarrelModule(barrelCat, structUpgrade1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, barrelMedium, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT }) {

            @Override
            public boolean applyUpgrade(Block b) {
                if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_1") != null) {
                    return false;
                }

                int capacity = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), "capacity"));
                BlockStorage.addBlockInfo(b, "STRUCT_1", "true");
                BlockStorage.addBlockInfo(b, "capacity", String.valueOf(capacity + 8192));
                return true;
            }

        }.register(plugin);

        new BarrelModule(barrelCat, structUpgrade2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, barrelBig, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT }) {

            @Override
            public boolean applyUpgrade(Block b) {
                if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_2") != null) {
                    return false;
                }

                int capacity = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), "capacity"));
                BlockStorage.addBlockInfo(b, "STRUCT_2", "true");
                BlockStorage.addBlockInfo(b, "capacity", String.valueOf(capacity + 16384));
                return true;
            }

        }.register(plugin);

        new BarrelModule(barrelCat, structUpgrade3, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, barrelLarge, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT }) {

            @Override
            public boolean applyUpgrade(Block b) {
                if (BlockStorage.getLocationInfo(b.getLocation(), "STRUCT_3") != null) {
                    return false;
                }

                int capacity = Integer.parseInt(BlockStorage.getLocationInfo(b.getLocation(), "capacity"));
                BlockStorage.addBlockInfo(b, "STRUCT_3", "true");
                BlockStorage.addBlockInfo(b, "capacity", String.valueOf(capacity + 32768));
                return true;
            }

        }.register(plugin);

        new BarrelModule(barrelCat, biometricProtectionModule, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.REDSTONE), new ItemStack(Material.DIAMOND), new ItemStack(Material.REDSTONE), new ItemStack(Material.DIAMOND), new ItemStack(Material.PAPER), new ItemStack(Material.DIAMOND), new ItemStack(Material.REDSTONE), new ItemStack(Material.DIAMOND), new ItemStack(Material.REDSTONE) }) {

            @Override
            public boolean applyUpgrade(Block b) {
                if (BlockStorage.getLocationInfo(b.getLocation(), "protected") != null) {
                    return false;
                }

                BlockStorage.addBlockInfo(b, "protected", "true");
                return true;
            }

        }.register(plugin);

        new IDCard(barrelCat, idCard, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { new ItemStack(Material.REDSTONE), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.REDSTONE), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.PAPER), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.REDSTONE), new ItemStack(Material.GOLD_NUGGET), new ItemStack(Material.REDSTONE) }).register(plugin);
    }

}
