package ru.otus.network.map.bulder.sys.info;



import oshi.SystemInfo;
import ru.otus.network.map.bulder.sys.info.members.*;

public class SysInfoCollector {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();

        ISysInfoMember motherBoard = new MotherBoard();
        motherBoard.fillFrom(systemInfo);

        ISysInfoMember processor = new Processor();
        processor.fillFrom(systemInfo);

        ISysInfoMember perfomaceInfo = new PrefomanceInfo();
        perfomaceInfo.fillFrom(systemInfo);

        ISysInfoMember operatingSystem = new OperatingSystem();
        operatingSystem.fillFrom(systemInfo);

        ISysInfoMember processes = new Processes();
        processes.fillFrom(systemInfo);

        System.out.println(operatingSystem);
        System.out.println(motherBoard);
        System.out.println(processor);
        /*
        System.out.println(perfomaceInfo);
        System.out.println(processes);
        */
    }
}
