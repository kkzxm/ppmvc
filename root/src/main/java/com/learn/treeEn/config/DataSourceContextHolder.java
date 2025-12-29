package com.learn.treeEn.config;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/29 01:21
 */
public class DataSourceContextHolder {
    // 双数据源加载到线程
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDataSource(String dataSourceName){
        contextHolder.set(dataSourceName);
    }

    public static String getDataSource(){
        return contextHolder.get();
    }

    public static void clearDataSource(){
        contextHolder.remove();
    }
}
