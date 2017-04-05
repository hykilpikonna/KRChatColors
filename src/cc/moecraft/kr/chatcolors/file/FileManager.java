package cc.moecraft.kr.chatcolors.file;

import java.util.HashMap;

/**
 * Created by Kilpikonna on 2017/4/4 0004.
 *
 */
public class FileManager
{
    private HashMap<String, CustomFile> fileMap = new HashMap();

    public void registerFile(CustomFile customFile, String fileName)
    {
        this.fileMap.putIfAbsent(fileName, customFile);
    }

    public CustomFile getFile(String fileName)
    {
        if (!hasFile(fileName)) {
            return null;
        }
        return (CustomFile)this.fileMap.get(fileName);
    }

    public boolean hasFile(String fileName)
    {
        return this.fileMap.containsKey(fileName);
    }
}
