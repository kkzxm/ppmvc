package com.kkzxm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class)
@MapperScan(basePackages = { "com.kkzxm.ppmvc.core.mapper","com.kkzxm.ppmvc.manager.vue.admin.core.mapper"})
public class PpmvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(PpmvcApplication.class, args);
    }
}