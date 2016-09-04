package com.panjaco.hungergames.components;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.panjaco.hungergames.HGMain;

public class HGGrace implements CommandExecutor {

	
	Timer timer;
	Toolkit toolkit;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		

		if(sender.hasPermission("hungergames.grace")){
			HGMain.graceperiod = true;
			try{
				HGMain.graceperiod_time = Integer.parseInt(args[1]);
				if(HGMain.graceperiod_time == 0){
					HGMain.graceperiod = false;
					sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.RED + "Grace period has been disabled!");
					return true;
				}
			}catch(Exception e){
				sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + args[1] + " is not a valid number!");
				return true;
			}
			
			sender.sendMessage(ChatColor.AQUA + "[Hunger Games] " + ChatColor.GREEN + "Grace period set to " + HGMain.graceperiod_time + " seconds!");
			
		    //toolkit = Toolkit.getDefaultToolkit();
		    //timer = new Timer();
		    //timer.schedule(new RemindTask(), HGMain.graceperiod_time * 1000);	
			
			
			//Start a async delayed task, before that happens print out the grace period amount
			
			
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to do this!");
		}
		return true;
	}

}
