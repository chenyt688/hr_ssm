package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.ChartDao;
import com.neuedu.hr.business.entity.ChartBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartService {
    @Autowired
    private ChartDao chartDao;

    public List<ChartBean> departmentChart() {
        return chartDao.departmentChart();
    }


    public List<ChartBean> ratioChart() {
        List<ChartBean> chartBeans = chartDao.ratioChart();
        for (ChartBean c : chartBeans) {
            if (c.getName().equals("0")) {
                c.setName("男");
            } else {
                c.setName("女");
            }
        }

        return chartBeans;
    }
}
