package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.Baseboard;
import oshi.hardware.ComputerSystem;
import oshi.hardware.Firmware;
import ru.otus.network.map.bulder.FormatsHepler;

public class MotherBoard implements ISysInfoMember {
    private String manufacturer;
    private String model;
    private String version;
    private String serialNumber;

    private BIOS bios;

    @Override
    public void fillFrom(SystemInfo si) {
        ComputerSystem cs = si.getHardware().getComputerSystem();
        Baseboard bb = cs.getBaseboard();

        manufacturer = bb.getManufacturer();
        model = bb.getModel();
        version = bb.getVersion();
        serialNumber = bb.getSerialNumber();

        bios = new BIOS(cs.getFirmware());
    }

    @Override
    public String toString() {
        return "MotherBoard{" + "\n" +
                "manufacturer='" + manufacturer + '\'' + "\n" +
                ", model='" + model + '\'' + "\n" +
                ", version='" + version + '\'' + "\n" +
                ", serialNumber='" + serialNumber + '\'' + "\n" +
                ", bios=" + bios + "\n" +
                '}';
    }

    public class BIOS {
        private String manufacturer;
        private String name;
        private String description;
        private String version;
        private String releaseDate;

        public BIOS(Firmware firmware) {
            manufacturer = firmware.getManufacturer();
            name = firmware.getName();
            description = firmware.getDescription();
            version = firmware.getVersion();
            releaseDate =  FormatsHepler.formatDate(firmware.getReleaseDate());
        }

        @Override
        public String toString() {
            return "BIOS{" +
                    "manufacturer='" + manufacturer + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", version='" + version + '\'' +
                    ", releaseDate='" + releaseDate + '\'' +
                    '}';
        }
    }
}
