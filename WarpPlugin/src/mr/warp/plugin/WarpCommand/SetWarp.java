package mr.warp.plugin.WarpCommand;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SetWarp implements CommandExecutor {
    public String setwarp = "setwarp";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        File warp = new File("plugins//WarpPlugin");
        File file = new File("plugins//WarpPlugin//warp.yml");
        if (!warp.exists()){
            warp.mkdir();
        }
        if (!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (!(sender instanceof Player)){
            return true;
        } else {
            Player player = (Player) sender;
            if ((player.hasPermission("warpplugin.set")) && (command.getName().equalsIgnoreCase(setwarp))){
                Location loc = player.getLocation();
                if (strings.length == 0){
                    player.sendMessage(ChatColor.RED + "/setwarp [name]");
                    return true;
                }
                String warpname = strings[0];
                cfg.set((warpname + ".X") , loc.getX());
                cfg.set((warpname + ".Y") , loc.getY());
                cfg.set((warpname + ".Z") , loc.getZ());
                cfg.set((warpname + ".Yaw") , loc.getYaw());
                cfg.set((warpname + ".Pitch") , loc.getPitch());
                cfg.set((warpname + ".World") , loc.getWorld().getName());
                player.sendMessage(ChatColor.BOLD + warpname + " Has Been Set Succesffuly!!");
                try{
                    cfg.save(file);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
