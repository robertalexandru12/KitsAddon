package me.robert.kitsaddon.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.robert.kitsaddon.Main;

public class Spectate implements CommandExecutor {
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	  {
	  	if (cmd.getName().equalsIgnoreCase("bwspec")) 
	  	{
	  		  CommandSender player =  sender;
	  		  Player sendPlayer = (Player) sender;
	  		 
	          String msj = "&8(&4!&8) &fFoloseste comanda &c/bwspec <jucator>";
	          String noOnline = "&8(&4!&8) &fJucatorul nu este online";
	          String online = "&8(&4!&8) &c%player% &feste online in arena &c%arena%";
	          String lobby = "&8(&4!&8) &c%player% &feste online in Lobby";
	  		  
	  	      if (args.length != 1) {
	  	    	  player.sendMessage(ChatColor.translateAlternateColorCodes('&', msj));
	  	          return true;
	  	      }
	  	      if (args.length == 1) {
	  	    	  String pString = args[0];
	  	    	  if(!Main.checkOnline(pString))
	  	    	  {
	  	    		  player.sendMessage(ChatColor.translateAlternateColorCodes('&', noOnline));
	  	    	  }
	  	    	  else
	  	    	  {
	  	    		  Player p = Bukkit.getPlayer(pString);
	  	    		  if(Main.checkWorld(pString).equalsIgnoreCase("void1")) sendPlayer.sendMessage(ChatColor.translateAlternateColorCodes('&', lobby.replace("%player%", pString)));
	  	    		  else
	  	    			  {
	  	    			     sendPlayer.teleport(getLocation(p));
	  	    			  }
	  	    		  
	  	    	  }
	  	          return true;
	  	      }
	  	}

	  	return true; 
	}
	public Location getLocation(Player p)
	{
		return p.getLocation();
	}

}
