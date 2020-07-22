package com.test.message;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class MessageManager {
	private Main main;
	
	public MessageManager (Main main) {
		this.main = main;
	}
	
	public HashMap<Player, Player> recentlyMessaged = new HashMap<>();
}
