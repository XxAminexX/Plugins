package mr.warp.plugin.WarpCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class WarpCommand implements CommandExecutor {
    public String warp = "warp";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        File file = new File("plugins//WarpPlugin//warp.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!(sender instanceof Player)){
            return true;
        } else {
            Player player = (Player) sender;
            if ((player.hasPermission("warpplugin.warp")) && (command.getName().equalsIgnoreCase(warp))){
                if (file.exists()){
                    if (strings.length == 0){
                        player.sendMessage(ChatColor.RED + "/setwarp [name]");
                        return true;
                    }
                    String warpname = strings[0];
                    if (cfg.contains(warpname)){
                        Location loc = player.getLocation();
                        String worldname = (String) cfg.get(warpname + ".World");
                        loc.setX(cfg.getDouble(warpname + ".X"));
                        loc.setY(cfg.getDouble(warpname + ".Y"));
                        loc.setZ(cfg.getDouble(warpname + ".Z"));
                        loc.setYaw((float)cfg.getDouble(warpname + ".Yaw"));
                        loc.setPitch((float)cfg.getDouble(warpname + ".Pitch"));
                        loc.setWorld(Bukkit.getWorld(worldname));
                        player.teleport(loc);
                        player.sendMessage(ChatColor.GREEN + warpname + " Welcome!!");
                        return true;
                    } else {
                        player.sendMessage(ChatColor.RED + "This Warp Can't Be Found!!");
                    }
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "/setwarp [name] first!!");
                }
            }
        }
        return true;
    }
}
