package ru.otus.network.map.bulder.sys.info.members;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import oshi.software.os.OSFileStore;
import ru.otus.network.map.bulder.FormatsHepler;

public class LogicalDrive {
    private String name;
    private String description;
    private String type;
    private String mount;
    private String volume;
    private String logicalVolume;
    private long totalSize;
    private long usableSize;
    private double percentUsage;

    public void fillFrom(OSFileStore store) {
        name = store.getName();
        description = store.getDescription();
        type = store.getType();
        mount = store.getMount();
        volume = store.getVolume();
        logicalVolume = store.getLogicalVolume();
        totalSize = store.getTotalSpace();
        usableSize = store.getUsableSpace();
        percentUsage = 0;
        if (totalSize != 0) percentUsage = usableSize / (totalSize / 100d);
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("description", description);
        object.put("type", type);
        object.put("mount", mount);
        object.put("volume", volume);
        object.put("logicalVolume", logicalVolume);
        object.put("totalSize", FormatsHepler.formatBytesAsGB(totalSize));
        object.put("usableSize", FormatsHepler.formatBytesAsGB(usableSize));
        object.put("percentUsage", FormatsHepler.formatPercents(percentUsage));

        return object.toString();
    }
}
