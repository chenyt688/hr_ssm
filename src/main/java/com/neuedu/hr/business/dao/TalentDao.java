package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Talent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalentDao {
    @Select("select * from hr_talents")
    List<Talent> queryTalent();

    @Insert("insert into hr_talents(talent_name,talent_code,talent_status,talent_sexual," +
            "talent_identity,del_flag,talent_dep,talent_pos)" +
            " values(#{talent_name},#{talent_code},#{talent_status}" +
            ",#{talent_sexual},#{talent_identity},#{del_flag},#{talent_dep},#{talent_pos})")
    void insertTalent(Talent talent);

    @Delete("delete from hr_talents where talent_code = #{talent_code}")
    void deleteTalent(@Param("talent_code") String talent_code);

    @Update("update hr_talents set talent_name = #{talent_name} ," +
            "talent_sexual=#{talent_sexual},talent_identity=#{talent_identity} where talent_code = #{talent_code}")
    void updateTalent(Talent talent);


    @Update("update hr_talents set talent_status=#{talent_status},talent_dep =#{talent_dep}" +
            ",talent_pos =#{talent_pos} where talent_code = #{talent_code}")
    void commissionTalent(Talent talent);

    @Select("select * from hr_talents where talent_code = #{talent_code}")
    Talent queryTalentByTalent_code(String talent_code);
}
