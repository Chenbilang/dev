package com.example.demo22.contorller.view;

import com.example.demo22.pojo.SysLabel;
import com.example.demo22.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 标签管理视图
 * @author chenbilang
 */
@Controller
public class LabelViewContorller {

    @Autowired
    private LabelService labelService;

    @RequestMapping("/list")
    public String add(Model model)  {
        return "label/list";
    }


}
