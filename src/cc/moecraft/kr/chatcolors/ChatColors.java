package cc.moecraft.kr.chatcolors;

import java.util.ArrayList;
import java.util.List;

import cc.moecraft.kr.chatcolors.commands.CmdChatColor;
import cc.moecraft.kr.chatcolors.file.CustomFile;
import cc.moecraft.kr.chatcolors.file.FileManager;
import cc.moecraft.kr.chatcolors.listeners.PlayerEvents;
import cc.moecraft.kr.chatcolors.util.Lang;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatColors extends JavaPlugin
{
    private static ChatColors instance;
    public FileManager fileManager;

    public void onEnable()
    {
        instance = this;
        this.fileManager = new FileManager();

        registerConfig();
        registerCommands();
        registerListeners();
    }

    public void onDisable()
    {
        instance = null;
    }

    public static ChatColors getInstance()
    {
        return instance;
    }

    private void registerConfig()
    {
        saveDefaultConfig();

        CustomFile langFile = new CustomFile("lang");
        langFile.saveDefaultFile();
        this.fileManager.registerFile(langFile, "lang");
        Lang.setFile(langFile.getFile());

        CustomFile dataFile = new CustomFile("data");
        dataFile.saveDefaultFile();
        this.fileManager.registerFile(dataFile, "data");
    }

    private void registerCommands()
    {
        getCommand("chatcolor").setExecutor(new CmdChatColor());
    }

    private void registerListeners()
    {
        List<Listener> listeners = new ArrayList();
        listeners.add(new PlayerEvents());
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, instance);
        }
    }
}
