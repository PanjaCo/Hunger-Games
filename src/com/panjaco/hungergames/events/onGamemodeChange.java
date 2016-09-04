package com.panjaco.hungergames.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class onGamemodeChange implements Listener{

	@EventHandler
	public void PlayerGameModeChangeEvent(org.bukkit.event.player.PlayerGameModeChangeEvent event){
		
		Player player = event.getPlayer();
		GameMode newGamemode = event.getNewGameMode();
		
		if(HGMain.participatingPlayers.contains(player) && newGamemode != GameMode.SURVIVAL){
			player.setGameMode(GameMode.SURVIVAL);
			player.sendMessage(ChatColor.DARK_RED + "You can not change gamemodes while participating in the Hunger Games");
			event.setCancelled(true);
		}
	}
	
}
