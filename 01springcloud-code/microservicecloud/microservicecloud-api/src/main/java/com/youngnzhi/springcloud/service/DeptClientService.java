package com.youngnzhi.springcloud.service;

import com.youngnzhi.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by youngnzhi on 2019/2/13.
 * feign负载均衡配置：接口+注解
 * @FeignClient feign负载均衡注解，value为微服务名称，针对这个微服务细腻化feign负载均衡
 * @RequestMapping value和服务端映射地址一致
 */
@FeignClient("MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(Dept dept);

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id);

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list();

    @RequestMapping("/dept/discovery")
    public Object discovery();
}
