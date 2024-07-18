package me.funnyna.netwerk.commands;

import me.funnyna.netwerk.commands.management.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import me.funnyna.netwerk.CommandUtils;

import java.util.Arrays;
import java.util.List;

public class ManagementCommandCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        String[] args = CommandUtils.getArgs(strings);

        // checks if there are no arguments at all (/netwerk)
       if (args.length == 0) {
            return Arrays.asList("carrier", "tower");
       } else {
           switch (args[0].toLowerCase()) {
               case "tower":
                   return TowerManagement.TabCompleteCommand(Arrays.copyOfRange(args, 1, args.length));
               case "carrier":
                   return CarrierManagement.TabCompleteCommand(Arrays.copyOfRange(args, 1, args.length));
               default:
                   return Arrays.asList("carrier", "tower");
           }
       }

    }
}
