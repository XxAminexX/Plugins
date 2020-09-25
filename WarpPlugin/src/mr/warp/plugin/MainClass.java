package mr.warp.plugin;

import mr.warp.plugin.WarpCommand.SetWarp;
import mr.warp.plugin.WarpCommand.WarpCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    public void onEnable(){
        onCommands();
    }

    public void onCommands(){
        SetWarp setWarp = new SetWarp();
        WarpCommand warpCommand = new WarpCommand();
        getCommand(setWarp.setwarp).setExecutor(setWarp);
        getCommand(warpCommand.warp).setExecutor(warpCommand);
    }
}
