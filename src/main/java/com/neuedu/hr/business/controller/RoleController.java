package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.dao.RoleAndMenuDao;
import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.entity.Role;
import com.neuedu.hr.business.entity.RoleAndMenu;
import com.neuedu.hr.business.service.MenuService;
import com.neuedu.hr.business.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleAndMenuDao roleAndMenuDao;


    @RequestMapping("/queryRole")
    public String queryRole(Model model, HttpServletRequest request){
        String role_code = request.getParameter("rolecode");
        String role_name = request.getParameter("rolename");

        //System.out.println("-------->" + role_code + role_name);
        List<Role> allRole = roleService.getRoleMenuByMulCondition(role_code,role_name);   //角色信息和菜单权限信息
        //List<Role> roles = roleService.getAllRole();
        //获取数据库中所有的菜单数据
        List<Menu> menuList = menuService.getAllMenu();
        model.addAttribute("roleList",allRole);
        model.addAttribute("menuList",menuList);
        return "roleManage";
    }


    @RequestMapping("/insertRole")
    public String insertRole(Role role, HttpServletRequest request, String judgelable) {

        roleAndMenuDao.deleteRoleAndMenu(role.getRole_code());
        //获取到赋予角色权限界面的标识码
        String menuscode[] = request.getParameterValues("menuvalue");
        //将数据插入到hr_roles表中
        role.setDel_flag('0');

        //System.out.println("-------->" +role.toString());
        //获取所有的权限菜单

        List<Menu> allMenu = menuService.getAllMenu();
        int flag = 0;
        for (Menu m : allMenu) {
            for (int i = 0; i < menuscode.length; i++) {
                if (menuscode[i].equals(m.getMenu_code())) {
                    flag = 1;
                    break;
                }
            }
            RoleAndMenu roleAndMenu = new RoleAndMenu();
            roleAndMenu.setMenu_code(m.getMenu_code());
            roleAndMenu.setRole_code(role.getRole_code());
            if (flag == 1) {
                roleAndMenu.setPower('1');
            } else {
                roleAndMenu.setPower('0');
            }
            //System.out.println("--------->" + roleAndMenu.toString() +"      " + flag);
            flag = 0;

            roleAndMenuDao.insertRoleAndMenu(roleAndMenu);
        }
        if (judgelable.equals("insert")) {
            roleService.insertRole(role);
        } else {
            roleService.updateRole(role);
        }
        return "redirect:/role/queryRole";
    }


    @RequestMapping("/deleteRole")
    public String deleteRole(String lable){

        roleAndMenuDao.deleteRoleAndMenu(lable);
        roleService.deleteRoleByRoleCode(lable);
        return "redirect:/role/queryRole";
    }

}
