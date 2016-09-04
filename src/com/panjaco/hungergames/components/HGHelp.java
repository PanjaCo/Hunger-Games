package com.panjaco.hungergames.components;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class HGHelp implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + "Help:");
		
		sender.sendMessage(ChatColor.GOLD + "/hg add <player>" + ChatColor.RED + " - " + ChatColor.GREEN + "Add a player to the game.");
		sender.sendMessage(ChatColor.GOLD + "/hg freeze <player>" + ChatColor.RED + " - " + ChatColor.GREEN + "Freeze a player.");
		sender.sendMessage(ChatColor.GOLD + "/hg grace <seconds>" + ChatColor.RED + " - " + ChatColor.GREEN + "Set a grace period, where players can not attack each other.");
		sender.sendMessage(ChatColor.GOLD + "/hg join" + ChatColor.RED + " - " + ChatColor.GREEN + "Join the game.");
		sender.sendMessage(ChatColor.GOLD + "/hg place" + ChatColor.RED + " - " + ChatColor.GREEN + "Place the players into their starting pods.");
		sender.sendMessage(ChatColor.GOLD + "/hg players" + ChatColor.RED + " - " + ChatColor.GREEN + "See all of the remainding players.");
		sender.sendMessage(ChatColor.GOLD + "/hg refill" + ChatColor.RED + " - " + ChatColor.GREEN + "Refill all of the chests.");
		sender.sendMessage(ChatColor.GOLD + "/hg set" + ChatColor.RED + " - " + ChatColor.GREEN + "Set a starting pod to your current location.");
		sender.sendMessage(ChatColor.GOLD + "/hg start" + ChatColor.RED + " - " + ChatColor.GREEN + "Start the game.");
		sender.sendMessage(ChatColor.GOLD + "/hg world <world name>" + ChatColor.RED + " - " + ChatColor.GREEN + "Specify the world name you are in, so you can use the command /hg refill.");
		
		
		return true;
	}

	
	
	
}
