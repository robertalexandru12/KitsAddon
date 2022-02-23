package me.robert.kitsaddon.events;

import java.math.BigDecimal;

import org.black_ixx.playerpoints.event.PlayerPointsChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.liangchenghqr.minigamesaddons.Utils.CosmeticManager;
import net.ess3.api.events.UserBalanceUpdateEvent;


public class KillEvent implements Listener{
	
	/*@EventHandler
	public void PlayerKill(PlayerKillEvent e)
	{
		int kills = e.getPlayer().getKiller().getStatistic(Statistic.PLAYER_KILLS);
		int Deaths = e.getPlayer().getStatistic(Statistic.DEATHS);
		int finalKills = e.getPlayer().getKiller().getStatistic(Statistic.HORSE_ONE_CM);
		
		
		Deaths++;
		
	    if(!Main.mysqlConn)
	    {
	    	try
	    	{
	    		kills++;
	         // Main.statement = Main.conn.createStatement();
	    		//String add = "INSERT INTO robyyyyyy (NAME, KILLS) VALUES ('" + e.getPlayer().getKiller().getName()+ "', '" + kills +"')";
	    	
	    		        //Main.statement.executeUpdate(add);
	    		       // Main.statement.close();

	    	} 
	    	catch (SQLException error){
	    	    System.err.println(error);
	    }
	    }
		
		e.getPlayer().setStatistic(Statistic.DEATHS, Deaths);
		if(e.isRespawing())
		{
			kills++;
			Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "eco give "  + e.getPlayer().getKiller().getName() + " 20");
			e.getPlayer().getKiller().setStatistic(Statistic.PLAYER_KILLS, kills);
		}
		else 
			{
			finalKills++;
			 e.getPlayer().getKiller().setStatistic(Statistic.HORSE_ONE_CM, finalKills);
			 Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "eco give "  + e.getPlayer().getKiller().getName() + " 20");
			}


		
		
	}*/
	
	

	@EventHandler
	public void bani(UserBalanceUpdateEvent e)
	{
		Player p = Bukkit.getPlayer("test");
		if(e.getPlayer().getWorld().getName().equals("Solace")) 
		{
			BigDecimal sumaVeche = e.getOldBalance();
		e.setNewBalance(sumaVeche);
		}
		
	
	
	}
	@EventHandler
	public void tokens1(PlayerPointsChangeEvent e)
	{
		Player p = Bukkit.getPlayer(e.getPlayerId());
		if(p.getWorld().getName().equals("Solace")) e.setCancelled(true);
		/*
		if(p.getWorld().getName().equals("Solace"))
		{
			Bukkit.broadcastMessage("test123");
			Bukkit.getServer().dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "p take "  + p.getName() + " " + e.getChange());
		}
	}*/
	}
	/* static Location blockLocation;
	 static Player p;
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled=false)
	public static void PlayerInteract(BlockBreakEvent e)
	{
	    
		boolean broken = false;
		p=e.getPlayer();
		blockLocation = e.getBlock().getLocation();
		//if(blockLocation.getBlock().getType()==Material.BED_BLOCK) broken = true;
		//Bukkit.broadcastMessage("test32424 " + blockLocation.getBlock().getType().toString()+ " hatz");
		
	
			if(e.getBlock().getType()==Material.BED_BLOCK)
			{  
				broken = true;
				Bed bed = (Bed) e.getBlock().getState().getData();
			
				
				//Bukkit.broadcastMessage("test");
				
				
			}
			if(broken == true)
			{
			     task();
			}

	
	}
	final static void task()
	{
		final int[] array = {1, 2, 3};
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable(){
		    public void run(){
		        for(int n : array){
		            if(n == 2){
		            	if(!(blockLocation.getBlock().getType()==Material.BED_BLOCK))
		            	{
		            		
		            		CosmeticManager.playBedBreakEffect(p, blockLocation); 
		            	}
		            	Bukkit.getServer().getScheduler().cancelAllTasks();
		            }
		           
		        }
		   
			
		    }
		    
		}, 0, 20);
	}*/
	
	


}
