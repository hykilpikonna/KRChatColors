package cc.moecraft.kr.chatcolors.commands;

import cc.moecraft.kr.chatcolors.ChatColors;
import cc.moecraft.kr.chatcolors.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static cc.moecraft.kr.chatcolors.ColorsItemDB.*;
import static org.bukkit.ChatColor.*;
import static org.bukkit.Material.*;

/**
 * Created by Kilpikonna on 2017/4/4 0004.
 *
 */
public class CmdChatColor
        implements CommandExecutor
{
    private ChatColors plugin = ChatColors.getInstance();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!cmd.getName().equalsIgnoreCase("chatcolor")) {
            return false;
        }
        if (!(sender instanceof Player))
        {
            sender.sendMessage("只有玩家可以使用此指令");
            return false;
        }
        if (!sender.hasPermission("chatcolor.use"))
        {
            sender.sendMessage(Lang.ERR_MISSING_PERMISSION.toString());
            return false;
        }
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "" + BOLD + "Edit your chat");
        for (int i = 0; i < 54; i++)
        {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7));
        }

        for (int i = 0; i < amount; i++)
        {
            inventory.setItem(locations[i], ItemUtil.createItem(materials[i], 1, dataValue[i], RED + "" + BOLD + "颜色重置"));
        }

        ((Player)sender).openInventory(inventory);
        return true;
    }
}
