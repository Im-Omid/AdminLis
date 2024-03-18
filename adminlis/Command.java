package org.imomid.adminlis;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] strings) {


        List<String> salam = AdminLis.fileConfiguration.getStringList("adminlist");



        if(sender.isOp()){
            if(strings.length > 0){
                if(salam.contains(strings[0])){
                    salam.remove(strings[0]);
                    AdminLis.fileConfiguration.set("adminlist",salam);
                    AdminLis.getPlugin(AdminLis.class).SaveConfig();
                    sender.sendMessage("Player is removed in adminlist");
                } else {
                    salam.add(strings[0]);
                    AdminLis.fileConfiguration.set("adminlist",salam);
                    AdminLis.getPlugin(AdminLis.class).SaveConfig();
                    sender.sendMessage("Player is added in adminlist");
                }





            } else {
                sender.sendMessage("Wrong ! Usage : /admin <Player>");
            }
        } else {
            sender.sendMessage("You Don't Have Permission");
        }


        return false;
    }
}
