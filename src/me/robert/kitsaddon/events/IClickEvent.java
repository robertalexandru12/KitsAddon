package me.robert.kitsaddon.events;

import java.util.UUID;
import me.robert.kitsaddon.Main;
import me.robert.kitsaddon.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class IClickEvent
  implements Listener {
  private Main main = (Main)Bukkit.getServer().getPluginManager().getPlugin("KitsAddon");
  
  private void selectKit(String displayName, UUID uuid, Player p) {
	  
    for (String key : this.main.getConfig().getConfigurationSection("Kits").getKeys(false)) {
      if (displayName.equals(color.c(this.main.getConfig().getString("Kits." + key + ".displayname")))) {
          if(!p.hasPermission("bedwars.kit." + key.toString()))
          {
        	  p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.messages.getString("Settings.NoPermission")));
        	  return;
          }
    	  Main.selectedKit.put(uuid, key);
    	  p.sendMessage(color.c(this.main.getConfig().getString("KitSelectat")));
      }
    } 
  }
  
  @EventHandler
  public void onCLick(InventoryClickEvent e) {
    Player p = (Player)e.getWhoClicked();
    if (e.getCurrentItem() == null)
      return; 
    if (!e.getView().getTitle().equals(color.c("&8Kit Selector")))
      return;  
    if (e.getClick().isLeftClick() || e.getClick().isRightClick()) {
      if (!e.getCurrentItem().hasItemMeta())
        return;  
      if (!e.getCurrentItem().getItemMeta().hasDisplayName())
        return;  
      if (Main.selectedKit.containsKey(p.getUniqueId())) {
        Main.selectedKit.remove(p.getUniqueId());
      }

      selectKit(e.getCurrentItem().getItemMeta().getDisplayName(), p.getUniqueId(), p);
      e.setCancelled(true);
      p.closeInventory();
      }
      else {
      
      e.setCancelled(true);
    } 
  }
}
