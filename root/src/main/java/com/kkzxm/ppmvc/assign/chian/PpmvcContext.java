package com.kkzxm.ppmvc.assign.chian;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 
 * 装处理器的仓库
 * 
 */
public class PpmvcContext {
    private final  HashMap
            <Class<? extends BaseEntity>, List<Processor<?>>>
            inContextMap = new HashMap<>();

    // region 单例
    private static final PpmvcContext INSTANCE = new PpmvcContext();
    @Bean
    public static PpmvcContext ppmvcContext() {
        return INSTANCE;
    }
    private PpmvcContext() {}
    // endregion

    // region 内部仓库相关

    /**
     * 根据实体Class获取处理器List,
     * 存在则直接返回,
     * 不存在则,重新生成一个,加入到Map中,再返回
     */
    private <T extends BaseEntity> List<Processor<?>> getProcessorListByEntityClass(Class<T> entityClass) {
        return inContextMap.computeIfAbsent(entityClass, k -> new ArrayList<>());
    }
    // endregion

    //region 处理器相关操作(注册与获取)
    /**
     * 注册处理器
     * @param entityClass 实体class
     * @param tProcessor 需要注册的处理器
     */
    public <T extends BaseEntity> void registerProcessor(Class<T> entityClass, Processor<T> tProcessor) {
        List<Processor<? extends BaseEntity>> list = getProcessorListByEntityClass(entityClass);
        list.add(tProcessor);
    }
    /**
     * 根据所有的实体class
     */
    public Set<Class<? extends BaseEntity>> getProcessorKeysSet() {
        return inContextMap.keySet();
    }

    /**
     * 根据实体Class获取处理器链
     *
     * @return 分好类的处理器链
     */
    public <T extends BaseEntity> List<Processor<? extends BaseEntity>> getProcessorSetByEntityClass(Class<T> entityClass) {
        return inContextMap.get(entityClass);
    }
    //endregion
}