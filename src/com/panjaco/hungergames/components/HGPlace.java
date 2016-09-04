package com.panjaco.hungergames.components;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class HGPlace implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player[] players;
		
		if(sender.hasPermission("hungergames.place")){
			for(int i = 0; i <= HGMain.spawns.size(); i++){
				if(i < HGMain.participatingPlayers.toArray().length){
					Player target = (Player) HGMain.participatingPlayers.toArray()[i];
					
					target.teleport((Location) HGMain.spawns.toArray()[i]);
					target.setGameMode(GameMode.SURVIVAL);
				}else{
					break;
				}
			}
			
			Bukkit.broadcastMessage(ChatColor.GREEN + "All participating players have been teleported into their pods");
		
			HGMain.frozen = true;
			
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this!");
		}
		return true;
	}

}
