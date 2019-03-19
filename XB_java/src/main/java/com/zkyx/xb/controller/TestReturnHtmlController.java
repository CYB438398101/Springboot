package com.zkyx.xb.controller;

import com.zkyx.xb.model.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestReturnHtmlController {
    private final static Logger logger = LoggerFactory.getLogger(TestConttroller.class);

    @RequestMapping("/returnHtml")
    public String testReturnHtml(){

        System.out.print("准备跳转至index.html");

        return "index";
    }
    @RequestMapping("/testModeHtml")
    public String testModeHtml(Model model){

        List list =  new ArrayList();

        Test test = new Test();

        test.setName("ceshi");

        test.setId(3);

        Test test1 = new Test();

        test1.setId(4);

        test1.setName("ceshi2");

        list.add(test);

        list.add(test1);

         model.addAttribute("test",test);
         model.addAttribute("list",list);

        return  "index";
    }
}
