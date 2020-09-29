package org.luckyblock.plugin.LuckyBlock;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GiveCommand implements CommandExecutor {
    public String luckyblock = "luckyblock";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player)){
            return true;
        } else {
            Player player = (Player) sender;
            ItemStack luck = new ItemStack(Material.SPONGE);
            ItemMeta Meta = luck.getItemMeta();
            Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&' , "&6&kA&e&lLucky Block &6&kA"));
            Meta.addEnchant(Enchantment.ARROW_DAMAGE , 1, true);
            Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ArrayList<String> lord = new ArrayList<>();
            lord.add(" ");
            lord.add(ChatColor .WHITE + "->" + ChatColor.BOLD + " This Block: ");
            lord.add(ChatColor.WHITE + "|->" + ChatColor.YELLOW + " MayBe Good!!");
            lord.add(ChatColor.WHITE + "|->" + ChatColor.RED + " MayBe Bad!!");
            Meta.setLore(lord);
            luck.setItemMeta(Meta);
            if ((player.hasPermission("luckyblock.give")) && (command.getName().equalsIgnoreCase(luckyblock))){
                if (strings.length == 0){
                    player.sendMessage(ChatColor.BOLD + "/luckyblock [number]");
                    return true;
                }
                if (strings.length == 1){
                    int num = Integer.parseInt(strings[0]);
                    for (int i = 0 ; i < num ; i++){
                        player.getInventory().addItem(luck);
                    }
                }
                return true;
            } else {
                player.sendMessage(ChatColor.RED + " " + ChatColor.BOLD + "You Don't Have Permission To Run This Command!!");
            }
        }

        return true;
    }
}
