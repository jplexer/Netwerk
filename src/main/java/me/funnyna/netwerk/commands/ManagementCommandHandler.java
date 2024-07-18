package me.funnyna.netwerk.commands;

import me.funnyna.netwerk.CommandUtils;
import me.funnyna.netwerk.commands.management.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static me.funnyna.netwerk.Netwerk.CHAT_PREFIX;

public class ManagementCommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String[] args = CommandUtils.getArgs(strings);

        // checks if there are no arguments at all (/command)
        if (args.length == 0) {
            commandSender.sendMessage(CHAT_PREFIX + ChatColor.RED + "Invalid usage - there are no arguments.");
            return false;
        }
        switch (args[0].toLowerCase()) {
            case "tower":
                TowerManagement.TowerManagementCommand(commandSender, Arrays.copyOfRange(args, 1, args.length));
                return true;
            case "carrier":
                CarrierManagement.CarrierManagementCommand(commandSender, Arrays.copyOfRange(args, 1, args.length));
                return true;
            default:
                commandSender.sendMessage(CHAT_PREFIX + ChatColor.RED + "Sorry, \"" + args[0] + "\" is not a valid command.");
                return true;
        }
    }

}
