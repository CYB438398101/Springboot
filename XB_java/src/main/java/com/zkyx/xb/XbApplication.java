package com.zkyx.xb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan("com.zkyx.xb.dao")
@EnableScheduling
@EnableJms
public class XbApplication {

    public static void main(String[] args) {
        SpringApplication.run(XbApplication.class, args);
    }

}
