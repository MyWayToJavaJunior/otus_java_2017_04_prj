package ru.otus.network.map.bulder.sys.info;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

        ISysInfoMember dataStorageSubsystem = new DataStorageSubsystem();
        dataStorageSubsystem.fillFrom(systemInfo);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataStorageSubsystem.toString());
        System.out.print(json);

 /*
        System.out.println(operatingSystem);
        System.out.println(motherBoard);
        System.out.println(processor);

        System.out.println(perfomaceInfo);
        System.out.println(processes);
        */
    }
}
