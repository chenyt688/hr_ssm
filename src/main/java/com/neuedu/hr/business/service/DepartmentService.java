package com.neuedu.hr.business.service;

import com.neuedu.hr.business.dao.DepartmentDao;
import com.neuedu.hr.business.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    public void insertDepartment(Department department) {
        departmentDao.insertDepartment(department);
    }

    public void deleteDepartment(String department_code) {
        departmentDao.deleteDepartment(department_code);
    }

    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

}
