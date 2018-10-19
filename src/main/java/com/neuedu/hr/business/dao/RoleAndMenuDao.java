package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.RoleAndMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAndMenuDao {

    public void insertRoleAndMenu(RoleAndMenu roleAndMenu);

    @Delete("delete from hr_roles_menus where role_code = #{role_code}")
    void deleteRoleAndMenu(@Param("role_code") String role_code);

}
