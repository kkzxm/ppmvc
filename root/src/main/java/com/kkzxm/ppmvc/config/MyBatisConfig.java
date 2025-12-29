package com.kkzxm.ppmvc.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class MyBatisConfig {
    private final MybatisSqlSessionFactoryBean factory;

    {
        factory = new MybatisSqlSessionFactoryBean();
    }

    // 路径
    @Value("${spring.datasource.dbs1.url}")
    String url1;
    @Value("${spring.datasource.dbs1.name}")
    String name1;

    @Value("${spring.datasource.dbs2.url}")
    String url2;
    @Value("${spring.datasource.dbs2.name}")
    String name2;

    // 库
    @Value("${spring.datasource.name}")
    String bName;

    @Bean(name = "dbs1")
    public DataSource dbs1() {
        return DataSourceBuilder.create()
                .url(url1)
                .type(SQLiteDataSource.class)
                .build();
    }

    @Bean(name = "dbs2")
    public DataSource dbs2() {
        return DataSourceBuilder.create()
                .url(url2)
                .type(SQLiteDataSource.class)
                .build();
    }

    // 定义动态数据源
    @Bean(name = "dataSource")
    public DataSource dynamicDataSource(
            @Qualifier("dbs1") DataSource dbs1,
            @Qualifier("dbs2") DataSource dbs2) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>() {{
            put(name1, dbs1);
            put(name2, dbs2);
        }};

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dbs1);
        return dynamicDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dbs) throws Exception {
        factory.setDataSource(dbs);
        return factory.getObject();
    }
}

// 路由规则动态数据源
class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}