package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.ChartBean;
import com.neuedu.hr.business.service.ChartService;
import com.neuedu.hr.sys.annotation.RequirePremission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/char")
public class ChartsController {
    @Autowired
    private ChartService chartService;

    @RequestMapping("/queryChar")
    public String charts() {
        return "chartManage";
    }

    @ResponseBody
    @RequestMapping("/data")
    public Object data() {

        List<ChartBean> departmentChart = chartService.departmentChart();
        List<ChartBean> ratioChart = chartService.ratioChart();
        System.out.println(ratioChart.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("department", departmentChart);
        map.put("ratio", ratioChart);
        return map;
    }
}
