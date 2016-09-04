package com.panjaco.hungergames.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.panjaco.hungergames.HGMain;

import net.md_5.bungee.api.ChatColor;

public class blocks implements Listener{

	@EventHandler
	public void onPlayerBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		
		Block block = event.getBlock();
		Material material = block.getType();
		
		//Only let the user break leaves
		if(HGMain.participatingPlayers.contains(player)){
			if(material == Material.LEAVES || material == Material.LEAVES_2 || material == Material.WEB){
				
			}else{
				event.setCancelled(true);
			}
		}
	}
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player player = event.getPlayer();
		
		Block block = event.getBlock();
		Material material = block.getType();
		
		if(HGMain.participatingPlayers.contains(player)){
			if(material == Material.WEB){
				
			}else{
				event.setCancelled(true);
			}
		}
	}
	
	
}
