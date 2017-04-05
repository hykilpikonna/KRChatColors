package cc.moecraft.kr.chatcolors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cc.moecraft.kr.chatcolors.commands.CmdChatColor;
import cc.moecraft.kr.chatcolors.listeners.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.RED;
import static org.bukkit.ChatColor.RESET;

public class ChatColors extends JavaPlugin
{
    private static ChatColors instance;

    public YamlConfiguration db;
    public File dbFile;

    public boolean debug = false;

    public void onEnable()
    {
        instance = this;

        dbFile = new File(this.getDataFolder() + "Database.yml");
        db = YamlConfiguration.loadConfiguration(dbFile);
        db.options().copyDefaults(true);

        saveDefaultConfig();
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

    private void registerCommands()
    {
        getCommand("chatcolor").setExecutor(new CmdChatColor());
    }

    private void registerListeners()
    {
        ArrayList<Listener> listeners = new ArrayList<>();
        listeners.add(new PlayerEvents());
        for (Listener listener : listeners)
        {
            Bukkit.getPluginManager().registerEvents(listener, instance);
        }
    }

    /**
     * 保存数据库
     * @return 是否保存成功
     */
    private boolean saveDb()
    {
        try
        {
            db.save(dbFile);
            return true;
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
            return false;
        }
    }

    /**
     * 给玩家发送包含前缀的消息
     * @param p 玩家
     * @param message 消息
     */
    public void sendMessage(Player p, String message)
    {
        p.sendMessage(ChatColor.GRAY + "[" + ChatColor.GOLD + "KRChatColors" + ChatColor.GRAY + "]" + ChatColor.GREEN + message);
    }

    /**
     * 给玩家发送包含前缀的消息(String Array)
     * @param p 玩家
     * @param message String Array
     */
    public void sendMessage(Player p, String[] message)
    {
        for (String aMessage : message) {
            sendMessage(p, aMessage);
        }
    }

    /**
     * 给玩家发送包含前缀的消息(ArrayList)
     * @param p 玩家
     * @param message ArrayList
     */
    public void sendMessage(Player p, ArrayList<String> message)
    {
        for (String aMessage : message) {
            sendMessage(p, aMessage);
        }
    }

    /**
     * 发送后台通知消息
     * @param s 消息
     */
    public void log(String s)
    {
        Bukkit.getConsoleSender().sendMessage("[PKP] " + s);
    }

    /**
     * 发送后台通知消息(字符串数组)
     * @param s 字符串数组
     */
    public void log(String[] s)
    {
        for (String value : s)
        {
            log(value);
        }
    }

    /**
     * 发送后台通知消息(字符串ArrayList)
     * @param s 字符串ArrayList
     */
    public void log(ArrayList<String> s)
    {
        for (String value : s) {
            log(value);
        }
    }

    /**
     * 发送后台Debug消息
     * @param s 消息
     */
    public void Debug(String s)
    {
        if (debug)
        {
            log("[" + RED + "DEBUG" + RESET + "(" + GOLD +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + ":" +
                    Thread.currentThread().getStackTrace()[2].getLineNumber() + RESET + ")] " + s);
        }
    }

    /**
     * 发送后台Debug消息
     * @param object 对象
     * @param message 消息
     */
    public void Debug(Object object, String message)
    {
        if (debug)
        {
            log("[" + RED + "DEBUG" + RESET + "(" + GOLD +
                    Thread.currentThread().getStackTrace()[2].getClassName() + "." +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + ":" +
                    Thread.currentThread().getStackTrace()[2].getLineNumber()+ RESET + ")] " +
                    object.getClass().getSimpleName() + ": " + message);
        }
    }

    /**
     * 判断一个字符串是不是整数
     * @param s 字符串
     * @return 是不是整数
     */
    public boolean isInteger(String s)
    {
        if(s.isEmpty())
        {
            return false;
        }
        for(int i = 0; i < s.length(); i++)
        {
            if(i == 0 && s.charAt(i) == '-')
            {
                if(s.length() == 1)
                {
                    return false;
                }
                else
                {
                    continue;
                }
            }
            if (Character.digit(s.charAt(i), 10) < 0)
            {
                return false;
            }
        }
        return true;
    }
}
