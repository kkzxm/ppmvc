package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 普通链式调用
 * controller → service → mapper
 */
@Component
public class RegularChain extends BaseChain {


    /**
     * 从仓库取（装配到处理器中）
     */
    @Override
    public void processorChain() {
        PpmvcContext ppmvcContext = getPpmvcContext();
        Set<Class<? extends BaseEntity>> keysSet = ppmvcContext.getProcessorKeysSet();

        for (Class<? extends BaseEntity> entityClass : keysSet) {
            List<Processor<? extends BaseEntity>> processorList = ppmvcContext.getProcessorSetByEntityClass(entityClass);
            sort(processorList);
            for (int i = 0; i < processorList.size()-1; i++) {
                processorList.get(i).next(processorList.get(i+1));
            }
            System.out.println(processorList.size());
        }
    }

    /**
     * 通过sort排序
     */
    public void sort(List<Processor<? extends BaseEntity>> processorList) {
        processorList.sort((o1, o2) -> {
            if (o1.getSortValue() > o2.getSortValue()) {
                return 1;
            } else if (o1.getSortValue() < o2.getSortValue()) {
                return -1;
            }
            return 0;
        });
    }

}