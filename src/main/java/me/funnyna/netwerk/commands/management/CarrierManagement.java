package me.funnyna.netwerk.commands.management;

import me.funnyna.netwerk.Netwerk;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarrierManagement {

    public static void CarrierManagementCommand(CommandSender commandSender, String[] args) {
        String cmd = args.length == 0 ? "help" : args[0];
        switch (cmd) {
            case "help":
                commandSender.sendMessage("Help will be provided.");
                break;
            case "create":
                commandSender.sendMessage("Test");
                break;
        }

    }

    public static List<String> TabCompleteCommand(String[] args) {
        return Arrays.asList("help", "create");
    }
}
