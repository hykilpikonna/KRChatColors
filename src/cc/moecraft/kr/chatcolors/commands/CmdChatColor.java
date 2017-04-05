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
            sender.sendMessage("只有玩家可以使用此指令");
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

        inventory.setItem(4, ItemUtil.createItem(Material.NETHER_STAR, 1, ChatColor.RED + "" + ChatColor.BOLD + "颜色重置", this.plugin.getConfig().getStringList("GUI.Color-Reset.Lore")));
        inventory.setItem(49, ItemUtil.createItem(Material.NETHER_STAR, 1, ChatColor.RED + "" + ChatColor.BOLD + "去除颜色", this.plugin.getConfig().getStringList("GUI.Modifier-Reset.Lore")));
        inventory.setItem(11, ItemUtil.createItem(Material.NETHER_STALK, 1, ChatColor.DARK_RED + "深红", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(12, ItemUtil.createItem(Material.INK_SACK, 1, 1, ChatColor.RED + "红", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(13, ItemUtil.createItem(Material.INK_SACK, 1, 14, ChatColor.GOLD + "橘色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(14, ItemUtil.createItem(Material.INK_SACK, 1, 11, ChatColor.YELLOW + "黄色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(15, ItemUtil.createItem(Material.INK_SACK, 1, 10, ChatColor.GREEN + "绿色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(20, ItemUtil.createItem(Material.INK_SACK, 1, 2, ChatColor.DARK_GREEN + "深绿色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(21, ItemUtil.createItem(Material.INK_SACK, 1, 12, ChatColor.AQUA + "青色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(22, ItemUtil.createItem(Material.INK_SACK, 1, 6, ChatColor.DARK_AQUA + "深青色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(23, ItemUtil.createItem(Material.INK_SACK, 1, 4, ChatColor.BLUE + "蓝色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(24, ItemUtil.createItem(Material.DIAMOND, 1, ChatColor.DARK_BLUE + "深蓝色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(29, ItemUtil.createItem(Material.INK_SACK, 1, 9, ChatColor.LIGHT_PURPLE + "粉色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(30, ItemUtil.createItem(Material.INK_SACK, 1, 5, ChatColor.DARK_PURPLE + "紫色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(31, ItemUtil.createItem(Material.INK_SACK, 1, 15, ChatColor.WHITE + "白色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(32, ItemUtil.createItem(Material.INK_SACK, 1, 7, ChatColor.GRAY + "浅灰色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(33, ItemUtil.createItem(Material.INK_SACK, 1, 8, ChatColor.DARK_GRAY + "深灰色", this.plugin.getConfig().getStringList("GUI.Color.Lore")));
        inventory.setItem(38, ItemUtil.createItem(Material.SULPHUR, 1, ChatColor.UNDERLINE + "下划线", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(39, ItemUtil.createItem(Material.REDSTONE, 1, ChatColor.ITALIC + "斜体", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(40, ItemUtil.createItem(Material.GLOWSTONE_DUST, 1, ChatColor.BOLD + "粗♂体", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(41, ItemUtil.createItem(Material.FIREWORK_CHARGE, 1, ChatColor.STRIKETHROUGH + "中划线", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));
        inventory.setItem(42, ItemUtil.createItem(Material.FIREBALL, 1, ChatColor.MAGIC + "膜法", this.plugin.getConfig().getStringList("GUI.Modifier.Lore")));

        ((Player)sender).openInventory(inventory);
        return true;
    }
}
