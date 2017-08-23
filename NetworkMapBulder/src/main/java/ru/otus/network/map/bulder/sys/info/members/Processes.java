package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.software.os.*;
import oshi.software.os.OperatingSystem.ProcessSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Processes implements ISysInfoMember {
    private int count;
    private int threadCount;
    private List<Process> list;

    @Override
    public void fillFrom(SystemInfo si) {
        oshi.software.os.OperatingSystem os = si.getOperatingSystem();
        GlobalMemory memory = si.getHardware().getMemory();

        count = os.getProcessCount();
        threadCount = os.getThreadCount();

        list = new ArrayList<>();
        List<OSProcess> procs = Arrays.asList(os.getProcesses(count, ProcessSort.CPU));
        for (OSProcess osProcess: procs) {
            Process p = new Process(osProcess);
            list.add(p);
        }
    }

    @Override
    public String toString() {
        return "Processes{" + '\n' +
                "count=" + count + '\n' +
                ", threadCount=" + threadCount + '\n' +
                ", list=" + list + '\n' +
                '}';
    }
}
