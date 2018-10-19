package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Role;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
   List<Role> getAllRole();

    List<Role> getRoleMenuByMulCondition(String role_code, String role_name);

    void deleteRoleByRoleCode(String role_code);

    void inserRole(Role role);

    @Update("update hr_roles set role_code = #{role_code} ,role_name = #{role_name} where role_code = #{role_code}")
    void updateRole(Role role);
}
