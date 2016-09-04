package com.panjaco.hungergames.components;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HGMain;

public class HGJoin implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player targetPlayer = (Player) sender;
		
		if(sender.hasPermission("hungergames.join")){
			if(!HGMain.participatingPlayers.contains(targetPlayer)){
				HGMain.participatingPlayers.add(targetPlayer);
				targetPlayer.setGameMode(GameMode.SURVIVAL);
				Bukkit.broadcastMessage(ChatColor.GREEN + targetPlayer.getDisplayName() + " has joined the game!");
			}else{
				HGMain.participatingPlayers.remove(targetPlayer);
				targetPlayer.setGameMode(GameMode.SURVIVAL);
				Bukkit.broadcastMessage(ChatColor.DARK_RED + targetPlayer.getDisplayName() + " has left the game!");
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this!");
		}
		

		return true;
	}

}
