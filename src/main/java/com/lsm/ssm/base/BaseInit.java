package com.lsm.ssm.base;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component表明此类是Spring的一个组件
//如果希望通过这种java方式配置还需在Spring配置文件中加上对此包的扫描,否则启动不报错,但不会被执行
@Component
public class BaseInit {

    //@PostConstruct用于执行系统初始化操作
    @PostConstruct
    private void init() {
        System.out.println("开始执行init初始化");
    }
}
