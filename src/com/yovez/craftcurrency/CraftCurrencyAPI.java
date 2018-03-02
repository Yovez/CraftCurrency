package com.yovez.craftcurrency;

import org.bukkit.entity.Player;

public class CraftCurrencyAPI {

	private Player player;
	private CraftConfig craftConfig;

	public CraftCurrencyAPI() {

	}

	public CraftCurrencyAPI(Player player) {
		this.setPlayer(player);
		setCraftConfig(new CraftConfig(player.getUniqueId().toString()));
	}

	public CraftCurrencyAPI(CraftConfig craftConfig) {
		setCraftConfig(craftConfig);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
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
	
	

}
