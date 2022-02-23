package me.robert.kitsaddon.utils;

import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class color
{
  public static String c(String mess) { return ChatColor.translateAlternateColorCodes('&', mess); }

  
  public static List<String> clore(List<String> lore, String item, Player p) {
    if (lore.size() > 1) {
      for (int i = 0; i < lore.size(); i++) {
    	  if(p.hasPermission("bedwars.kit." + item))
              lore.set(i, c(lore.get(i).replace("%status%", "Deblocat" )));
    	  else lore.set(i, c(lore.get(i).replace("%status%", "Blocat" )));
      }
    } else {
      
      lore.set(0, c(lore.get(0)));
    } 
    return lore;
  }
}
