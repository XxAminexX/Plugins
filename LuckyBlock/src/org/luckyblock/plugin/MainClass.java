package org.luckyblock.plugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.luckyblock.plugin.LuckyBlock.BlockDropRandom;
import org.luckyblock.plugin.LuckyBlock.GiveCommand;

public class MainClass extends JavaPlugin {

    public void onEnable(){
        System.out.println("\033[32mLucky Block Enable\033[37m");
        onCommands();
        onListeners();
        saveDefaultConfig();
    }

    public void onCommands(){
        GiveCommand giveCommand = new GiveCommand();
        getCommand(giveCommand.luckyblock).setExecutor(giveCommand);
    }

    public void onListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new BlockDropRandom() , this);
    }

}
