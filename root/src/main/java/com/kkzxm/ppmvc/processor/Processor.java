package com.kkzxm.ppmvc.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

/**
 * 父处理器接口
 *
 * @param <T>
 */
public interface Processor<T extends BaseEntity>{

    void next(Processor<? extends BaseEntity> nextP);

    Processor<T> next();

    /**
     * 获取(设置)当前处理器所处理的实体类（泛型替代）
     * @return 实体class
     */
    Class<T> getEntityClass();

    /**
     * 获取当前处理器的排序值
     * （越大越往后）
     * @return 排序值
     */
    int getSortValue();
}