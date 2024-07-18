package me.funnyna.netwerk;

import me.funnyna.netwerk.commands.ManagementCommandCompleter;
import me.funnyna.netwerk.commands.ManagementCommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public final class Netwerk extends JavaPlugin {

    private static Netwerk plugin;
    public static final String CHAT_PREFIX = ChatColor.BLUE + "" + ChatColor.BOLD + "Netwerk: " + ChatColor.WHITE;
    private File towerConfigFile;
    private FileConfiguration towerConfig;
    private Connection connection;

    public static Netwerk getPlugin() { // getter for the static plugin instance
        return plugin;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = getPlugin(Netwerk.class);
        prepareDatabase();
        getLogger().info("Netwerk Loaded!");
        getCommand("netwerk").setExecutor(new ManagementCommandHandler());
        getCommand("netwerk").setTabCompleter(new ManagementCommandCompleter());
    }

    private void prepareDatabase() {
        try {
            File dataFolder = new File(plugin.getDataFolder(), "netwerk.db");
            if (!dataFolder.exists()) {
                try {
                    dataFolder.createNewFile();
                } catch (IOException e) {
                    plugin.getLogger().log(Level.SEVERE, "File write error: netwerk.db");
                }
            }
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+ dataFolder);
            this.connection.createStatement().execute("CREATE TABLE IF NOT EXISTS carrier(id INTEGER PRIMARY KEY AUTOINCREMENT, Name STRING, Owner STRING)");
            this.connection.createStatement().execute("CREATE TABLE IF NOT EXISTS tower(id INTEGER PRIMARY KEY AUTOINCREMENT, Country STRING, x INTEGER, y INTEGER, z INTEGER, carrierID INTEGER)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getDatabase() {
        return connection;
    }

    @Override
    public void onDisable() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
