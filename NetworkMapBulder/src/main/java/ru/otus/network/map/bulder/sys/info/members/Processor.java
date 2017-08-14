package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

public class Processor implements ISysInfoMember{
    private String family;
    private String identifier;
    private String model;
    private String vendor;
    private String processorID;

    private int phisicalProcessorsCount;
    private int logicalProcessorsCount;

    private String isCpu64bit;

    @Override
    public void fillFrom(SystemInfo si){
        HardwareAbstractionLayer hard = si.getHardware();
        CentralProcessor proc = hard.getProcessor();

        family = proc.getFamily();
        identifier = proc.getIdentifier();
        model = proc.getModel();
        vendor = proc.getVendor();
        processorID = proc.getProcessorID();

        phisicalProcessorsCount = proc.getPhysicalProcessorCount();
        logicalProcessorsCount = proc.getLogicalProcessorCount();

        isCpu64bit = proc.isCpu64bit()? "yes": "no";
    }

    @Override
    public String toString() {
        return "Processor{" +
                "family='" + family + '\'' + "\n" +
                ", identifier='" + identifier + '\'' + "\n" +
                ", model='" + model + '\'' + "\n" +
                ", vendor='" + vendor + '\'' + "\n" +
                ", processorID='" + processorID + '\'' + "\n" +
                ", phisicalProcessorsCount=" + phisicalProcessorsCount + "\n" +
                ", logicalProcessorsCount=" + logicalProcessorsCount + "\n" +
                ", isCpu64bit='" + isCpu64bit + '\'' + "\n" +
                '}';
    }
}
