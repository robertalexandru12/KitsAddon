package me.robert.kitsaddon.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent
  implements Listener {
  @EventHandler
  public void onQuit(PlayerQuitEvent e) {
    if(ArenaJoinEvent.playersCooldown.containsKey(e.getPlayer().getName()))
    {
    	ArenaJoinEvent.playersCooldown.remove(e.getPlayer().getName());
    	
    }
	e.getPlayer().getInventory().clear();
  }
	
}
