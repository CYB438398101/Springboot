package com.zkyx.xb.serviceImpl.ActiveMqServiceImpl;

import com.zkyx.xb.config.ActiveMqConfig;
import com.zkyx.xb.service.ActiveMqService.ActiveMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
@Service(value = "activeMqService")
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name = "queue1")
    private Destination queue;

    @Override
    public void sendMessage(Destination destination, String message) {
                 jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(String message) {
                 jmsMessagingTemplate.convertAndSend(queue,message);
    }
}
