package com.neuedu.hr.business.controller;

import com.neuedu.hr.business.entity.Position;
import com.neuedu.hr.business.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping("/queryPosition")
    public String queryPosition(Model model) {
        List<Position> allPosition = positionService.getAllPosition();

        model.addAttribute("positionList", allPosition);
        return "positionManage";
    }

    @RequestMapping("/deletePosition")
    public String deleteDepartment(String lable) {
        positionService.deletePosition(lable);
        return "redirect:/position/queryPosition";
    }

    @RequestMapping("/insertPosition")

    public String insertPosition(Position position, String judgelable) {

        if (judgelable.equals("insert")) {
            positionService.insertPosition(position);
        } else {
            positionService.updatePosition(position);
        }

        return "redirect:/position/queryPosition";
    }


}
