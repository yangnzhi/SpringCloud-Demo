package com.youngnzhi.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngnzhi on 2019/2/20.
 */
@RestController
public class ConfigClientRest {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles}")
    private String profiles;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @RequestMapping("/getGitConfigInfo")
    private String getGitConfigInfo(){
        String str = "applicationName: "+applicationName+"\t eurekaServers:"+eurekaServers+"\t port: "+port + "\t profiles" + profiles;
        System.out.println("******str: "+ str);
        return "applicationName: "+applicationName+"\t eurekaServers:"+eurekaServers+"\t port: "+port + "\t profiles" + profiles;
    }
}
