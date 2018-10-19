package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.TalentTranform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalentTranformDao {
    @Select("select * from hr_talents_tranform")
    public List<TalentTranform> queryCommissionRecord();

    @Insert("insert into hr_talents_tranform(in_depart_name,in_pos_name,talent_code,tran_date) values(#{in_depart_name}," +
            "#{in_pos_name},#{talent_code},#{tran_date})")
    public void insertCommissionRecord(TalentTranform talentTranform);


}
