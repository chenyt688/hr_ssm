package com.neuedu.hr.business.controller;

import com.github.pagehelper.PageInfo;
import com.neuedu.hr.business.entity.TalentTranform;
import com.neuedu.hr.business.service.TalentTranformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tranform")
public class RecordController {
    @Autowired
    private TalentTranformService talentTranformService;

    @RequestMapping("/queryInfo")
    public String queryRecord(Model model, Integer pageNo, Integer pages) {

        if (pageNo == null || pageNo < 1)
            pageNo = 1;
        pages = 2;
        if (pageNo > pages)
            pageNo = pages;
        List<TalentTranform> records = talentTranformService.queryCommissionRecord(pageNo, 7);
        PageInfo<TalentTranform> pageInfo = new PageInfo<TalentTranform>(records);
        model.addAttribute("talentTranforms", records);
        //pageInfo.getPageNum() 当前页
        model.addAttribute("pageNo", pageInfo.getPageNum());
        //pageInfo.getPageSize()当前页的数量
        //pageInfo.getPages()总页数
        model.addAttribute("pages", pageInfo.getPages());
        return "tranformManage";
    }


}
