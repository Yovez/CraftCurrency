package com.yovez.craftcurrency;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class CraftConfig {

	private final String PLUGIN_FOLDER;
	private String fileName;
	private String path;
	private File file;
	private YamlConfiguration config;

	public CraftConfig() {
		PLUGIN_FOLDER = "CraftCurrency";
	}

	public CraftConfig(String fileName) {
		PLUGIN_FOLDER = "CraftCurrency";
		this.fileName = fileName;
		path = Bukkit.getServer().getPluginManager().getPlugin(PLUGIN_FOLDER).getDataFolder().getAbsolutePath();
		file = new File(path, fileName + ".yml");
		config = YamlConfiguration.loadConfiguration(file);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public YamlConfiguration get() {
		return config;
	}

	public void setConfig(YamlConfiguration config) {
		this.config = config;
	}

	public void saveConfig() {
		try {
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean exists() {
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	public String getPluginFolder() {
		return PLUGIN_FOLDER;
	}

}
