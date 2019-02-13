package com.youngnzhi.springcloud.controller;

import com.youngnzhi.springcloud.entities.Dept;
import com.youngnzhi.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by youngnzhi on 2019/1/23.
 */
@RestController
public class DeptController_Consumer_Feign {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean add (Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return deptClientService.get(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return deptClientService.list();
    }

    @RequestMapping("/consumer/dept/discovery")
    public Object discovery() {
        return deptClientService.discovery();
    }
}
