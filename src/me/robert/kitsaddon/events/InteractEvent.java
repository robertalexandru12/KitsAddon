package me.robert.kitsaddon.events;

import me.robert.kitsaddon.Main;
import me.robert.kitsaddon.utils.Menu;
import me.robert.kitsaddon.utils.color;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractEvent implements Listener {
  private Main main = (Main)Bukkit.getServer().getPluginManager().getPlugin("KitsAddon");
  public static final HashMap<UUID, Long> cooldown = new HashMap<UUID, Long>();


  @EventHandler
  public void onInteract(PlayerInteractEvent e) {
    Player p = e.getPlayer();
    if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
      if (e.getItem() != null && 
        !e.getItem().hasItemMeta())
        return;  if (!e.getItem().getItemMeta().hasDisplayName())
        return;  if (e.getItem().getItemMeta().getDisplayName().equals(color.c(this.main.getConfig().getString("Kit Selector.displayname")))) {
        Menu menu = new Menu();
        menu.createMenu(p);
        
      } 
    } 

 }
  
  @EventHandler(priority = EventPriority.NORMAL)
  public void onPlayerUseEP(PlayerInteractEvent e) 
  {
	     Player p = e.getPlayer();
	    
	   if(ArenaJoinEvent.playersCooldown.containsKey(e.getPlayer().getName()))
	   {
	     if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
	    	{
	     	   
	    	       if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
	    	    	   int size = p.getItemInHand().getAmount();
	    	           e.setCancelled(true);
	
	    	           ItemStack epearl = new ItemStack(Material.ENDER_PEARL, size);
	    	           
	    	           p.getInventory().setItemInHand(epearl);
	    	           p.sendMessage(ChatColor.translateAlternateColorCodes('&', Main.plugin.messages.getString("Settings.Cooldown").replace("%time%", ArenaJoinEvent.playersCooldown.get(p.getName()).toString())));
	    	}
	    	}
	  
  }
	     
  }
  }

  
  
}
