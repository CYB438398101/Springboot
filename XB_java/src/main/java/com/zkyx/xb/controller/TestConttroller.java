package com.zkyx.xb.controller;

import com.zkyx.xb.model.Test;
import com.zkyx.xb.service.TestService;
import com.zkyx.xb.serviceImpl.TestServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(description = "测试swagger接口") //描述此controller 功能 例如：用户接口
public class TestConttroller {

    private final static Logger logger = LoggerFactory.getLogger(TestConttroller.class);
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)

    @ApiOperation(value = "获取测试用户信息",notes = "获取所有用户信息") // 具体接口功能描述
    //@ApiImplicitParam()   //接受参数 的设置   @ApiImplicitParam(name = "cid", value = "客户id", required = true, dataType = "String")

    public List<Test> Test(){

        List testList = new ArrayList();

        Test test = new Test();
        Test test1 = new Test();
        test.setId(1);
        test.setName("张三");
        test1.setId(2);
        test1.setName("李四");

        testList.add(test);
        testList.add(test1);
        logger.info("【打印日志】");
        logger.info("id:{},name:{}",test.getId(),test.getName());
        return testList;
    }

    @RequestMapping("getAllTest")
    public List<Test> findAllTestInfo(){

        List<Test> testLists= new ArrayList<>();

        testLists=testService.getALLTest();

        return  testLists;
    }
}
