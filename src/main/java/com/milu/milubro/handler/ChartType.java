package com.milu.milubro.handler;


public enum ChartType {
    CHART1(1, "报表1"),
    CHART2(2, "报表2"),
    CHART3(3, "报表3");


    ChartType(int value, String name){
        this.value = value;
        this.name = name;
    }

    private int value;
    private String name;

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


    public static ChartType parseFromType(int type) {
        ChartType[] allTypes = values();
        for (ChartType chartType : allTypes) {
            if (chartType.getValue() == type) {
                return chartType;
            }
        }
        return null;
    }
}
