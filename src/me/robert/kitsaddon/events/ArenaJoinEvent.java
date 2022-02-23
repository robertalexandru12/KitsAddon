package me.robert.kitsaddon.events;
import me.robert.kitsaddon.Main;
import me.robert.kitsaddon.utils.Menu;
import ro.Fr33styler.ClashWars.Api.GameEndEvent;
import ro.Fr33styler.ClashWars.Api.GameJoinEvent;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ArenaJoinEvent implements Listener {
	
	public static Plugin pl;
    public static HashMap<String, Integer> playersCooldown = new HashMap<String, Integer>();
  
	  @EventHandler
	  public void onJoin(GameJoinEvent e) {

		  if(playersCooldown.containsKey(e.getPlayer().getName()))
			playersCooldown.remove(e.getPlayer().getName());
		  
		  
		    (new BukkitRunnable()
		      {
		        public void run() {
		          final Player p = e.getPlayer();
		          
		          Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "fly " + e.getPlayer().getName() + " disable"); 
					  List<String> worlds = Main.plugin.messages.getStringList("Disabled-Worlds");
					  for(String s : worlds)
					  {
						  if(e.getPlayer().getWorld().getName().equalsIgnoreCase(s)) 
							  {
							     cancel();
							     return ;
								
							  }
					  }
				
		          Menu menu = new Menu();
		          menu.createSelector(p);
		          final Location[] current = new Location[1];
		          final Location[] first = new Location[1];
		          (new BukkitRunnable()
		            {
		              public void run() {
		                Player player = p;
		                if (!player.isOnline()) {
		                  cancel();
		                  return;
		                } 
		                current[0] = player.getLocation();
		                if (first[0] == null) {
		                  first[0] = current[0];
		                } else {
		                  if (current[0].getWorld() != first[0].getWorld()) {
		                    cancel();
		                    return;
		                  } 
		                  if (current[0].getY() < first[0].getY() - 1.0D && 
		                    Main.selectedKit.containsKey(p.getUniqueId())) 
		                  {
		                        Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "kit " + (String)Main.selectedKit.get(p.getPlayer().getUniqueId()) + " " + p.getPlayer().getName());
		                        Main.selectedKit.remove(p.getUniqueId());

		                    enderPearlCooldown(player);
		                    cancel();
		                    
		                  }
		                
		                } 
		              }
		            }).runTaskTimer(Main.plugin, 0L, 1L);
		        }
		      }).runTaskLater(Main.plugin, 2L);
	       
	
	  }
	public static void enderPearlCooldown(Player p) {
		
		
		
		playersCooldown.put(p.getName(), 30);
		

		//Main.plugin.coolodown.set(p.getName(), true);
		//Main.saveConfig(Main.plugin.coolodown, Main.plugin.cooldownFile);
	
		
        Thread thread = new Thread(new Runnable () {

           
        	
            public void run() {

                String time;
                for (int i=30 ; i >= 1; i--) {
                	if(playersCooldown.get(p.getName())==1)
                	{
                		playersCooldown.remove(p.getName());
                		return;
                		
                	}
                	if(i>3) playersCooldown.put(p.getName(), i);

                	if(i==3)
                	{
                		//Main.saveConfig(Main.plugin.coolodown, Main.plugin.cooldownFile);
                		playersCooldown.remove(p.getName());
                	}
                	

                        try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

                }

          
            }});
        thread.start();
    }
	public void end(GameEndEvent e)
	{
		
	}
}