package com.panjaco.hungergames;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.panjaco.hungergames.components.HGAdd;
import com.panjaco.hungergames.components.HGFreeze;
import com.panjaco.hungergames.components.HGGrace;
import com.panjaco.hungergames.components.HGHelp;
import com.panjaco.hungergames.components.HGJoin;
import com.panjaco.hungergames.components.HGPlace;
import com.panjaco.hungergames.components.HGPlayers;
import com.panjaco.hungergames.components.HGRefill;
import com.panjaco.hungergames.components.HGSet;
import com.panjaco.hungergames.components.HGStart;
import com.panjaco.hungergames.components.HGWorld;
import com.panjaco.hungergames.events.blocks;
import com.panjaco.hungergames.events.onDeath;
import com.panjaco.hungergames.events.onGamemodeChange;
import com.panjaco.hungergames.events.onJoin;
import com.panjaco.hungergames.events.players;

public class HungerGames extends JavaPlugin{
	
	public static Plugin plugin;
	
	
	
	public void onEnable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Hunger Games] Enabled");
		
		//Load/Create the config
		loadConfiguration();
		//this.reloadConfig();
		
		//Register Event Listeners
		getServer().getPluginManager().registerEvents(new blocks(), this);
		getServer().getPluginManager().registerEvents(new players(), this);
		getServer().getPluginManager().registerEvents(new onJoin(), this);
		getServer().getPluginManager().registerEvents(new onDeath(), this);
		getServer().getPluginManager().registerEvents(new onGamemodeChange(), this);
		
		
		//Set the commands to run another class
		/*
		getCommand("hgset").setExecutor(new HGSet());
		getCommand("hgplace").setExecutor(new HGPlace());
		getCommand("hggrace").setExecutor(new HGGrace());
		getCommand("hgadd").setExecutor(new HGAdd());
		getCommand("hgjoin").setExecutor(new HGJoin());
		getCommand("hgplayers").setExecutor(new HGPlayers());
		getCommand("hgstart").setExecutor(new HGStart());
		getCommand("hgrefill").setExecutor(new HGRefill(this));
		getCommand("hgworld").setExecutor(new HGWorld(this));
		getCommand("hgfreeze").setExecutor(new HGFreeze(this));
		*/
		
		//Stop mobs from spawning
		//Bukkit.dispatchCommand("gamerule doMobSpawning false");
		//Set the default game mode to Survival
		Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
	}
	public void onDisable(){
		PluginDescriptionFile descFile = getDescription();
		Logger logger = getLogger();
		logger.info("[Hunger Games] Disabled");
	}
	
	public void loadConfiguration(){
	     //See "Creating you're defaults"
	     this.getConfig().options().copyDefaults(true); // NOTE: You do not have to use "plugin." if the class extends the java plugin
	     //Save the config whenever you manipulate it
	     this.saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
		if(label.equalsIgnoreCase("hg")){
			if(args[0].equalsIgnoreCase("add")){
				new HGAdd().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("freeze")){
				new HGFreeze(this).onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("grace")){
				new HGGrace().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("join")){
				new HGJoin().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("place")){
				new HGPlace().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("players")){
				new HGPlayers().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("refill")){
				new HGRefill(this).onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("set")){
				new HGSet().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("start")){
				new HGStart().onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("world")){
				new HGWorld(this).onCommand(sender, command, label, args);
			}else if(args[0].equalsIgnoreCase("help")){
				new HGHelp().onCommand(sender, command, label, args);
			}
		}
		
		return false;
	}
	
}
