package com.panjaco.hungergames.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.panjaco.hungergames.HGMain;
import com.panjaco.hungergames.HungerGames;

import net.md_5.bungee.api.ChatColor;

public class HGFreeze implements CommandExecutor {

	private HungerGames plugin;
	
	public HGFreeze(HungerGames pl) {
		plugin = pl;
	}

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		Player player;
		
		if(sender.hasPermission("hungergames.freeze")){
			if(args.length == 1){
				player = (Player) sender;
			}else{
				try{
					player = Bukkit.getPlayer(args[1]);
				}catch(Exception e){
					if(args[1].equalsIgnoreCase("*")){
						for(Player p : Bukkit.getOnlinePlayers()){
							if(!HGMain.frozenPlayers.contains(p)){
								HGMain.frozenPlayers.add(p);
								HGMain.frozenLocation.add(p.getLocation());
							}
						}
						return true;
					}else{
						sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + args[1] + " could not be found!");
						return true;
					}
				}
			}
			
			if(HGMain.frozenPlayers.contains(player)){
				int index = HGMain.frozenPlayers.indexOf(player);
				HGMain.frozenLocation.remove(index);
				HGMain.frozenPlayers.remove(player);
				
				if(sender != player){
					sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + player.getDisplayName() + " has been unfrozen!");
				}
				player.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + "You have been unfrozen!");
			}else{
				HGMain.frozenPlayers.add(player);
				HGMain.frozenLocation.add(player.getLocation());
				if(sender != player){
					sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + player.getDisplayName() + " has been frozen!");
				}
				player.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "You have been frozen!");
			}
		}else{
			sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "You do not have permission to use this command!");
		}
		return true;
	}

}
