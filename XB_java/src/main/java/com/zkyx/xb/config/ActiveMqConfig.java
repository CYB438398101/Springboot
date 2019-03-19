package com.zkyx.xb.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@Configuration
@ConfigurationProperties(prefix = "spring.activemq")
public class ActiveMqConfig {

    @Value("queue_1")
     private String queue1_1;
    @Value("queue_2")
     private String queue2_;
    @Value("topic_1")
     private String topic_1;
    @Value("topic_2")
     private String topic_2;

    @Bean
    public Destination queue1() {
        return new ActiveMQQueue("queue-1");
    }

    @Bean
    public Destination queue2() {
        return new ActiveMQQueue("queue-2");
    }

    @Bean
    public Destination topic1() {
        return new ActiveMQTopic("topic-1");
    }

    @Bean
    public Destination topic2() {
        return new ActiveMQTopic("topic-2");
    }

    /**
     * JmsListener注解默认只接收queue消息,如果要接收topic消息,需要设置containerFactory
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerContainer(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory topicListenerContainer = new DefaultJmsListenerContainerFactory();
        topicListenerContainer.setPubSubDomain(true);
        topicListenerContainer.setConnectionFactory(activeMQConnectionFactory);
        return topicListenerContainer;
    }


    /**
     * 消息重试配置项
     * @return
     */
    @Bean
    public RedeliveryPolicy redeliveryPolicy(){
        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setUseExponentialBackOff(true);//是否在每次失败重发是，增长等待时间
        redeliveryPolicy.setMaximumRedeliveryDelay(-1);//设置重发最大拖延时间，-1 表示没有拖延，只有setUseExponentialBackOff(true)时生效
        redeliveryPolicy.setMaximumRedeliveries(2);//重发次数
        redeliveryPolicy.setInitialRedeliveryDelay(1);//重发时间间隔
        redeliveryPolicy.setBackOffMultiplier(2);//第一次失败后重发前等待500毫秒，第二次500*2，依次递增
        redeliveryPolicy.setUseCollisionAvoidance(false);//是否避免消息碰撞
        return redeliveryPolicy;
    }

    @Bean
    public ActiveMQConnectionFactory factory(@Value("${spring.activemq.broker-url}")String url, RedeliveryPolicy redeliveryPolicy){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", url);
        factory.setRedeliveryPolicy(redeliveryPolicy);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory factory){
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setDeliveryMode(2);//设置持久化，1 非持久， 2 持久化
        jmsTemplate.setConnectionFactory(factory);
               /**
                   SESSION_TRANSACTED = 0  事物提交并确认
                   AUTO_ACKNOWLEDGE = 1    自动确认
                           CLIENT_ACKNOWLEDGE = 2    客户端手动确认   
                           DUPS_OK_ACKNOWLEDGE = 3    自动批量确认
                           INDIVIDUAL_ACKNOWLEDGE = 4    单条消息确认 activemq 独有
                         */
        jmsTemplate.setSessionAcknowledgeMode(4);//消息确认模式
        return jmsTemplate;
    }



}
