package me.robert.kitsaddon.events;

import me.robert.kitsaddon.Main;
import ro.Fr33styler.ClashWars.Api.GameLeaveEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ArenaLeaveEvent
  implements Listener {
  @EventHandler
  public void onLeave(GameLeaveEvent e) 
  {
	  Main.selectedKit.remove(e.getPlayer().getUniqueId());

		if(ArenaJoinEvent.playersCooldown.containsKey(e.getPlayer().getName()))
			ArenaJoinEvent.playersCooldown.remove(e.getPlayer().getName());

  }
}
