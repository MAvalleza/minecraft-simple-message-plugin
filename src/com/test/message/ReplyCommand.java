package com.test.message;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ReplyCommand implements CommandExecutor {
	private Main main;
	
	public ReplyCommand (Main main) {
		this.main = main;
	}
	@Override
	public boolean onCommand (CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (args.length > 0) {			
			if (main.getMessageManager().recentlyMessaged.containsKey(player)) {
				if (main.getMessageManager().recentlyMessaged.get(player) != null) {
					Player target = main.getMessageManager().recentlyMessaged.get(player);
					StringBuilder message = new StringBuilder();
					for (int i = 1; i < args.length; i++) {
						message.append(args[i]).append(" ");
					}
					player.sendMessage(ChatColor.GREEN + "-> " + target.getName() + ChatColor.GRAY + " " + message.toString());
					target.sendMessage(ChatColor.GREEN + "<- " + player.getName() + ChatColor.GRAY + " " + message.toString());
				} else {
					player.sendMessage(ChatColor.RED + "Player has logged out");
				}
			} else {
				player.sendMessage(ChatColor.RED + "No one to message");
			}
		} else {
			player.sendMessage("Invalid usage!");
		}
		return false;
	}

}
