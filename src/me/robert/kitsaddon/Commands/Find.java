package me.robert.kitsaddon.Commands;

import me.robert.kitsaddon.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Find implements CommandExecutor {
	
	  @Override
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
	  {
	  	if (cmd.getName().equalsIgnoreCase("bwfind")) 
	  	{
	  		  CommandSender player =  sender;
	  		 
	          String msj = "&8(&4!&8) &fFoloseste comanda &c/bwfind <jucator>";
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
	  	    		  if(Main.checkWorld(pString).equalsIgnoreCase("void1")) 
	  	    		  {
	  	    			 player.sendMessage(ChatColor.translateAlternateColorCodes('&', lobby).replace("%player%", pString));
	  	    		  }
	  	    		  else player.sendMessage(ChatColor.translateAlternateColorCodes('&', online).replace("%player%", pString).replace("%arena%", Main.checkWorld(pString)));
	  	    		  
	  	    	  }
	  	          return true;
	  	      }
	  	}
	  	return true;

        }
}
