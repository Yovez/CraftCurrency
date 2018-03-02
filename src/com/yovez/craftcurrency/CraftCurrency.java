package com.yovez.craftcurrency;

import org.bukkit.plugin.java.JavaPlugin;

public class CraftCurrency extends JavaPlugin {

	@Override
	public void onEnable() {
		getConfig().options().copyDefaults();
		saveDefaultConfig();
	}

}
