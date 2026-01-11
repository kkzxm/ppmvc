package com.kkzxm.ppmvc.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Component
public class ProcessorStore implements ApplicationContextAware {

    private final HashMap
            <Class<? extends BaseEntity>, List<Processor<?>>>
            inMap = new HashMap<>();

    /**
     * 排序
     */
    private void sort(List<Processor<? extends BaseEntity>> processorList) {
        processorList.sort(Comparator.comparingInt(Processor::getSortValue));
    }

    /**
     * 处理器放入仓库
     */
    private void addProcessor(Processor<? extends BaseEntity> processor){
        List<Processor<?>> list = inMap.get(processor.getEntityClass());
        if (list == null) {
            list = new ArrayList<>();
        }
        list.remove(processor);
        list.add(processor);
        inMap.put(processor.getEntityClass(), list);
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] processorNames = applicationContext.getBeanNamesForType(Processor.class);
        // 先把所有的处理器装入仓库
        for (String processorName : processorNames) {
            Processor<?> processor = (Processor<?>) applicationContext.getBean(processorName);
            addProcessor(processor);
        }
        // 再取出所有的实体class
        for (Class<? extends BaseEntity> entityClass : inMap.keySet()) {
            // 分好类的处理器
            List<Processor<? extends BaseEntity>> processorList = inMap.get(entityClass);
            sort(processorList);
            for (int i = 0; i < processorList.size()-1; i++) {
                Processor<? extends BaseEntity> thisP = processorList.get(i);
                Processor<? extends BaseEntity> nextP = processorList.get(i+1);
                thisP.next(nextP);
            }
        }
    }
}
