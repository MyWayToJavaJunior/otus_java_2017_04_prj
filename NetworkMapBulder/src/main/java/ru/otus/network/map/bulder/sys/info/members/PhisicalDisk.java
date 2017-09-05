package ru.otus.network.map.bulder.sys.info.members;

import org.json.simple.JSONObject;
import oshi.hardware.HWDiskStore;
import ru.otus.network.map.bulder.FormatsHepler;

import java.util.Arrays;

public class PhisicalDisk{

    private String model;
    private String name;
    private String serialNumber;
    private long size;
    private PhisicalDiskPartition[] partitions;

    public void fillFrom(HWDiskStore store) {
        model = store.getModel();
        name = store.getName();
        serialNumber = store.getSerial();
        size = store.getSize();

        partitions = new PhisicalDiskPartition[store.getPartitions().length];
        for (int i = 0; i < partitions.length; i++) {
            partitions[i] = new PhisicalDiskPartition();
            partitions[i].fillFrom(store.getPartitions()[i]);
        }
    }

    @Override
    public String toString() {
        JSONObject object = new JSONObject();
        object.put("model", model);
        object.put("name", name);
        object.put("serialNumber", serialNumber);
        object.put("size", FormatsHepler.formatBytesAsGB(size));
        object.put("partitions", Arrays.toString(partitions));

        return object.toString();
    }
}
