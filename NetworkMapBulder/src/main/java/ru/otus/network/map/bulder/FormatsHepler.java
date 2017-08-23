package ru.otus.network.map.bulder;

import java.text.DecimalFormat;

public class FormatsHepler {
    public static String formatFloat(String fmt, double d) {
        DecimalFormat df = new DecimalFormat(fmt);
        return df.format(d);
    }

    public static String formatFloatDef(double d) {
        return formatFloat("0.00", d);
    }

    public static String formatBytesAsKB(long bytes) {
        return formatFloat("0.00", bytes / 1024d) + "KB";
    }

    public static String formatBytesAsMB(long bytes) {
        return formatFloat("0.00", bytes / 1024d / 1024d) + "MB";
    }

    public static String formatBytesAsGB(long bytes) {
        return formatFloat("0.00", bytes / 1024d / 1024d / 1024d) + "GB";
    }

    public static String formatPercents(double percents) {
        return formatFloat("0.00", percents) + "%";
    }



}
