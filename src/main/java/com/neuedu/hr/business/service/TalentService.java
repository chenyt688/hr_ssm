package com.neuedu.hr.business.service;

import com.github.pagehelper.PageHelper;
import com.neuedu.hr.business.dao.TalentDao;
import com.neuedu.hr.business.entity.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TalentService {
    @Autowired
    private TalentDao talentDao;

    public List<Talent> queryTalent(Integer pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return talentDao.queryTalent();
    }

    public void deleteTalent(String talent_code) {
        talentDao.deleteTalent(talent_code);
    }

    public void insertTalent(Talent talent) {
        talentDao.insertTalent(talent);
    }

    public void updateTalent(Talent talent) {
        talentDao.updateTalent(talent);
    }

    @Transactional
    public void commissionTalent(Talent talent) {
        talentDao.commissionTalent(talent);

    }

    public Talent queryTalentByTalent_code(String talent_cde) {
        return talentDao.queryTalentByTalent_code(talent_cde);
    }
}
