package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.ChartBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChartDao {
    List<ChartBean> departmentChart();

    List<ChartBean> ratioChart();
}
