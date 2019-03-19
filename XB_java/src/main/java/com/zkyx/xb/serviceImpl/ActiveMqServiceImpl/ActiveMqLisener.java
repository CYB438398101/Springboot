package com.zkyx.xb.serviceImpl.ActiveMqServiceImpl;

import org.springframework.jms.annotation.JmsListener;

public class ActiveMqLisener {
    @JmsListener(destination="test1")
    public void recieve1(String message) {
        System.out.println("接收到queue的消息为：[" + message + "]###################");
    }
    @JmsListener(destination="topic-1", containerFactory="topicListenerContainer")
    public void recieve2(String message) {
        System.out.println("接收到topic的消息为[" + message + "]###################");
    }
}
