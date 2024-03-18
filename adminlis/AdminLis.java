package org.imomid.adminlis;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class AdminLis extends JavaPlugin {

    @Override
    public void onEnable() {
        CreatecustomFile();
        getServer().getPluginCommand("admin").setExecutor(new Command());
        getServer().getPluginCommand("admind").setExecutor(new Admin());


    }
    File file;
    static FileConfiguration fileConfiguration;
    void CreatecustomFile(){
        file = new File(getDataFolder(),"custom.yml");
        if(!file.exists()){
            file.getParentFile().mkdir();
            saveResource("custom.yml",false);
        }
        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch (IOException | InvalidConfigurationException e){
            System.out.println(e.getMessage());
        }
    }
    void SaveConfig(){
        try {
            fileConfiguration.save(file);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
