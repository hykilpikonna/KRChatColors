package cc.moecraft.kr.chatcolors;

import org.bukkit.Material;

import java.util.ArrayList;

import static cc.moecraft.kr.chatcolors.ChatColors.Debug;
import static cc.moecraft.kr.chatcolors.ChatColors.itemLang;
import static cc.moecraft.kr.chatcolors.ChatColors.saveItemLang;
import static org.bukkit.ChatColor.*;
import static org.bukkit.ChatColor.MAGIC;
import static org.bukkit.ChatColor.STRIKETHROUGH;
import static org.bukkit.Material.*;

/**
 * Created by Kilpikonna on 2017/4/5 0005.
 *
 */
public class ColorsItemDB
{
    public static Integer[] locations;
    public static int amount;
    public static Material[] materials;
    public static final Integer itemAmount = 1;
    public static Integer[] dataValue;
    public static String[] itemName;

    /**
     * 检查物品语言文件
     * @return 如果是新的返回True, 不是返回False
     */
    public static boolean checkItemLang()
    {
        setDefaultValue();
        if (!(itemLang.contains("Default")) || itemLang.getBoolean("Default"))
        {
            itemLang.addDefault("Item.Locations", locations);
            itemLang.addDefault("Item.Materials", materials);
            itemLang.addDefault("Item.dataValues", dataValue);
            itemLang.addDefault("Item.displayNames", itemName);
            saveItemLang();
            return true;
        }
        else
        {
            locations = (Integer[]) itemLang.getIntegerList("Item.Locations").toArray();
            String[] tempMaterialNames = (String[]) itemLang.getStringList("Item.Materials").toArray();
            ArrayList<Material> tempMaterials = new ArrayList<>();
            for (String tempMaterialName : tempMaterialNames)
            {
                tempMaterials.add(Material.getMaterial(tempMaterialName));
            }
            materials = (Material[]) tempMaterials.toArray();
            dataValue = (Integer[]) itemLang.getIntegerList("Item.dataValues").toArray();
            itemName = (String[]) itemLang.getStringList("Item.displayNames").toArray();
            if (locations.length == materials.length && dataValue.length == itemName.length && locations.length == itemName.length)
            {
                amount = locations.length;
            }
            else
            {
                Debug("物品语言列表读取失败(长度不相等: " + locations.length + ", " + materials.length + ", " + dataValue.length + ", " + itemName.length + ")");
                setDefaultValue();
            }
            return false;
        }
    }

    private static void setDefaultValue()
    {
        Debug("正在设置默认物品语言列表");
        locations = new Integer[]{4,49,11,12,13,14,15,20,21,22,23,24,29,30,31,32,33,38,39,40,41,42};
        materials = new Material[]{NETHER_STAR, NETHER_STAR,NETHER_STALK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, DIAMOND, INK_SACK, INK_SACK, INK_SACK, INK_SACK, INK_SACK, SULPHUR, REDSTONE, GLOWSTONE_DUST, FIREWORK_CHARGE, FIREBALL};
        dataValue = new Integer[]{1,1,1,1,14,11,10,2,12,6,4,1,9,5,15,7,8,1,1,1,1,1};
        itemName = new String[]{
                RED + "" + BOLD + "颜色重置",
                RED + "" + BOLD + "去除颜色",
                DARK_RED + "深红色",
                RED + "红色",
                GOLD + "橘色",
                YELLOW + "黄♂色",
                GREEN + "绿色",
                DARK_GREEN + "深绿色",
                AQUA + "青色",
                DARK_AQUA + "深青色",
                BLUE + "蓝色",
                DARK_BLUE + "深蓝色",
                LIGHT_PURPLE + "粉色",
                DARK_PURPLE + "紫色",
                WHITE + "白色",
                GRAY + "浅灰色",
                DARK_GRAY + "深灰色",
                UNDERLINE + "下划线",
                ITALIC + "斜体",
                BOLD + "粗♂体",
                STRIKETHROUGH + "中划线",
                MAGIC + "膜法"
        };
        amount = locations.length;
        Debug("默认物品语言列表设置完");
    }
}
