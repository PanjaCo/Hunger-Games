package com.panjaco.hungergames.components;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class HGSet implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player = (Player) sender;
		
		if(sender.hasPermission("hungergames.set")){
			if(HGMain.spawns.size() < 24){
				Location playerLocation = player.getLocation();
				HGMain.spawns.add(playerLocation);
				
				sender.sendMessage(ChatColor.GREEN + "You have set a pod at: " + playerLocation.getBlockX() + " " + playerLocation.getBlockY() + " " + playerLocation.getBlockZ());
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "You have already set 24 pods!");
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this!");
		}
		
		return true;
	}

}
