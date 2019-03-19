package com.zkyx.xb.task;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

public class TestTask  extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        /*
        * 调用实际执行的任务或方法
        * 在这只是个演示
        * */
        System.out.print("执行定时任务：----"+new Date());
    }
}
