package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.Menu;
import com.neuedu.hr.business.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryMenu")
    public String qeueryMenu(Model model, HttpServletRequest request) {
        String menu_code = request.getParameter("menucode");
        String menu_name = request.getParameter("menuname");
        List<Menu> allMenu = menuService.getAllMenu();
        model.addAttribute("menuList", allMenu);
        return "menuManage";
    }

    @RequestMapping("/insertMenu")
    public String insertMenu(Menu menu, String judgelable) {
        if (judgelable.equals("insert")) {
            menu.setDel_flag('0');
            menuService.insertMenu(menu);
        } else {
            menuService.updateMenu(menu);
        }
        return "redirect:/menu/queryMenu";
    }

    @RequestMapping("/deleteMenu")
    public String deleteMenu(String lable) {
        menuService.deleteMenu(lable);

        return "redirect:/menu/queryMenu";
    }

    @RequestMapping("/updateMenu")
    public String updateMenu(Menu menu) {
        menuService.updateMenu(menu);
        return "redirect:/menu/queryMenu";
    }
}
