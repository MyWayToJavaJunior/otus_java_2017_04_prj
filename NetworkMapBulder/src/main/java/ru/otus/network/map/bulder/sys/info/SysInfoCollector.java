package ru.otus.network.map.bulder.sys.info;



import oshi.SystemInfo;
import ru.otus.network.map.bulder.sys.info.members.ISysInfoMember;
import ru.otus.network.map.bulder.sys.info.members.PrefomanceInfo;
import ru.otus.network.map.bulder.sys.info.members.Processor;

public class SysInfoCollector {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();

        ISysInfoMember processor = new Processor();
        processor.fillFrom(systemInfo);

        ISysInfoMember perfomaceInfo = new PrefomanceInfo();
        perfomaceInfo.fillFrom(systemInfo);

        System.out.println(processor);
        System.out.println(perfomaceInfo);
    }
}
