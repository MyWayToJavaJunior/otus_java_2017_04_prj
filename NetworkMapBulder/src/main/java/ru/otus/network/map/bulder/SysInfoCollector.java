package ru.otus.network.map.bulder;



import com.sun.management.OperatingSystemMXBean;

import static java.lang.management.ManagementFactory.getOperatingSystemMXBean;

public class SysInfoCollector {
    public static void main(String[] args) {
        OperatingSystemMXBean bean = (OperatingSystemMXBean) getOperatingSystemMXBean();

        System.out.println(System.getenv("PROCESSOR_IDENTIFIER"));
        System.out.println(System.getenv("PROCESSOR_ARCHITECTURE"));
        System.out.println(bean.getAvailableProcessors());

        System.out.println(bean.getTotalPhysicalMemorySize());
        System.out.println(bean.getFreePhysicalMemorySize());
    }
}
