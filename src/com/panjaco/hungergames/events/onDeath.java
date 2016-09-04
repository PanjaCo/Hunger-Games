package com.panjaco.hungergames.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class onDeath implements Listener{
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		Player player = event.getEntity();
		
		if(HGMain.participatingPlayers.contains(player)){
			HGMain.participatingPlayers.remove(player);
			Bukkit.broadcastMessage(ChatColor.GOLD + "" + player.getDisplayName() + ChatColor.RED + " has been eliminated!");
			player.setGameMode(GameMode.SPECTATOR);
			player.hidePlayer(player);
			player.sendMessage(ChatColor.RED + "You have died, you are now in spectator mode!");
			event.setDeathMessage(null);
		}
	}
	
}
