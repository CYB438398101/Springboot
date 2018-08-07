package com.example.demo.conf;/**
 * Created by ZKYX on 2018/8/1.
 */

import com.example.demo.Fillter.CROSFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author C.Y.B
 * @create 2018-08-01 16:02
 **/
@Configuration
public class CrosFilterConf {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new CROSFilter());//添加过滤器
        registration.addUrlPatterns("/testAPI/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("MyFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        return registration;
    }
}
