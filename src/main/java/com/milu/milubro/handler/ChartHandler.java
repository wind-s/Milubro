package com.milu.milubro.handler;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 报表处理器，不同类型查找不同处理器
 * @author winds
 */
public class ChartHandler {
    private static Map<Integer, ChartProcessor> chartProcessorMap = new HashMap<>();


    public static void register(int type, ChartProcessor chartProcessor){
        ChartProcessor previousChartProcessor = chartProcessorMap.put(type, chartProcessor);
        if(null != previousChartProcessor){
            throw new RuntimeException("注册器检测到相同的处理器，请保证处理器唯一性。冲突的处理器类型为:" + type);
        }
    }

    public static ChartProcessor getChartProcessor(ChartType chartType){
        ChartProcessor chartProcessor = null;
        if(isSupportChartProcessor(chartType)){
            chartProcessor = chartProcessorMap.get(chartType.getValue());
        }
        return chartProcessor;

    }

    private static boolean isSupportChartProcessor(ChartType chartType){
        if(null == chartType){
            return false;
        }
        return chartProcessorMap.containsKey(chartType.getValue());
    }



}
