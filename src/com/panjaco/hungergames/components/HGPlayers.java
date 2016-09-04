package com.panjaco.hungergames.components;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class HGPlayers implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender.hasPermission("hungergames.players")){
			sender.sendMessage(ChatColor.GREEN + "Remaining Players: ");
			
			for(Player p : HGMain.participatingPlayers){
				sender.sendMessage(ChatColor.RED + "" + p.getDisplayName());
			}
		}
		
		return true;
	}

}
