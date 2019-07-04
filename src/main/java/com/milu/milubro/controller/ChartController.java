package com.milu.milubro.controller;

import com.milu.milubro.handler.ChartHandler;
import com.milu.milubro.handler.ChartProcessor;
import com.milu.milubro.handler.ChartType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("task")
public class ChartController {

    @RequestMapping("init/{type}")
    public Object hello(@PathVariable(name = "type") final Integer id){
        //根据类型查找处理器
        ChartProcessor chartProcessor = ChartHandler.getChartProcessor(ChartType.parseFromType(id));

        Object result = chartProcessor.initChart(ChartType.parseFromType(id), "data");

        return result.toString();
    }
}
