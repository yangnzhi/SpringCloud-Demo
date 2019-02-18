package com.youngnzhi.springcloud.service;

import com.youngnzhi.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by youngnzhi on 2019/2/18.
 * Description: 服务降级在客户端配置之: 添加一个实习了FallbackFactory的类
 * 在客户端调用的每个方法中，添加备选响应信息
 * 这里举例说明，只添加了get方法的备选响应
 * 一定一定一定记得加 @Component 注解！！！
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                //备选响应信息
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand");
                dept.setDb_source("not found in this MYSQL");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
