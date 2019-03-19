package com.zkyx.xb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Component
public class redisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setStringKey(){
        redisTemplate.opsForValue().set("test1","test1");
    }

    @Test
    public void getStringKey(){
       String s =(String)redisTemplate.opsForValue().get("test");
       System.out.print("从redis中得到key为test的value为："+s);
    }
    @Test
    @Scheduled(cron = "0/5 * * * * ?")
    public void testQuartz(){
        System.out.println("每五秒执行一次");
    }
}
