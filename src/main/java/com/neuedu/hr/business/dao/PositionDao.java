package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Position;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionDao {

    @Insert("insert into hr_positions(pos_name,pos_code,pos_salary,del_flag)" +
            " values(#{pos_name},#{pos_code},#{pos_salary},#{del_flag})")
    void insertPosition(Position position);


    @Delete("delete from hr_positions where pos_code = #{pos_code} ")
    void deletePosition(@Param("pos_code") String pos_code);


    @Update("update hr_positions set pos_name = #{pos_name},pos_code=#{pos_code} ,pos_salary = #{pos_salary} where pos_code=#{pos_code}")
    void updatePosition(Position position);

    @Select("select * from hr_positions")
    List<Position> getAllPosition();
}
