package org.imomid.adminlis;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        List<String> salam = AdminLis.fileConfiguration.getStringList("adminlist");
        if(commandSender.isOp()){
            commandSender.setOp(false);
            commandSender.sendMessage("You Aren't Admin");
        } else if(salam.contains(commandSender.getName())){
            commandSender.setOp(true);
            commandSender.sendMessage("You Are Admin");
        } else {
            commandSender.sendMessage("You Don't Have Permission");
        }


        return false;
    }
}
