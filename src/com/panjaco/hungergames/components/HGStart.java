package com.panjaco.hungergames.components;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import com.panjaco.hungergames.HGMain;
import com.panjaco.hungergames.HungerGames;

import net.md_5.bungee.api.ChatColor;

public class HGStart implements CommandExecutor {

	int i = 5;
	int x;
	Plugin plugin = HungerGames.getProvidingPlugin(getClass());
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		
		//Countdown
		
		if(sender.hasPermission("hungergames.start")){
			/*
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() { 
					//Run code
					for(int i = 5; i > 0; i--){
					Bukkit.broadcastMessage(ChatColor.DARK_RED + "Starting in " + i);
					}
				} 
			}, 20 * 5); // 20 (one second in ticks) * 5 (seconds to wait)
			
			*/
			
			
			
			Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable(){
				public void run(){
					if(i > 0){
						Bukkit.broadcastMessage(ChatColor.DARK_RED + "Starting in " + i);
					}else if(i == 0){
						Bukkit.broadcastMessage(ChatColor.DARK_RED + "GO");
						HGMain.frozen = false;
					}else{
						Bukkit.getServer().getScheduler().cancelAllTasks();
						graceTimer();
					}
					i--;
				}
			}, 0L, 20L);
			i = 5;
			
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use this command!");
		}
		
		return true;
	}
	
	public void graceTimer(){
		
		if(HGMain.graceperiod && HGMain.graceperiod_time != 0){
			x = HGMain.graceperiod_time;
		}else{
			Bukkit.broadcastMessage("WHYYY");
			return;
		}
		//Finish dis!
		
		
		//Set a grace period countdown
		//Then re-enable attacking once it reaches 0
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				if(!HGMain.graceperiod){
					Bukkit.getServer().getScheduler().cancelAllTasks();
				}
				
				if(x % 5 == 0 && x % 4 == 0){
					Bukkit.broadcastMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "Grace period ends in " + x + " seconds!");
				}else if(x <= 10 && x >= 0){
					Bukkit.broadcastMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "Grace period ending in " + x + " seconds!");
				}else if(x < 0){
					Bukkit.broadcastMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "Grace period has ended!");
					HGMain.graceperiod = false;
					x = HGMain.graceperiod_time;
					Bukkit.getServer().getScheduler().cancelAllTasks();
				}
				x--;
			}
		}, 0L, 20L);
		x = HGMain.graceperiod_time;
	}

}
