package cc.moecraft.kr.chatcolors.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import cc.moecraft.kr.chatcolors.ChatColors;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class CustomFile
{
    private String fileName;
    private ChatColors plugin = ChatColors.getInstance();
    private File file;
    private FileConfiguration fileConfiguration;

    public CustomFile(String fileName)
    {
        this.fileName = fileName;
    }

    public void reloadFile()
    {
        if (this.file == null)
        {
            this.file = new File(this.plugin.getDataFolder(), this.fileName + ".yml");
            try
            {
                this.file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        this.fileConfiguration = YamlConfiguration.loadConfiguration(this.file);
        Reader defConfigStream = new InputStreamReader(this.plugin.getResource(this.fileName + ".yml"));
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        this.fileConfiguration.setDefaults(defConfig);
    }

    public FileConfiguration getFile()
    {
        if (this.fileConfiguration == null) {
            reloadFile();
        }
        return this.fileConfiguration;
    }

    public void saveFile()
    {
        if ((this.file == null) || (this.fileConfiguration == null)) {
            return;
        }
        try
        {
            getFile().save(this.file);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveDefaultFile()
    {
        if (this.file == null) {
            this.file = new File(this.plugin.getDataFolder(), this.fileName + ".yml");
        }
        if (!this.file.exists()) {
            this.plugin.saveResource(this.fileName + ".yml", false);
        }
    }
}
