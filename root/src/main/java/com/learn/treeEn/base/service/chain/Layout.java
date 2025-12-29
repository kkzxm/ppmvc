package com.learn.treeEn.base.service.chain;

/**
 * 布局
 */
public class Layout {
    /**
     * controller层接收参数,来到service层
     * service层,
     * 整体安全层 --> 分配  --> 单独业务安全层 --> redis 缓存区 --> 数据库区
     * 
     * 原先的service 层只针对数据库,
     * 现加上 分配,安全,缓存
     * 缓存需要等待数据库层的回应
     */
}
