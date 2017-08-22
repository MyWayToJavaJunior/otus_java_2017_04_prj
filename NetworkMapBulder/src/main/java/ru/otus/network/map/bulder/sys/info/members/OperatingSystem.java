package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;

public class OperatingSystem implements ISysInfoMember{
    private String family;

    @Override
    public void fillFrom(SystemInfo si) {
        oshi.software.os.OperatingSystem os = si.getOperatingSystem();

        family = os.getFamily();
    }
}
