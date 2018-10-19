package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.UserAndRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAndRoleDao {
    public void insertUserandRole(UserAndRole userAndRole);

    @Delete("delete from hr_users_roles where user_code =#{user_code}")
    public void delete(@Param("user_code") String user_code);
}
