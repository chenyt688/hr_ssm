package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {

    @Insert("insert into hr_departments(depart_name,depart_code,depart_phone,del_flag)" +
            " values(#{depart_name},#{depart_code},#{depart_phone},#{del_flag})")
    void insertDepartment(Department department);


    @Delete("delete from hr_departments where depart_code = #{depart_code} ")
    void deleteDepartment(@Param("depart_code") String depart_code);


    @Update("update hr_departments set depart_name = #{depart_name},depart_code=#{depart_code} " +
            ",depart_phone = #{depart_phone} where = depart_code=#{depart_code}")
    void updateDepartment(Department position);

    @Select("select * from hr_departments")
    List<Department> getAllDepartment();


}


