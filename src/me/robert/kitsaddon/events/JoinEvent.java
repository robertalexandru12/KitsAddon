package me.robert.kitsaddon.events;

import org.bukkit.event.Listener;

public class JoinEvent implements Listener {
	
	
	 /*@EventHandler
	public void PlayerJoin(PlayerJoinEvent e)
	{
		 if(!e.getPlayer().hasPlayedBefore())
		{
			 //Main.plugin.statistics.set(e.getPlayer().getName() + ".Kills", 0);
			 //Main.plugin.statistics.set(e.getPlayer().getName() + ".Deaths", 0);
			 //Main.saveConfig(Main.plugin.statistics, Main.plugin.statisticsFile);
			 Main.plugin.coolodown.addDefault(e.getPlayer().getName(), false);
		     Main.plugin.coolodown.options().copyDefaults(true);
		     Main.saveConfig(Main.plugin.coolodown, Main.plugin.cooldownFile);
		     
			    /*if(Main.mysqlConn)
			    {
			    	try
			    	{
			    		
			          Main.statement = Main.conn.createStatement();
			    		String add = "INSERT INTO robyyyyyy (NAME, KILLS) VALUES ('" + e.getPlayer().getName()+ "', '0')";
			    	
			    		        Main.statement.executeUpdate(add);
			    		       Main.statement.close();

			    	} 
			    	catch (SQLException error){
			    	    System.err.println(error);
			    }
			    }
		}
		 else 
		 {
			 
				Main.plugin.coolodown.set(e.getPlayer().getName(), false);
				Main.saveConfig(Main.plugin.coolodown, Main.plugin.cooldownFile);
		 }
	@EventHandler(priority = EventPriority.HIGH)
	public void PlayerJoin(PlayerJoinEvent e)
	{
		 for(int i=0;i<=35;i++)
		 {
			 if(i!=0 && i!=1 && i!=2 && i!=3 && i!=7)
			 {
				 e.getPlayer().getInventory().clear(i);
			 }
		 }
	}
	}*/


}
