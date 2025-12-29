package com.learn.manager.vue.admin.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.learn.treeEn.config.DataSourceContextHolder;

@Aspect
@Component
public class SetDbs {
    @Pointcut("execution(* com.learn.manager.vue.admin.core.mapper.*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void hehe() {
        DataSourceContextHolder.setDataSource("dbs2");
    }
}
