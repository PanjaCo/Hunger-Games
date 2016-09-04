package com.panjaco.hungergames.components;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.panjaco.hungergames.HungerGames;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Chunk;
import org.bukkit.Material;

public class HGRefill implements CommandExecutor {

	public Material[] chestItemsMaterial = { Material.APPLE, Material.COOKED_BEEF, Material.WOOD_SWORD, Material.FLINT, Material.FEATHER, Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET, Material.STICK, Material.ARROW, Material.STONE_SWORD, Material.LEATHER_BOOTS, Material.LEATHER_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET, Material.BOW, Material.IRON_INGOT, Material.IRON_SWORD, Material.DIAMOND, Material.IRON_BOOTS, Material.IRON_LEGGINGS, Material.IRON_CHESTPLATE, Material.IRON_HELMET };
	public Material[] junkItems = { Material.STICK, Material.FEATHER, Material.FLINT };
	public Material[] foodItems = { Material.APPLE, Material.COOKED_BEEF, Material.COOKIE };
	public Material[] weaponItems = { Material.WOOD_SWORD, Material.STONE_SWORD, Material.IRON_SWORD, Material.BOW };
	public Material[] chainArmor = { Material.CHAINMAIL_BOOTS, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_HELMET };
	public Material[] leatherArmor = { Material.LEATHER_BOOTS, Material.LEATHER_LEGGINGS, Material.LEATHER_CHESTPLATE, Material.LEATHER_HELMET };
	public Material[] resourceItems = { Material.IRON_INGOT, Material.DIAMOND };
	
	//public static World world = Bukkit.getWorld("world");
	public static String temp;
	public static World world;
	
	private HungerGames plugin;
	
	public HGRefill(HungerGames pl){
		plugin = pl;
	}
	
