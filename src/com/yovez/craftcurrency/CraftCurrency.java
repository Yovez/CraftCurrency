package com.yovez.craftcurrency;

import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;

public class CraftCurrency extends JavaPlugin {

	private OfflinePlayer player;
	private CraftConfig craftConfig;

	@Override
	public void onEnable() {
		saveDefaultConfig();
	}

	public CraftCurrency(UUID playerUUID) {
		setPlayer(getServer().getOfflinePlayer(playerUUID));
		setCraftConfig(new CraftConfig(playerUUID.toString()));
	}

	public CraftCurrency(OfflinePlayer player) {
		setPlayer(player);
		setCraftConfig(new CraftConfig(player.getUniqueId().toString()));
	}

	public OfflinePlayer getPlayer() {
		return player;
	}

	public void setPlayer(OfflinePlayer player) {
		this.player = player;
	}

	public CraftConfig getCraftConfig() {
		return craftConfig;
	}

	public void setCraftConfig(CraftConfig craftConfig) {
		this.craftConfig = craftConfig;
	}

	public double getPlayerBalance() {
		return craftConfig.get().getDouble("balance", 0.0);
	}

	public void setPlayerBalance(double balance) {
		craftConfig.get().set("balance", balance);

		if (!getConfig().getBoolean("allow_debt", false))
			if (getPlayerBalance() < 0)
				setPlayerBalance(0);
	}

	public void deposit(double amount) {
		setPlayerBalance(getPlayerBalance() + amount);
	}

	public void withdraw(double amount) {
		setPlayerBalance(getPlayerBalance() - amount);

		if (!getConfig().getBoolean("allow_debt", false))
			if (getPlayerBalance() < 0)
				setPlayerBalance(0);
	}

}
