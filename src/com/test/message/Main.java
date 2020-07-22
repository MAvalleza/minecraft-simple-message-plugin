package com.test.message;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	private MessageManager manager;
	
		
	@Override
	public void onEnable () {
		System.out.println("TEST PLUGIN ENABLED!");
		
		getCommand("message").setExecutor(new MessageCommand(this));
		getCommand("reply").setExecutor(new ReplyCommand(this));
		
		manager = new MessageManager(this);
	}
	
	public MessageManager getMessageManager () { return manager; }

	

}
