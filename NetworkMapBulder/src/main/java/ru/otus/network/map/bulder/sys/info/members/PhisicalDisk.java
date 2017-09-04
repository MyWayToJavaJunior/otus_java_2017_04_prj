package ru.otus.network.map.bulder.sys.info.members;

import oshi.hardware.HWDiskStore;

public class PhisicalDisk{

    private String model;
    private String name;
    private String serialNumber;
    private long size;

    public void fillFrom(HWDiskStore store) {
        model = store.getModel();
        name = store.getName();
        serialNumber = store.getSerial();
    }
}
