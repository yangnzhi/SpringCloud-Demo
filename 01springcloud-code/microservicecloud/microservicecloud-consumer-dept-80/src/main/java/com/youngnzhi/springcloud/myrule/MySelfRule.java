package com.youngnzhi.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by youngnzhi on 2019/2/2.
 * 自定义或者改变ribbon负载均衡默认算法
 * 官方文档明确给出了警告：
 *   这个自定义配置类不能放在@ComponentScan所扫描的当前包下以及子包下，
 *   否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说我们达不到特殊化定制的目的了。
 * com.youngnzhi.springcloud下的cfgbeans，controller，和根目录都不能放置，需要单独建一个包放置
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        //return new RoundRobinRule();//默认轮询算法
        return new RandomRule();//随机算法
    }
}
