package com.kkzxm.ppmvc.manager.vue.admin.config;

import com.kkzxm.ppmvc.config.DataSourceContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SetDbs {
    @Pointcut("execution(* com.kkzxm.ppmvc.manager.vue.admin.core.mapper.*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void hehe() {
        DataSourceContextHolder.setDataSource("dbs2");
    }
}
