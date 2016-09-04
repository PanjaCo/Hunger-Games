package com.panjaco.hungergames.components;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HungerGames;
import com.panjaco.hungergames.*;
import com.panjaco.hungergames.components.*;

import net.md_5.bungee.api.ChatColor;

public class HGWorld implements CommandExecutor {

	private HungerGames plugin;
	
	public HGWorld(HungerGames pl){
		plugin = pl;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender.hasPermission("hungergames.world")){
			
			if(args.length == 2){
				plugin.getConfig().set("world", args[1]);
				sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + "World set to: " + ChatColor.RED + args[1]);
			}else{
				//Player[] players = (Player[]) Bukkit.getOnlinePlayers().toArray();
				Player targetPlayer = (Player) sender;
				String worldName = targetPlayer.getWorld().getName();
				
				
				if(!(sender instanceof Player)){
					sender.sendMessage(ChatColor.DARK_RED + "There are no online players to grab the world name from - please do /hgworld <world>");
					return true;
				}else{
					plugin.getConfig().set("world", worldName);
					sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + "World set to: " + ChatColor.RED + worldName);
				}
			}
			
			plugin.saveConfig();
			
			return true;
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use that command!");
			return true;
		}
	}

}
