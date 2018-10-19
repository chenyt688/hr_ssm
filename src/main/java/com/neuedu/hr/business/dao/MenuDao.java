package com.neuedu.hr.business.dao;

import com.neuedu.hr.business.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    List<Menu> getAllMenu();

    @Insert("insert into hr_menus(menu_code,menu_name,menu_url,del_flag)" +
            " values(#{menu_code},#{menu_name},#{menu_url},#{del_flag})")
    void insertMenu(Menu menu);


    @Delete("delete from hr_menus where menu_code = #{menu_code} ")
    void deleteMenu(@Param("menu_code") String menu_code);


    @Update("update hr_menus set menu_name = #{menu_name} ,menu_url = #{menu_url} where menu_code = #{menu_code}")
    void updateMenu(Menu menu);

    @Select("")
    List<Menu> getAllMenuByCondition();
}
