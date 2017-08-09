package ru.otus.network.map.bulder.sys.info.members;

import oshi.SystemInfo;

public interface ISysInfoMember {
    void fillFrom(SystemInfo si);
}
