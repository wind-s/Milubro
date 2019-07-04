package com.milu.milubro.handler;


import org.springframework.stereotype.Component;

/**
 *
 *  处理器在初始化就被写入了内存中
 * @author winds
 */

@Component
public class ChartOneProcessor extends BaseChartProcessor{

    @Override
    public Object initChart(ChartType chartType, Object data) {
        return "hello world, i'm chart one processor!";

    }

    @Override
    protected int getProcessorType() {
        return ChartType.CHART1.getValue();
    }

}
