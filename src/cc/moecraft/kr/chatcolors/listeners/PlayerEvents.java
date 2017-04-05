package cc.moecraft.kr.chatcolors.listeners;

import cc.moecraft.kr.chatcolors.ChatColors;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static cc.moecraft.kr.chatcolors.ChatColors.db;
import static cc.moecraft.kr.chatcolors.ChatColors.lang;
import static cc.moecraft.kr.chatcolors.ChatColors.saveDb;

/**
 * Created by Kilpikonna on 2017/4/4 0004.
 *
 */
public class PlayerEvents implements Listener
{
    private ChatColors plugin = ChatColors.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if (db.contains("Users." + p.getUniqueId().toString())) {
            return;
        }
        db.set("Users." + p.getUniqueId(), "");
        saveDb();
    }

    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        Player p = (Player)e.getWhoClicked();
        if (!e.getInventory().getName().equalsIgnoreCase(ChatColor.GREEN + "" + ChatColor.BOLD + "Edit your chat")) {
            return;
        }
        e.setCancelled(true);
        if (e.getSlot() == 4)
        {
            if (!p.hasPermission("chatcolor.reset"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_PERMISSION.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", null);
            saveDb();
            p.sendMessage(lang.getString("COLOR_RESET.toString());
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 49)
        {
            if (!p.hasPermission("chatcolor.reset"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_PERMISSION.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", null);
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_RESET.toString());
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 11)
        {
            if (!p.hasPermission("chatcolor.darkred"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "DARK_RED");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "dark red"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 12)
        {
            if (!p.hasPermission("chatcolor.red"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "RED");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "red"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 13)
        {
            if (!p.hasPermission("chatcolor.gold"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "GOLD");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "gold"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 14)
        {
            if (!p.hasPermission("chatcolor.yellow"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "YELLOW");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "yellow"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 15)
        {
            if (!p.hasPermission("chatcolor.green"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "GREEN");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "green"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 20)
        {
            if (!p.hasPermission("chatcolor.darkgreen"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "DARK_GREEN");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "dark green"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 21)
        {
            if (!p.hasPermission("chatcolor.aqua"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "AQUA");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "aqua"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 22)
        {
            if (!p.hasPermission("chatcolor.darkaqua"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "DARK_AQUA");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 23)
        {
            if (!p.hasPermission("chatcolor.blue"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR"));
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "BLUE");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 24)
        {
            if (!p.hasPermission("chatcolor.darkblue"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR"));
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "DARK_BLUE");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "dark blue"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 29)
        {
            if (!p.hasPermission("chatcolor.pink"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "PINK");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "pink"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 30)
        {
            if (!p.hasPermission("chatcolor.purple"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "PURPLE");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "purple"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 31)
        {
            if (!p.hasPermission("chatcolor.white"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "WHITE");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "white"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 32)
        {
            if (!p.hasPermission("chatcolor.lightgray"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "GRAY");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "light gray"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 33)
        {
            if (!p.hasPermission("chatcolor.darkgray"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_COLOR.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Color", "DARK_GRAY");
            saveDb();
            p.sendMessage(lang.getString("COLOR_SET.toString().replace("%color%", "gray"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 38)
        {
            if (!p.hasPermission("chatcolor.underline"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_MODIFIER.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", "UNDERLINE");
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_SET.toString().replace("%modifer%", "underline"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 39)
        {
            if (!p.hasPermission("chatcolor.italic"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_MODIFIER.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", "ITALIC");
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_SET.toString().replace("%modifer%", "italic"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 40)
        {
            if (!p.hasPermission("chatcolor.bold"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_MODIFIER.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", "BOLD");
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_SET.toString().replace("%modifer%", "bold"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 41)
        {
            if (!p.hasPermission("chatcolor.strikethrough"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_MODIFIER.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", "STRIKETHROUGH");
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_SET.toString().replace("%modifer%", "strikethrough"));
            p.closeInventory();
            return;
        }
        if (e.getSlot() == 42)
        {
            if (!p.hasPermission("chatcolor.magic"))
            {
                p.sendMessage(lang.getString("ERR_MISSING_MODIFIER.toString());
                p.closeInventory();
                return;
            }
            db.set("Users." + p.getUniqueId().toString() + ".Modifier", "MAGIC");
            saveDb();
            p.sendMessage(lang.getString("MODIFIER_SET.toString().replace("%modifer%", "magic"));
            p.closeInventory();
            return;
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player p = e.getPlayer();
        if (!db.contains("Users." + p.getUniqueId().toString())) {
            return;
        }
        if (db.contains("Users." + p.getUniqueId().toString() + ".Color"))
        {
            if (db.contains("Users." + p.getUniqueId().toString() + ".Modifier"))
            {
                e.setMessage(ChatColor.valueOf(db.getString(new StringBuilder().append("Users.").append(p.getUniqueId().toString()).append(".Color").toString())) + "" + ChatColor.valueOf(db.getString(new StringBuilder().append("Users.").append(p.getUniqueId().toString()).append(".Modifier").toString())) + e.getMessage());
                return;
            }
            e.setMessage(ChatColor.valueOf(db.getString(new StringBuilder().append("Users.").append(p.getUniqueId().toString()).append(".Color").toString())) + e.getMessage());
            return;
        }
        if (!db.contains("Users." + p.getUniqueId().toString() + ".Modifier")) {
            return;
        }
        e.setMessage(ChatColor.valueOf(db.getString(new StringBuilder().append("Users.").append(p.getUniqueId().toString()).append(".Modifier").toString())) + e.getMessage());
    }
}
