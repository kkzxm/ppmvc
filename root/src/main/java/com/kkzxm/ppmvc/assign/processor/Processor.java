package com.kkzxm.ppmvc.assign.processor;

import javax.annotation.PostConstruct;

import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;

/**
 * 父处理器接口
 *
 * @param <T>
 */
public interface Processor<T extends BaseEntity> {
    PpmvcContext ppmvcContext = PpmvcContext.getInstance();
    /**
     * 设置下一个处理器
     *
     * @return
     */
    Processor<T> next(Processor<T> processor);

    /**
     * 注册当前处理器到上下文仓库中
     * @param ppmvcContext
     * @return
     */
    @PostConstruct
    default void registerThis() {
        ppmvcContext.registerProcessor(getEntityClass(), this);
    }

    /**
     * 获取当前处理器所处理的实体类
     * @return
     */
    Class<T> getEntityClass();

    /**
     * 获取当前处理器的排序值
     * @return
     */
    int getSortValue();
}