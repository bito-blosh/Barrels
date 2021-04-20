package me.john000708.barrels;

import me.john000708.barrels.items.BarrelItems;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.john000708.barrels.listeners.DisplayListener;
import me.john000708.barrels.listeners.WorldListener;
import me.mrCookieSlime.Slimefun.cscorelib2.config.Config;

/**
 * Created by John on 06.05.2016.
 */
public class Barrels extends JavaPlugin implements SlimefunAddon {

    private static Barrels instance;

    public static boolean requirePlastic;
    private boolean displayItem;
    private String itemFormat;

    @Override
    public void onEnable() {
        instance = this;
        Config config = new Config(this);

        // Setting up the Auto-Updater
        /*
        Updater updater = new GitHubBuildsUpdater(this, getFile(), "John000708/Barrels/master");

        if (config.getBoolean("options.auto-update")) {
            updater.start();
        }
        */

        new DisplayListener(this);
        new WorldListener(this);

        displayItem = config.getBoolean("options.displayItem");
        requirePlastic = config.getBoolean("options.plastic-recipe");
        itemFormat = config.getString("options.item-format");

        new BarrelItems().setup(this);
        getLogger().info("Barrels v" + getDescription().getVersion() + " has been enabled!");
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/John000708/Barrels/issues";
    }

    public static Barrels getInstance() {
        return instance;
    }

    public static String getItemFormat() {
        return instance.itemFormat;
    }

    public static boolean isDisplayItemHologram() {
        return instance.displayItem;
    }
}
