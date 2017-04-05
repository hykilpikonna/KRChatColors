package cc.moecraft.kr.chatcolors.util;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public enum Lang
{
    COLOR_RESET("color-reset", "&a&lChat Colors &8&l> &7Color reset"),
    MODIFIER_RESET("modifer-reset", "&a&lChat Colors &8&l> &7Modifier reset"),
    COLOR_SET("color-set", "&a&lChat Colors &8&l> &7Chat color set to %color%"),
    MODIFIER_SET("modifier-set", "&a&lChat Colors &8&l> &7Chat modifier set to %modifier%"),
    ERR_MISSING_PERMISSION("missing-permission", "&a&lChat Colors &8&l> &7You do not have permission to use this command"),
    ERR_MISSING_COLOR("missing-color", "&a&lChat Colors &8&l> &7You do not have permission to use this chat color"),
    ERR_MISSING_MODIFIER("missing-modifier", "&a&lChat Colors &8&l> &7You do not have permission to use this chat modifier");

    private final String path;
    private final String def;
    private static FileConfiguration LANG;

    private Lang(String path, String start)
    {
        this.path = path;
        this.def = start;
    }

    public static void setFile(FileConfiguration fileConfiguration)
    {
        LANG = fileConfiguration;
    }

    public String toString()
    {
        if (LANG.getString(this.path) != null) {
            return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path));
        }
        return ChatColor.translateAlternateColorCodes('&', this.def);
    }
}

