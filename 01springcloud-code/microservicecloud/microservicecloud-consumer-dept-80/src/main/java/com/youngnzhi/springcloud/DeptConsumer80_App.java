package com.youngnzhi.springcloud;

import com.youngnzhi.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by youngnzhi on 2019/1/23.
 * @EnableEurekaClient Ribbon负载均衡是在客户端
 * @RibbonClient Ribbon负载均衡算法默认算法时轮询算法，要改变或者自定义Ribbon负载均衡算法，需要添加这个注解，而且配置自定义rule类
 *    name=eureka服务注册中心中eureka服务端的spring application name，value=自定义算法类
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
