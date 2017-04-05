package cc.moecraft.kr.chatcolors.commands;

import cc.moecraft.kr.chatcolors.ChatColors;
import cc.moecraft.kr.chatcolors.util.ItemUtil;
import cc.moecraft.kr.chatcolors.util.Lang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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
            sender.sendMessage("Sorry console, but only players can use this command");
            return false;
        }
        if (!sender.hasPermission("chatcolor.use"))
        {
            sender.sendMessage(Lang.ERR_MISSING_PERMISSION.toString());
            return false;
        }
        Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "" + ChatColor.BOLD + "Edit your chat");
        for (int i = 0; i < 54; i++)
        {
            inventory.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7));
        }

        inventory.setItem(4, ItemUtil.createItem(Material.NETHER_STAR, 1, ChatColor.RED + "" + ChatColor.BOLD + "Reset Color", this.plugin.getConfig().getStringList("GUI.Color-Reset.Lore")));
        inventory.setItem(49, ItemUtil.createItem(Material.NETHER_STAR, 1, ChatColor.RED + "" + ChatColor.BOLD + "Reset Modifier", this.plugin.getConfig().getStringList("GUI.Modifier-Reset.Lore")));
        inventory.setItem(11, ItemUtil.createItem(Material.NETHER_STALK, 1, ChatColor.DARK_RED + "Dark Red", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(12, ItemUtil.createItem(Material.INK_SACK, 1, 1, ChatColor.RED + "Red", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(13, ItemUtil.createItem(Material.INK_SACK, 1, 14, ChatColor.GOLD + "Orange", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(14, ItemUtil.createItem(Material.INK_SACK, 1, 11, ChatColor.YELLOW + "Yellow", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(15, ItemUtil.createItem(Material.INK_SACK, 1, 10, ChatColor.GREEN + "Green", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(20, ItemUtil.createItem(Material.INK_SACK, 1, 2, ChatColor.DARK_GREEN + "Dark Green", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(21, ItemUtil.createItem(Material.INK_SACK, 1, 12, ChatColor.AQUA + "Aqua", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(22, ItemUtil.createItem(Material.INK_SACK, 1, 6, ChatColor.DARK_AQUA + "Dark Aqua", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(23, ItemUtil.createItem(Material.INK_SACK, 1, 4, ChatColor.BLUE + "Blue", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(24, ItemUtil.createItem(Material.DIAMOND, 1, ChatColor.DARK_BLUE + "Dark Blue", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(29, ItemUtil.createItem(Material.INK_SACK, 1, 9, ChatColor.LIGHT_PURPLE + "Pink", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(30, ItemUtil.createItem(Material.INK_SACK, 1, 5, ChatColor.DARK_PURPLE + "Purple", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(31, ItemUtil.createItem(Material.INK_SACK, 1, 15, ChatColor.WHITE + "White", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(32, ItemUtil.createItem(Material.INK_SACK, 1, 7, ChatColor.GRAY + "Light Gray", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(33, ItemUtil.createItem(Material.INK_SACK, 1, 8, ChatColor.DARK_GRAY + "Gray", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(38, ItemUtil.createItem(Material.SULPHUR, 1, ChatColor.UNDERLINE + "Underline", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(39, ItemUtil.createItem(Material.REDSTONE, 1, ChatColor.ITALIC + "Italic", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(40, ItemUtil.createItem(Material.GLOWSTONE_DUST, 1, ChatColor.BOLD + "Bold", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(41, ItemUtil.createItem(Material.FIREWORK_CHARGE, 1, ChatColor.STRIKETHROUGH + "Strikethrough", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(42, ItemUtil.createItem(Material.FIREBALL, 1, ChatColor.MAGIC + "Magic", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));

        ((Player)sender).openInventory(inventory);
        return true;
    }
}
