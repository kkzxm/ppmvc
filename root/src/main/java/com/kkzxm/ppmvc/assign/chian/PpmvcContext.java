package com.kkzxm.ppmvc.assign.chian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
public class PpmvcContext {
    private Map inMap;

    private static final PpmvcContext INSTANCE = new PpmvcContext();

    public static PpmvcContext getInstance() {
        return INSTANCE;
    }

    // #region 内部方法
    private PpmvcContext() {
        this.inMap = new HashMap<Class<?>, InContext<?>>();
    }

    /**
     * 根据实体类获取对应的处理器仓库
     * 如果没有则创建一个新的仓库
     * 存在则正常返回
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

    public <T extends BaseEntity> Map<Class<T>, InContext<T>> getInMap() {
        return inMap;
    }
    // #endregion

    // #region get
    /**
     * 根据实体类获取对应的
     * 所有处理器List
     */
    public <T extends BaseEntity> List<Processor<T>> getChainListByEntityClass(Class<T> entityClass) {
        InContext<T> inContext = getInContext(entityClass);
        return inContext.getProcessors();
    }
    // #endregion

    // #region register注册
    /**
     * 注册单个处理器到对应实体类的处理器链中
     */
    public <T extends BaseEntity> void registerProcessor(Class<T> entityClass, Processor<T> processor) {
        InContext<T> inContext = getInContext(entityClass);
        inContext.addProcessor(processor);
    }
    // #endregion

    // #region 给装配链使用的方法
    /**
     * 得到实体类链
     */
    public <T extends BaseEntity> Set<Class<BaseEntity>> getEntityClassIterable() {
        return getInMap().keySet();
    }
    // #endregion
}

// #region 内部类
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
// #endregion