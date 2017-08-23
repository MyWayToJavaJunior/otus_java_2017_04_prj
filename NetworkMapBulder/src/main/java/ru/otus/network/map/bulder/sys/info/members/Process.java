package ru.otus.network.map.bulder.sys.info.members;

import oshi.software.os.OSProcess;
import ru.otus.network.map.bulder.FormatsHepler;

public class Process {
    private int ID;
    private double processorUsage;
    private long memoryUsage;
    private String name;
    private String commandLine;
    private String path;
    private String user;

    public Process(OSProcess p) {
        ID = p.getProcessID();
        processorUsage = 100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime();
        memoryUsage = p.getResidentSetSize();
        name = p.getName();
        commandLine = p.getCommandLine();
        path = p.getPath();
        user = p.getUser();
    }

    @Override
    public String toString() {
        return "Process{" +
                "ID=" + ID +
                ", processorUsage=" + FormatsHepler.formatPercents(processorUsage) + "%" +
                ", memoryUsage=" + FormatsHepler.formatBytesAsMB(memoryUsage) +
                ", name='" + name + '\'' +
                ", commandLine='" + commandLine + '\'' +
                ", path='" + path + '\'' +
                ", user='" + user + '\'' +
                '}' + '\n';
    }
}
