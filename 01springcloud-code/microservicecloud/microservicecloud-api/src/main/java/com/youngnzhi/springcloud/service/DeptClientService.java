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
 * 声明式feign负载均衡配置：接口+注解
 * @FeignClient feign负载均衡声明式注解，
 *    value:为微服务名称，针对这个微服务细腻化feign负载均衡
 *    fallback:当执行当前微服务中方法或当前微服务所在服务器出现异常时
 *             调用DeptClientServiceFallbackFactory类返回配置好的备选响应信息给前台，而不是返回不可阅读的报错的异常信息或服务器异常
 *             做了服务降级处理，让客户端在服务端不可用时也会获得提示信息而不会挂起耗死服务器
 * @RequestMapping value和服务端映射地址一致
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
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
