package com.kkzxm.ppmvc.assign.chian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * 装处理器的仓库
 * 
 */
@Component
public class PpmvcContext {
    private Map<Class<? extends BaseEntity>, InContext<? extends BaseEntity>> inMap = new HashMap<>();

    /**
     * 根据实体类获取对应的处理器仓库
     */
    private <T extends BaseEntity> InContext<T> getInContext(Class<T> entityClass) {
        if (inMap.containsKey(entityClass)) {
            return (InContext<T>) inMap.get(entityClass);
        } else {
            InContext<T> inContext = new InContext<>();
            inMap.put(entityClass, inContext);
            return inContext;
        }
    }
    /**
     * 存储各个实体类对应的处理器链
     */

    // #region get
    /**
     * 根据实体类获取对应的所有处理器链
     */
    public <T extends BaseEntity> List<Processor<T>> getChainListByEntityClass(Class<T> entityClass) {
        InContext<T> inContext = getInContext(entityClass);
        return inContext.getProcessors();
    }

    // /**
    // * * 根据实体类以及下标获取单个处理器
    // */
    // public Processor<? extends BaseEntity>
    // getProcessorByEntityClassAndIndex(Class<? extends BaseEntity> entityClass,
    // int index) {
    // List<Processor<? extends BaseEntity>> processors =
    // processorMap.get(entityClass);
    // if (processors != null && index >= 0 && index < processors.size()) {
    // return processors.get(index);
    // }
    // return null;
    // }
    // // #endregion

    // #region register注册
    /**
     * 注册单个处理器到对应实体类的处理器链中
     */
    public <T extends BaseEntity> void registerProcessor(Class<T> entityClass, Processor<T> processor) {
        InContext<T> inContext = getInContext(entityClass);
        inContext.addProcessor(processor);
    }
    // #endregion
}

/**
 * 底层存储仓库,
 * 每个实体类对应一个处理器链列表
 * 上一层还需要一个大的存储当前仓库对象
 */
@Getter
@Setter
class InContext<T extends BaseEntity> {
    private Class<T> entityClass;
    private final List<Processor<T>> processors = new ArrayList<>();

    void addProcessor(Processor<T> processor) {
        processors.add(processor);
    }
}