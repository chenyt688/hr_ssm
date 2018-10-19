package com.neuedu.hr.business.controller;

import com.github.pagehelper.PageInfo;
import com.neuedu.hr.business.entity.Department;
import com.neuedu.hr.business.entity.Position;
import com.neuedu.hr.business.entity.Talent;
import com.neuedu.hr.business.entity.TalentTranform;
import com.neuedu.hr.business.service.DepartmentService;
import com.neuedu.hr.business.service.PositionService;
import com.neuedu.hr.business.service.TalentService;
import com.neuedu.hr.business.service.TalentTranformService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller

@RequestMapping("/talent")

public class TalentController {


    @Autowired
    private TalentService talentService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TalentTranformService talentTranformService;

    @RequestMapping("/queryTalent")
    public String queryTalent(Model model, HttpServletRequest request, Integer pageNo, Integer pages) {

        if (pageNo == null || pageNo < 1)
            pageNo = 1;
        pages = 2;
        if (pageNo > pages)
            pageNo = pages;


        String talent_code = request.getParameter("talentcode");
        String talent_name = request.getParameter("talentname");
        List<Position> allPosition = positionService.getAllPosition();
        List<Department> allDepartment = departmentService.getAllDepartment();
        List<Talent> allTalent = talentService.queryTalent(pageNo, 5);
        PageInfo<Talent> pageInfo = new PageInfo<Talent>(allTalent);
        //List<Talent> allTalent = talentService.queryTalent();
        model.addAttribute("talentList", allTalent);
        model.addAttribute("positionList", allPosition);
        model.addAttribute("departmentList", allDepartment);
        model.addAttribute("pageNo", pageInfo.getPageNum());
        model.addAttribute("pages", pageInfo.getPages());

        return "talentManage";
    }

    @RequestMapping("/insertTalent")
    public String insertTalent(Talent talent, String judgelable) {


        System.out.println("--------->" + talent.toString());
        if (judgelable.equals("insert")) {
            talent.setTalent_pos("无");
            talent.setTalent_dep("无");
            talent.setTalent_status("0");
            talent.setDel_flag("0");
            talentService.insertTalent(talent);
        } else {
            talentService.updateTalent(talent);
        }

        return "redirect:/talent/queryTalent";
    }

    @RequestMapping("/deleteTalent")
    public String deleteTaleny(String lable) {
        talentService.deleteTalent(lable);
        return "redirect:/talent/queryTalent";
    }

    @RequestMapping("/updateMenuTalent")
    public String updateMenuTalent(Talent talent) {

        talentService.updateTalent(talent);
        return "redirect:/talent/queryTalent";
    }

    @RequestMapping("/tranform")
    public String commission(Talent talent) {
        SqlSession sqlSession = null;

        if (talent.getTalent_status().equals("0") || talent.getTalent_status().equals("2")) {
            talent.setTalent_pos("无");
            talent.setTalent_dep("无");
            talent.setTalent_status("0");
            talent.setDel_flag("0");
        }

        talentService.commissionTalent(talent);

        //将数据存入记录表
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());// new Date()为获取当前系统时间
        TalentTranform talentTranform = new TalentTranform();
        talentTranform.setTalent_code(talent.getTalent_code());
        talentTranform.setIn_depart_name(talent.getTalent_dep());
        talentTranform.setIn_pos_name(talent.getTalent_pos());
        talentTranform.setTran_date(date);
        System.out.println(talentTranform.toString());

        talentTranformService.insertRecord(talentTranform);

        return "redirect:/talent/queryTalent";
    }
}