	public ArrayList<ItemStack> chestItems = new ArrayList<ItemStack>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		
		if(sender.hasPermission("hungergames.refill")){
			
			int amount;
			int position;
			
			chestItems.clear();
			
			
			try{
				world = Bukkit.getWorld(plugin.getConfig().getString("world"));
			}catch(Exception e){
				if(sender instanceof Player){
					sender.sendMessage(ChatColor.DARK_RED + "The specified map: " + world.toString() + " ,does not exist!");
				}else{
					sender.sendMessage("The specified map: " + world.toString() + " ,does not exist!");
				}
			}
				
			//Creating an array of items
			
			//20% of getting junk
			for(int i = 0; i < 20; i++){
				amount = ThreadLocalRandom.current().nextInt(1, 4);
				position = ThreadLocalRandom.current().nextInt(0, junkItems.length);
				ItemStack item = new ItemStack(junkItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//20% of getting food
			for(int i = 0; i < 20; i++){
				amount = ThreadLocalRandom.current().nextInt(1, 4);
				position = ThreadLocalRandom.current().nextInt(0, foodItems.length);
				ItemStack item = new ItemStack(foodItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//15% of getting a wooden sword
			for(int i = 0; i < 10; i++){
				amount = 1;
				position = 0;
				ItemStack item = new ItemStack(weaponItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//8% of getting a stone sword
			for(int i = 0; i < 5; i++){
				amount = 1;
				position = 1;
				ItemStack item = new ItemStack(weaponItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//7% of getting a bow
			for(int i = 0; i < 5; i++){
				amount = 1;
				position = 3;
				ItemStack item = new ItemStack(weaponItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//2% of getting an iron sword
			for(int i = 0; i < 2; i++){
				amount = 1;
				position = 2;
				ItemStack item = new ItemStack(weaponItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//12% of getting chain armor
			for(int i = 0; i < 12; i++){
				amount = 1;
				position = ThreadLocalRandom.current().nextInt(0, chainArmor.length);
				ItemStack item = new ItemStack(chainArmor[position], amount, (short)0);
				chestItems.add(item);
			}
			//8% of getting leather armor
			for(int i = 0; i < 8; i++){
				amount = 1;
				position = ThreadLocalRandom.current().nextInt(0, leatherArmor.length);
				ItemStack item = new ItemStack(leatherArmor[position], amount, (short)0);
				chestItems.add(item);
			}
			//6% of getting an iron ingot
			for(int i = 0; i < 6; i++){
				amount = 1;
				position = 0;
				ItemStack item = new ItemStack(resourceItems[position], amount, (short)0);
				chestItems.add(item);
			}
			//2% of getting a diamond
			for(int i = 0; i < 2; i++){
				amount = 1;
				position = 1;
				ItemStack item = new ItemStack(resourceItems[position], amount, (short)0);
				chestItems.add(item);
			}
			
			/*
			for(Material m : chestItemsMaterial){
				if(m == Material.APPLE || m == Material.COOKED_BEEF || m == Material.FLINT || m == Material.FEATHER || m == Material.STICK || m == Material.ARROW){
					int mult = ThreadLocalRandom.current().nextInt(1, 5);
					for(int i = 0; i <= mult; i++){
						Random rand = new Random(4);
						amount = ThreadLocalRandom.current().nextInt(1, 5);
						ItemStack item = new ItemStack(m, amount, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.CHAINMAIL_BOOTS || m == Material.CHAINMAIL_LEGGINGS || m == Material.CHAINMAIL_CHESTPLATE || m == Material.CHAINMAIL_HELMET){
					int mult = ThreadLocalRandom.current().nextInt(1, 5);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.WOOD_SWORD){
					int mult = ThreadLocalRandom.current().nextInt(1, 8);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.LEATHER_BOOTS || m == Material.LEATHER_LEGGINGS || m == Material.LEATHER_CHESTPLATE || m == Material.LEATHER_HELMET){
					int mult = ThreadLocalRandom.current().nextInt(1, 3);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.STONE_SWORD || m == Material.BOW){
					int mult = ThreadLocalRandom.current().nextInt(1, 7);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.IRON_INGOT){
					int mult = ThreadLocalRandom.current().nextInt(1, 5);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.IRON_SWORD){
					int mult = ThreadLocalRandom.current().nextInt(1, 3);
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.IRON_BOOTS || m == Material.IRON_LEGGINGS || m == Material.IRON_CHESTPLATE || m == Material.IRON_HELMET){
					//int mult = ThreadLocalRandom.current().nextInt(1, 5);
					int mult = 1;
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else if(m == Material.DIAMOND){
					int mult = 0;
					for(int i = 0; i <= mult; i++){
						ItemStack item = new ItemStack(m, 1, (short)0);
						chestItems.add(item);
					}
				}else{
					amount = 1;
					ItemStack item = new ItemStack(m, amount, (short)0);
					chestItems.add(item);
				}

			}
			*/
			
			if(world != null){
				for(Chunk c : world.getLoadedChunks()){
					for(BlockState b : c.getTileEntities()){
						if(b instanceof Chest){
							Inventory inv = ((Chest) b).getBlockInventory();
							fillChest(inv);
						}
					}
				}
				Bukkit.broadcastMessage(ChatColor.GREEN + "All chests have been refilled!");
			}else{
				sender.sendMessage(ChatColor.DARK_RED + "world is null, please use /hgworld <world>");
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED + "You do not have permission to use that command!");
		}
		return true;
	}
	
	int chestContents = 0;
	
	public void fillChest(Inventory inv){
		inv.clear();
		
		chestContents = 0;
		
		while(chestContents < 3){
			for(int i = 0; i <= 26; i++){
				Random r = new Random();
	
				if(i == r.nextInt(26)){
					//inv.setItem(i, /*item*/);
					int position = ThreadLocalRandom.current().nextInt(0, chestItems.size());
					ItemStack item = (ItemStack) chestItems.toArray()[position];
					
					inv.setItem(i, item);
					chestContents++;
				}
			}
		}
	}

}
