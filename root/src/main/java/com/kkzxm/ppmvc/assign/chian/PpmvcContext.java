package com.kkzxm.ppmvc.assign.chian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;

/**
 * 
 * 装处理器的仓库
 * 
 */
@Component
public class PpmvcContext<T extends BaseEntity> {
    /**
     * 存储各个实体类对应的处理器链
     */
    private final Map<Class<T>, List<Processor<T>>> processorMap = new HashMap<>();

    // #region get
    /**
     * 根据实体类获取对应的所有处理器链
     */
    public List<Processor<T>> getChainsByEntityClass(Class<T> entityClass) {
         List<Processor<T>> processors = processorMap.get(entityClass);
         return processors != null ? processors : new ArrayList<>();
    }

    /**
     * * 根据实体类以及下标获取单个处理器
     */
    public Processor<T> getProcessorByEntityClassAndIndex(Class<T> entityClass, int index) {
        List<Processor<T>> processors = processorMap.get(entityClass);
        if (processors != null && index >= 0 && index < processors.size()) {
            return processors.get(index);
        }
        return null;
    }
    // #endregion

    // #region register注册
    /**
     * 注册处理器链
     */
    public void registerChainList(Class<T> entityClass, List<Processor<T>> processors) {
        processorMap.put(entityClass, processors);
    }
    /**
     * 注册单个处理器到对应实体类的处理器链中
     */
    public void registerProcessor(Class<T> entityClass, Processor<T> processor) {
        List<Processor<T>> processors = getChainsByEntityClass(entityClass);
        processors.add(processor);
        processorMap.put(entityClass, processors);
    }
    // #endregion
}