package com.hippout.testplugin;

import org.bukkit.configuration.*;
import org.bukkit.configuration.file.*;
import org.bukkit.plugin.java.*;

import javax.annotation.*;
import java.io.*;

public class TestPlugin extends JavaPlugin {

	private static TestPlugin instance;

	@Override
	public void onEnable()
	{
		getLogger().info("TestPlugin has been enabled.");

		instance = this;

		saveDefaultConfig();

        try {
            final FileConfiguration config = loadConfigFile(instance, "config.yml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void onDisable()
	{
		getLogger().info("TestPlugin has been disabled.");
	}

	@Override
	public void onLoad()
	{
		// Nothing
	}

    public static FileConfiguration loadConfigFile(@Nonnull JavaPlugin plugin, @Nonnull String fileName) throws IOException, InvalidConfigurationException
    {
        final String configPath = plugin.getDataFolder().getPath() + File.separator + fileName;
        final FileConfiguration config = plugin.getConfig();
        config.load(configPath);

        return config;
    }
}
