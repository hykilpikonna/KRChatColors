package cc.moecraft.kr.chatcolors.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil
{
    public static ItemStack createItem(Material material)
    {
        ItemStack itemStack = new ItemStack(material);

        return itemStack;
    }

    public static ItemStack createItem(Material material, int amount)
    {
        ItemStack itemStack = new ItemStack(material, amount);

        return itemStack;
    }

    public static ItemStack createItem(Material material, int amount, int dataValue)
    {
        ItemStack itemStack = new ItemStack(material, amount, (short)dataValue);

        return itemStack;
    }

    public static ItemStack createItem(Material material, String itemName, List<String> itemLore)
    {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> newLore = new ArrayList();
        for (String str : itemLore) {
            newLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
        itemMeta.setLore(newLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, int amount, String itemName, List<String> itemLore)
    {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> newLore = new ArrayList();
        for (String str : itemLore) {
            newLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
        itemMeta.setLore(newLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack createItem(Material material, int amount, int dataValue, String itemName, List<String> itemLore)
    {
        ItemStack itemStack = new ItemStack(material, amount, (short)dataValue);
        ItemMeta itemMeta = itemStack.getItemMeta();

        List<String> newLore = new ArrayList();
        for (String str : itemLore) {
            newLore.add(ChatColor.translateAlternateColorCodes('&', str));
        }
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', itemName));
        itemMeta.setLore(newLore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
