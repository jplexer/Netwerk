package me.funnyna.netwerk.commands.management;

import me.funnyna.netwerk.Netwerk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

public class TowerManagement {

    public static void TowerManagementCommand(CommandSender commandSender, String[] args) {
        String cmd = args.length == 0 ? "help" : args[0];
        switch (cmd) {
            case "help":
                commandSender.sendMessage("Help will be provided.");
                break;
            case "create":
                Player p = (Player) commandSender;
                Location blockLocation = p.getTargetBlock(null,50).getLocation();

                String sql = "INSERT INTO tower (country, x, y, z) VALUES ('Test', " + blockLocation.getBlockX() +", " + blockLocation.getBlockY() + ", " + blockLocation.getBlockZ()+")";
                try {
                    Netwerk.getPlugin().getDatabase().createStatement().execute(sql);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                commandSender.sendMessage("X: " + blockLocation.getBlockX() + " Y: " + blockLocation.getBlockY() +  " Z: " + blockLocation.getBlockZ());
            case "test":


        }

    }

    public static List<String> TabCompleteCommand(String[] args) {
        return Arrays.asList("help", "create");
    }
}
