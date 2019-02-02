package com.youngnzhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by youngnzhi on 2019/1/23.
 * EnableEurekaClient : EurekaServer客户端启动类,本服务启动后会自动注册进eureka服务中 服务注册
 * EnableDiscoveryClient：服务发现
 */
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class DeptProvider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class,args);
    }
}
