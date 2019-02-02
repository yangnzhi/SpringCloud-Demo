package com.youngnzhi.springcloud.controller;

import com.google.common.collect.Maps;
import com.youngnzhi.springcloud.entities.Dept;
import com.youngnzhi.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    //微服务发现
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/dept/add",method= RequestMethod.POST)
    public boolean add(@RequestBody Dept dept)
    {
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return service.get(id);
    }

   /* @RequestMapping(value="/dept/list",method= RequestMethod.GET)
    public List<Dept> list()
    {
        return service.list();
    }
*/

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public Map list()
    {
        Map model = Maps.newHashMap();
        model.put("db","8002");
        return model;
    }

    //微服务发现
    @RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
    public Object discovery() {
        List<String> serviceList =  discoveryClient.getServices();
        System.out.println("**********" + serviceList);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT01");

        //当前微服务信息，这里list长度应该为1，就是当前微服务
        if(!CollectionUtils.isEmpty(srvList)){
            for(ServiceInstance element : srvList) {
                // spring-application-name host server.port http://+host:server.port
                System.out.println(element.getServiceId() +
                            "\t" + element.getHost() +
                            "\t" + element.getPort() +
                            "\t" + element.getUri());
            }
        }
        return this.discoveryClient;
    }
}
