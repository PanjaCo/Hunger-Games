package com.panjaco.hungergames.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.panjaco.hungergames.HGMain;
import com.panjaco.hungergames.HungerGames;

public class players implements Listener{
	

	/*
	public void onPlayerAttack(PlayerItemDamageEvent event){
		
		
		if(HGMain.graceperiod){
			event.setCancelled(true);
		}
	}
	public void onDamage(EntityDamageEvent event){
		if(HGMain.graceperiod){
			event.setCancelled(true);
		}
	}
	*/
	@EventHandler
	public void onPlayerAttack(EntityDamageByEntityEvent event){
		//Check if graceperiod is enabled
		if(HGMain.graceperiod){
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		
		Player player = event.getPlayer();
		
		if(HGMain.frozen == true && HGMain.participatingPlayers.contains(player)){
			//event.setCancelled(true); - Glitches out
			
			
			for(int i = 0; i < HGMain.spawns.size(); i++){
				if(i < HGMain.participatingPlayers.size()){
					if(HGMain.participatingPlayers.toArray()[i] == player){
						Location loc = player.getLocation();
						Location loc2 = (Location) HGMain.spawns.toArray()[i];
						if(loc.getX() != loc2.getX() || loc.getY() != loc2.getY() || loc.getZ() != loc2.getZ()){
							Location loc3 = loc2;
							loc3.setPitch(player.getLocation().getPitch());
							loc3.setYaw(player.getLocation().getYaw());
							player.teleport(loc3);
						}
					}
				}else{
					break;
				}
			}
		}else if(HGMain.frozenPlayers.contains(player)){
			
			int index = HGMain.frozenPlayers.indexOf(player);
			Location location = (Location) HGMain.frozenLocation.toArray()[index];
			
			double x = location.getX();
			double y = location.getY();
			double z = location.getZ();
			
			if(player.getLocation().getX() != location.getX() || player.getLocation().getY() != location.getY() || player.getLocation().getZ() != location.getZ()){
				float yaw = player.getLocation().getYaw();
				float pitch = player.getLocation().getPitch();
				
				location = new Location(Bukkit.getPlayer(player.getName()).getWorld(), x, y, z, yaw, pitch);
				
				player.teleport(location);
			}
		}
	}
	
}
