package com.yovez.craftcurrency;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

public class CraftCurrencyAPI {

	private OfflinePlayer player;
	private CraftConfig craftConfig;

	public CraftCurrencyAPI(UUID playerUUID) {
		setPlayer(Bukkit.getServer().getOfflinePlayer(playerUUID));
		setCraftConfig(new CraftConfig(playerUUID.toString()));
	}

	public CraftCurrencyAPI(OfflinePlayer player) {
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
	}

	public void deposit(double amount) {
		setPlayerBalance(getPlayerBalance() + amount);
	}

	public void withdraw(double amount) {
		setPlayerBalance(getPlayerBalance() - amount);

		/* Disallows balance to go below 0 */
		if (getPlayerBalance() < 0)
			setPlayerBalance(0);
	}

}
