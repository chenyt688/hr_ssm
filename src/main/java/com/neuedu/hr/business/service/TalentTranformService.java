package com.neuedu.hr.business.service;

import com.github.pagehelper.PageHelper;
import com.neuedu.hr.business.dao.TalentTranformDao;
import com.neuedu.hr.business.entity.TalentTranform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentTranformService {
    @Autowired
    private TalentTranformDao talentTranformDao;

    public void insertRecord(TalentTranform talentTranform) {
        talentTranformDao.insertCommissionRecord(talentTranform);

    }

    public List<TalentTranform> queryCommissionRecord(Integer pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return talentTranformDao.queryCommissionRecord();
    }

}
