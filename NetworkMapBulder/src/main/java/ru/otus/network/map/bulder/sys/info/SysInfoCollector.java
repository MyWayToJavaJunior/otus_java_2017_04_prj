package ru.otus.network.map.bulder.sys.info;



import com.sun.management.OperatingSystemMXBean;
import oshi.SystemInfo;
import ru.otus.network.map.bulder.sys.info.members.ISysInfoMember;
import ru.otus.network.map.bulder.sys.info.members.Processor;

import static java.lang.management.ManagementFactory.getOperatingSystemMXBean;

public class SysInfoCollector {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();

        ISysInfoMember processor = new Processor();
        processor.fillFrom(systemInfo);
        System.out.println(processor);
    }
}
