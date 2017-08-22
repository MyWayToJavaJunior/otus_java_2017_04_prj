package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

import java.util.Arrays;

public class PrefomanceInfo implements ISysInfoMember {
    private double avgCPULoad;
    private double[] perProcessorsCPULoad;

    private double temperature;

    private double memoryUsedBytes;
    private double memoryUsedPercents;

    private double swapUsedBytes;
    private double swapUsedPercents;

    @Override
    public void fillFrom(SystemInfo si) {
        HardwareAbstractionLayer hard = si.getHardware();
        CentralProcessor proc = hard.getProcessor();
        GlobalMemory memory = hard.getMemory();

        avgCPULoad = proc.getSystemCpuLoadBetweenTicks() * 100;
        perProcessorsCPULoad = proc.getProcessorCpuLoadBetweenTicks();
        for (int i = 0; i < perProcessorsCPULoad.length; i++) {
            perProcessorsCPULoad[i] *= 100;
        }

        temperature = hard.getSensors().getCpuTemperature();

        memoryUsedBytes = memory.getAvailable();
        memoryUsedPercents = 0;

        if (memory.getTotal() > 0) {
            memoryUsedPercents = memoryUsedBytes / (memory.getTotal() / 100);
        }

        swapUsedBytes = memory.getSwapUsed();
        swapUsedPercents = 0;
        if (memory.getSwapTotal() > 0) {
            swapUsedPercents = swapUsedBytes / (memory.getSwapTotal() / 100);
        }
    }

    @Override
    public String toString() {
        return "PrefomanceInfo{" +
                "avgCPULoad='" + avgCPULoad + '\'' + "\n" +
                ", perProcessorsCPULoad='" + Arrays.toString(perProcessorsCPULoad) + '\'' + "\n" +
                ", temperature='" + temperature + '\'' + "\n" +
                ", memoryUsedBytes='" + memoryUsedBytes + '\'' + "\n" +
                ", memoryUsedPercents='" + memoryUsedPercents + '\'' + "\n" +
                ", swapUsedBytes='" + swapUsedBytes + '\'' + "\n" +
                ", swapUsedPercents='" + swapUsedPercents + '\'' + "\n" +
                '}';
    }
}
