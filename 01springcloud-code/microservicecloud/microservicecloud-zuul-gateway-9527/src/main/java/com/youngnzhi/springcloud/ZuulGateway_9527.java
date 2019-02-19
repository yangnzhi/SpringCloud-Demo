package com.youngnzhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by youngnzhi on 2019/2/19.
 * @EnableZuulProxy 开启zuul路由代理
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulGateway_9527 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulGateway_9527.class,args);
    }
}
