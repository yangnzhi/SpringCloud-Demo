package com.youngnzhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by youngnzhi on 2019/1/23.
 * @EnableEurekaClient Ribbon负载均衡是在客户端
 * @EnableFeignClients feign负载均衡client注解
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.youngnzhi.springcloud"})
@ComponentScan("com.youngnzhi.springcloud")
public class DeptConsumer80_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_Feign_App.class,args);
    }
}
