package com.panjaco.hungergames.events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class onJoin implements Listener {

	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event){
		
		Player player = event.getPlayer();
		
		player.setGameMode(GameMode.SURVIVAL);
		event.setJoinMessage(ChatColor.GREEN + "Would you like to join the Hunger Games? If so type /hgjoin");
		
	}
	
}
