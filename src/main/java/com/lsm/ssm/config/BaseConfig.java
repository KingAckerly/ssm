package com.lsm.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration+@Bean用于配置一个SpringBean
//如果希望通过这种java方式配置还需在Spring配置文件中加上对此包的扫描,否则启动不报错,但不会被执行
@Configuration
public class BaseConfig {

    //@baen注解的方法返回值不能为void
    @Bean
    public String config() {
        System.out.println("开始执行config配置");
        return null;
    }
}
