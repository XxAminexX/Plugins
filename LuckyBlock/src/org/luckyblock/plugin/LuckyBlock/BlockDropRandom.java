package org.luckyblock.plugin.LuckyBlock;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BlockDropRandom implements Listener {

    @EventHandler
    public void onBreak (BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack luck = new ItemStack(Material.SPONGE);
        ItemMeta Meta = luck.getItemMeta();
        Meta.setDisplayName(ChatColor.GOLD + " " + ChatColor.BOLD + "Lucky Block");
        Meta.addEnchant(Enchantment.ARROW_DAMAGE , 1, true);
        Meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        luck.setItemMeta(Meta);

        if ((block.getType() == Material.SPONGE)){
            block.setType(Material.AIR);
            event.setCancelled(true);
            int ran = ThreadLocalRandom.current().nextInt(10);
            switch (ran){
                case 0:{
                    int armor = ThreadLocalRandom.current().nextInt(4);
                    switch (armor){
                        case 0:{
                            block.getLocation().getWorld().dropItem(block.getLocation() , new ItemStack(Material.DIAMOND_HELMET));
                            break;
                        }
                        case 1:{
                            block.getLocation().getWorld().dropItem(block.getLocation() , new ItemStack(Material.DIAMOND_CHESTPLATE));
                            break;
                        }
                        case 2:{
                            block.getLocation().getWorld().dropItem(block.getLocation() , new ItemStack(Material.DIAMOND_LEGGINGS));
                            break;
                        }
                        case 3:{
                            block.getLocation().getWorld().dropItem(block.getLocation() , new ItemStack(Material.DIAMOND_BOOTS));
                            break;
                        }
                    }
                    break;
                }
                case 1:{
                    int gapple = new Random().nextInt(20);
                    player.setHealth(gapple);
                    for (int i = 0 ; i < gapple ; i++){
                        block.getLocation().getWorld().dropItem(block.getLocation() , new ItemStack(Material.GOLDEN_APPLE));
                    }
                    break;
                }
                case 2:{
                    Location spawnchest = player.getLocation();
                    spawnchest.getBlock().setType(Material.CHEST);
                    Chest chest = (Chest) spawnchest.getBlock().getState();
                    Inventory menu = chest.getInventory();
                    int reffel = new Random().nextInt(3);
                    switch (reffel){
                        case 0:{
                            menu.setItem(0 , luck);
                            menu.setItem(26 , luck);
                            break;
                        }
                        case 1:{
                            ItemStack paper = new ItemStack(Material.PAPER);
                            ItemMeta papermeta = paper.getItemMeta();
                            papermeta.setDisplayName(ChatColor.GREEN + "hhhhhhhh");
                            paper.setItemMeta(papermeta);
                            menu.setItem(13 , paper);
                            break;
                        }
                        case 2:{
                            menu.clear();
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    Location redstone = block.getLocation().add(0 , -1 , 0);
                    Location tnt = block.getLocation().add(0 , 4,0);
                    redstone.getBlock().setType(Material.REDSTONE_BLOCK);
                    int i = 0;
                    int tntfall = new Random().nextInt(64);
                    while (i < tntfall ){
                        block.getLocation().getBlock().getWorld().spawnFallingBlock(tnt , Material.TNT , (byte) 0);
                        i++;
                    }
                    break;
                }
                case 4:{
                    player.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
                    player.setVelocity(new Vector(0 , 3 , 0));
                    break;
                }
                case 5:{
                    ItemStack opsword = new ItemStack(Material.WOODEN_SWORD);
                    ItemMeta op = opsword.getItemMeta();
                    op.setDisplayName(ChatColor.translateAlternateColorCodes('&' , "&d&kA&5&lHero Sword&d&kA"));
                    op.addEnchant(Enchantment.DAMAGE_ALL , 1000 , true);
                    opsword.setItemMeta(op);
                    player.getInventory().addItem(opsword);
                    break;
                }
                case 6:{
                    int diamond = new Random().nextInt(10);
                    switch (diamond){
                        case 0:{
                            int coal = new Random().nextInt(64);
                            for (int i = 0 ; i < coal ; i ++){
                                block.getLocation().getWorld().dropItemNaturally(block.getLocation() , new ItemStack(Material.COAL));
                            }
                            break;
                        }
                        case 1:{
                            int iron = new Random().nextInt(64);
                            for (int i = 0 ; i < iron ; i ++){
                                block.getLocation().getWorld().dropItemNaturally(block.getLocation() , new ItemStack(Material.IRON_INGOT));
                            }
                            break;
                        }
                        case 2:{
                            int gold = new Random().nextInt(64);
                            for (int i = 0 ; i < gold ; i ++){
                                block.getLocation().getWorld().dropItemNaturally(block.getLocation() , new ItemStack(Material.GOLD_INGOT));
                            }
                            break;
                        }
                        case 3:{
                            int dia = new Random().nextInt(64);
                            for (int i = 0 ; i < dia ; i ++){
                                block.getLocation().getWorld().dropItemNaturally(block.getLocation() , new ItemStack(Material.DIAMOND));
                            }
                            break;
                        }
                        case 4:{
                            int eme = new Random().nextInt(64);
                            for (int i = 0 ; i < eme ; i ++){
                                block.getLocation().getWorld().dropItemNaturally(block.getLocation() , new ItemStack(Material.EMERALD));
                            }
                            break;
                        }
                        case 5:{
                            int coalb = new Random().nextInt(64);
                            for (int i = 0 ; i < coalb ; i ++){
                                block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(0 , 3 ,0) , Material.COAL_BLOCK , (byte)0);
                            }
                            break;
                        }
                        case 6:{
                            int ironb = new Random().nextInt(64);
                            for (int i = 0 ; i < ironb ; i ++){
                                block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(0 , 3 ,0) , Material.IRON_BLOCK , (byte)0);
                            }
                            break;
                        }
                        case 7:{
                            int goldb = new Random().nextInt(64);
                            for (int i = 0 ; i < goldb ; i ++){
                                block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(0 , 3 ,0) , Material.GOLD_BLOCK , (byte)0);
                            }
                            break;
                        }
                        case 8:{
                            int diab = new Random().nextInt(64);
                            for (int i = 0 ; i < diab ; i ++){
                                block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(0 , 3 ,0) , Material.DIAMOND_BLOCK , (byte)0);
                            }
                            break;
                        }
                        case 9:{
                            int emeb = new Random().nextInt(64);
                            for (int i = 0 ; i < emeb ; i ++){
                                block.getLocation().getWorld().spawnFallingBlock(block.getLocation().add(0 , 3 ,0) , Material.EMERALD_BLOCK , (byte)0);
                            }
                            break;
                        }

                    }
                    break;
                }
                case 7:{
                    int bat = new Random().nextInt(28);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS , 400 , 2));
                    player.getWorld().spawnEntity(player.getLocation().add(0 , 0, 2) , EntityType.WITCH);
                    player.getWorld().spawnEntity(player.getLocation().add(0 , 0, -2) , EntityType.WITCH);
                    player.getWorld().spawnEntity(player.getLocation().add(2 , 0, 0) , EntityType.WITCH);
                    player.getWorld().spawnEntity(player.getLocation().add(-2 , 0, 0) , EntityType.WITCH);
                    for (int i = 0 ; i < bat ; i++){
                        player.getWorld().spawnEntity(player.getLocation() , EntityType.BAT);
                    }
                    break;
                }
                case 8:{
                    player.getWorld().strikeLightning(player.getLocation());
                    break;
                }
                case 9:{
                    int creepers = new Random().nextInt(20);
                    for (int i = 0 ; i < creepers ; i++){
                        player.getWorld().spawnEntity(player.getLocation() , EntityType.CREEPER);
                        player.getWorld().strikeLightning(player.getLocation());
                    }
                    break;
                }
            }
        }

    }

}
