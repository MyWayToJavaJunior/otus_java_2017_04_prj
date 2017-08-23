package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;

public class OperatingSystem implements ISysInfoMember{
    private String family;
    private String manufacturer;
    private String version;
    private String buildNumber;
    private String codeName;

    @Override
    public void fillFrom(SystemInfo si) {
        oshi.software.os.OperatingSystem os = si.getOperatingSystem();

        family = os.getFamily();
        manufacturer = os.getManufacturer();
        version = os.getVersion().getVersion();
        buildNumber = os.getVersion().getBuildNumber();
        codeName = os.getVersion().getCodeName();
    }

    @Override
    public String toString() {
        return "OperatingSystem{" + "\n" +
                "family='" + family + '\''  + "\n" +
                ", manufacturer='" + manufacturer + '\''  + "\n" +
                ", version='" + version + '\''  + "\n" +
                ", buildNumber='" + buildNumber + '\''  + "\n" +
                ", codeName='" + codeName + '\''  + "\n" +
                '}';
    }
}
