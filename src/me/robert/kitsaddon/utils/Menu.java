package me.robert.kitsaddon.utils;

import java.util.List;
import me.robert.kitsaddon.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Menu
{
  private Main main = (Main)Bukkit.getServer().getPluginManager().getPlugin("KitsAddon");
  
  public ItemStack createItem(String displayName, Material material, List<String> lore) {
    ItemStack i = new ItemStack(material);
    ItemMeta meta = i.getItemMeta();
    meta.setLore(lore);
    meta.setDisplayName(displayName);
    i.setItemMeta(meta);
    return i;
  }
  
  public void createSelector(Player p) {
    String displayName = color.c(this.main.getConfig().getString("Kit Selector.displayname"));
    Material material = Material.valueOf(this.main.getConfig().getString("Kit Selector.material").toUpperCase());
    List<String> lore = color.clore(this.main.getConfig().getStringList("Kit Selector.lore"), "t", p);
    p.getInventory().setItem(this.main.getConfig().getInt("Kit Selector.slot"), createItem(displayName, material, lore));
  }
  
  public void createMenu(Player p) {
    Inventory inventory = Bukkit.createInventory(null, 54, color.c("&8Kit Selector"));


    
    int slot = 0;
    for (String key : this.main.getConfig().getConfigurationSection("Kits").getKeys(false)) {
    
        String displayName = color.c(this.main.getConfig().getString("Kits." + key + ".displayname"));
        Material material = Material.valueOf(this.main.getConfig().getString("Kits." + key + ".material").toUpperCase());
        List<String> lore = color.clore(this.main.getConfig().getStringList("Kits." + key + ".lore"), key, p);
        inventory.setItem(slot, createItem(displayName, material, lore));
        slot++;
       
    } 
    p.openInventory(inventory);
  }
}
