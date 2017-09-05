package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;

import java.util.Arrays;

public class DataStorageSubsystem implements ISysInfoMember {
    private PhisicalDisk[] phisicalDisks;
    private LogicalDrive[] logicalDrives;

    @Override
    public void fillFrom(SystemInfo si) {
        HardwareAbstractionLayer hw = si.getHardware();

        phisicalDisks = new PhisicalDisk[hw.getDiskStores().length];
        for (int i = 0; i < phisicalDisks.length; i++) {
            phisicalDisks[i] = new PhisicalDisk();
            phisicalDisks[i].fillFrom(hw.getDiskStores()[i]);
        }

        FileSystem fs = si.getOperatingSystem().getFileSystem();
        logicalDrives = new LogicalDrive[fs.getFileStores().length];
        for (int i = 0; i < logicalDrives.length; i++) {
            logicalDrives[i] = new LogicalDrive();
            logicalDrives[i].fillFrom(fs.getFileStores()[i]);
        }
    }

    @Override
    public String toString() {
        return "{\n" +
                "\"phisicalDisks\"=" + Arrays.toString(phisicalDisks) + "\n" +
                ", \"logicalDrives\"=" + Arrays.toString(logicalDrives) + "\n" +
                '}';
    }
}
