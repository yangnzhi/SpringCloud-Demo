package com.youngnzhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by youngnzhi on 2019/2/21.
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8001_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptProvider8001_App.class, args);
    }
}
