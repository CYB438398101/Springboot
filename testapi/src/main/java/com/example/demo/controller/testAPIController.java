package com.example.demo.controller;/**
 * Created by ZKYX on 2018/8/1.
 */

import HttpClientUtil.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author C.Y.B
 * @create 2018-08-01 10:56
 **/
@Controller
public class testAPIController {
    @RequestMapping("/index")
    public String index(){
        System.out.print("123");
        return  "index";
    }
    @ResponseBody
    @RequestMapping("/testAPI")
    public  String testAPI(HttpServletRequest request , HttpServletResponse response){
        String url = request.getParameter("url");
        String method =request.getParameter("method");
       System.out.print(url);
        Map map = new HashMap<String,String>();
        if(!"".equals(url) && method.equals("get")){
            return  HttpUtils.doGet(url);
        }else if(!"".equals(url) && method.equals("post")) {
            return  HttpUtils.doPost(url).toJSONString();
        }else {
           map.put("error","传入参数有误！");
           map.put("code","-1");
           System.out.print(map);
           return map.toString();
        }

    }

}
