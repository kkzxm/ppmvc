package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.beans.factory.SmartInitializingSingleton;


/**
 * 父处理器接口
 *
 * @param <T>
 */
public interface Processor<T extends BaseEntity>  {
    /**
     * 设置下一个处理器
     *
     * @return
     */
    Processor<T> next(Processor<T> processor);

    int getSortValue();
}