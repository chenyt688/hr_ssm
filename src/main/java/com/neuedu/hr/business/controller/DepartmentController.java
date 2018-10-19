package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.Department;
import com.neuedu.hr.business.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping("/queryDepartment")
    public String queryDepartment(Model model) {
        List<Department> allDepartment = departmentService.getAllDepartment();
        //System.out.println("________________>" + allDepartment.size());
        model.addAttribute("departList", allDepartment);
        return "departmentManage";
    }

    @RequestMapping("/deleteDepartment")
    public String deleteDepartment(String lable) {
        departmentService.deleteDepartment(lable);
        return "redirect:/department/queryDepartment";
    }

    @RequestMapping("/insertDepartment")
    public String insertDepartment(Department department, String judgelable) {

        if (judgelable.equals("insert")) {
            departmentService.insertDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }
        return "redirect:/department/queryDepartment";
    }
}
