package com.milu.milubro.handler;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  在servlet初始化之前， 使用PostConstruct 缓存处理器到内存中
 * @author winds
 */
public abstract class BaseChartProcessor implements ChartProcessor{

    @PostConstruct
    public void registerProcessor(){
        ChartHandler.register(getProcessorType(), this);
    }

    @Override
    public Object initChart(ChartType chartType, Object data) {
        return this.initChart(chartType, data);
    }

    abstract protected int getProcessorType();
}
