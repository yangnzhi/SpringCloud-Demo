package com.youngnzhi.springcloud.controller;

import com.youngnzhi.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by youngnzhi on 2019/1/23.
 */
@RestController
public class DeptController_Consumer {
    //消费者call服务提供方普通通信 resttemplate通过服务提供方requestmapping url找到服务
    //private static final String REST_URL_PREFIX = "http://localhost:8001";

    //ribbon负载均衡，通过spring application name连接服务提供方 在eureka服务注册中心，spring application name会显示成大写，所以这里连接名称改成大写
    //好处 Ribbon和Eureka整合后Consumer可以直接调用服务而不用再关心地址和端口号
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/dept/add")
    public boolean add (Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
