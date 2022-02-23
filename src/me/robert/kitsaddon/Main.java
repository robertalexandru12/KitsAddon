package me.robert.kitsaddon;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


import me.robert.kitsaddon.Commands.Find;
import me.robert.kitsaddon.events.ArenaJoinEvent;
import me.robert.kitsaddon.events.ArenaLeaveEvent;
import me.robert.kitsaddon.events.IClickEvent;
import me.robert.kitsaddon.events.InteractEvent;
import me.robert.kitsaddon.events.JoinEvent;
import me.robert.kitsaddon.events.KillEvent;
import me.robert.kitsaddon.events.QuitEvent;
import me.robert.kitsaddon.utils.color;
import org.black_ixx.playerpoints.PlayerPoints;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;





public class Main extends JavaPlugin {
  public static HashMap<UUID, String> selectedKit = new HashMap<>();
  public static Main plugin;

	public File cooldownFile = new File(getDataFolder(), "cooldown.yml");
	public YamlConfiguration coolodown = YamlConfiguration.loadConfiguration(this.cooldownFile);
	public File messagesFile = new File(getDataFolder(), "messages.yml");
	public YamlConfiguration messages = YamlConfiguration.loadConfiguration(this.messagesFile);

	
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "5rAuwGhrta9CEetN";
	private static final String CONN_STRING = "jdbc:mysql://localhost:3306/bwtest";
    public static boolean mysqlConn = true;
    public static Statement statement;
    public static Connection conn;
    public static int ID;
    public static List<String> noKits = new ArrayList<String>();
    private PlayerPoints playerPoints;

	

  
  public void onEnable() {

		  
	  plugin = this;

    load();
    hookPlayerPoints();
    noKits.add("test");
    Bukkit.getServer().getConsoleSender().sendMessage(color.c("&7[&cKitsAddon&7] &fPluginul a fost &b&lactivat"));
    if(!messagesFile.exists())
    {
    	messages.set("Settings.NoPermission", "&8(&3!&8) &fNu ai permisiunea de a selecta acest kit!");
    	messages.set("Settings.Cooldown", "&8(&3!&8) &fNu poti arunca cu perla pentru inca &c%time% &fsecunde");
    	messages.set("Disabled-Worlds", noKits);
    
    }

    saveConfig(messages, messagesFile);
    
    try {
       DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
         conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
        System.out.println("MYSQL Connected");
        mysqlConn = true;
    }catch (SQLException e){
    System.err.println(e);
    }
    if(mysqlConn)
    {
    	try {
    		ResultSet res;
			statement = conn.createStatement();
			String query = "SELECT WINS FROM BedWars WHERE name='Robyyyyyy'";
			System.out.print(statement.executeQuery(query));
			res = statement.executeQuery(query);
			while(res.next())
			{
				  System.out.println(res.getString(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	/*try
    	{
          statement = conn.createStatement();
           String tabel = "SELECT WINS FROM BedWars WHERE name="Robyyyyyy";
    		//String tabel = "CREATE TABLE robyyyyyy(NAME varchar(255), KILLS int)";
    	
    		        statement.executeUpdate(tabel);
    		        statement.close();
    		        

    	} 
    	catch (SQLException e){
    	    System.err.println(e);
    	    */
    }
    
   // getCommand("bwspec").setExecutor(new Spectate());
    getCommand("bwfind").setExecutor(new Find());
    
  }


  private boolean hookPlayerPoints() {
	    final Plugin plugin = this.getServer().getPluginManager().getPlugin("PlayerPoints");
	    playerPoints = PlayerPoints.class.cast(plugin);
	    return playerPoints != null; 
	}
  
  public static boolean checkOnline(String s)
  {  	
  	String player;   	
  	for(Player p : Bukkit.getOnlinePlayers()){    		
  		player = p.getPlayer().getName().toString();
  		if(s.equalsIgnoreCase(player))  return true;    		                            		
  	}
		return false;   	
  }
  
  public static String checkWorld(String pString)
  {
	Player p = Bukkit.getPlayer(pString);
	return p.getWorld().getName().toString();
	  
  }
  
  
  public void onDisable() { Bukkit.getServer().getConsoleSender().sendMessage(color.c("&7[&bKitsAddon&7] &fPluginul a fost &cdezactivat")); }

  
  private void load() {
    saveDefaultConfig();
    loadEvents();
  }
  
  

  
  public static void saveConfig(FileConfiguration ymlConfig, File ymlFile) {
  	try 
  	{
  	    ymlConfig.save(ymlFile);
  	 } catch (IOException e) {
  	e.printStackTrace();
  	     }
  	}
  
  private void loadEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents((Listener)new ArenaJoinEvent(), (Plugin)this);
    pm.registerEvents((Listener)new ArenaLeaveEvent(), (Plugin)this);
    pm.registerEvents((Listener)new InteractEvent(), (Plugin)this);
    pm.registerEvents((Listener)new IClickEvent(), (Plugin)this);
    pm.registerEvents((Listener)new QuitEvent(), (Plugin)this);
    pm.registerEvents((Listener)new JoinEvent(), (Plugin)this);
    pm.registerEvents((Listener)new KillEvent(), (Plugin)this);
  }
}
