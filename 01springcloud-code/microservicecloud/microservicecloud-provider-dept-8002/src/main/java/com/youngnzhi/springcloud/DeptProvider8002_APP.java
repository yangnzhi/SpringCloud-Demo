package com.youngnzhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by youngnzhi on 2019/1/24.
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptProvider8002_APP {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_APP.class,args);
    }
}
