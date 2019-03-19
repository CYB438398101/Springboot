package com.zkyx.xb.service.ActiveMqService;


import javax.jms.Destination;

public interface ActiveMqService {
    /**
     * Description: 指定消息队列，以及对应的消息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message);

    /**
     * Description: 使用默认消息队列，发送消息
     * @param message
     */
    public void sendMessage(final String message);

}
