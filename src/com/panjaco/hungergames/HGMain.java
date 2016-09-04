package com.panjaco.hungergames;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HGMain implements CommandExecutor {

	public static ArrayList<Player> participatingPlayers = new ArrayList<Player>();
	public static ArrayList<Location> spawns = new ArrayList<Location>();
	public static boolean graceperiod = false;
	public static int graceperiod_time = 0;
	public static boolean frozen;
	public static ArrayList<Player> frozenPlayers = new ArrayList<Player>();
	public static ArrayList<Location> frozenLocation = new ArrayList<Location>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		return true;
	}

}
