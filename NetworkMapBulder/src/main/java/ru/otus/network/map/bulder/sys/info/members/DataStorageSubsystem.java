package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;

public class DataStorageSubsystem implements ISysInfoMember {
    private PhisicalDisk[] phisicalDisks;
    private LogicalDrive[] logicalDrives;

    @Override
    public void fillFrom(SystemInfo si) {

    }
}
