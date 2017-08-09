package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.Arrays;

public class Processor implements ISysInfoMember{
    private String family;
    private String identifier;
    private String model;
    private String vendor;
    private String processorID;

    private int phisicalProcessorsCount;
    private int logicalProcessorsCount;

    private String architecture;

    private double avgCPULoad;
    private double[] perProcessorsCPULoad;

    private double temperature;

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

        architecture = proc.isCpu64bit()? "x64": "x86";

        avgCPULoad = proc.getSystemCpuLoadBetweenTicks() * 100;
        perProcessorsCPULoad = proc.getProcessorCpuLoadBetweenTicks();
        for (int i = 0; i < perProcessorsCPULoad.length; i++) {
            perProcessorsCPULoad[i] *= 100;
        }

        temperature = hard.getSensors().getCpuTemperature();
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
                ", architecture='" + architecture + '\'' + "\n" +
                ", avgCPULoad=" + avgCPULoad + "\n" +
                ", perProcessorsCPULoad=" + Arrays.toString(perProcessorsCPULoad) + "\n" +
                ", perProcessorsCPULoad=" + Arrays.toString(perProcessorsCPULoad) + "\n" +
                '}';
    }
}
