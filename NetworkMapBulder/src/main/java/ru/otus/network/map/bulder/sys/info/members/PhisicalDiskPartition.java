package ru.otus.network.map.bulder.sys.info.members;

import org.json.simple.JSONObject;
import oshi.hardware.HWPartition;
import ru.otus.network.map.bulder.FormatsHepler;

public class PhisicalDiskPartition {

    private String name;
    private String type;
    private String mountPoint;
    private int phisicalDiskNum;
    private int partitionNum;
    private long size;

    public void fillFrom(HWPartition partition){
        name = partition.getName();
        type = partition.getType();
        mountPoint = partition.getMountPoint();
        size = partition.getSize();
        phisicalDiskNum = partition.getMajor();
        partitionNum = partition.getMinor();
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("name", name);
        object.put("type", type);
        object.put("mountPoint", mountPoint);
        object.put("phisicalDiskNum", phisicalDiskNum);
        object.put("partitionNum", partitionNum);
        object.put("size", FormatsHepler.formatBytesAsGB(size));

        return object.toString();
    }
}
