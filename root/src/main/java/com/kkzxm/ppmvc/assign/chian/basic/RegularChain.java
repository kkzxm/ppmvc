package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

/**
 * 普通链式调用
 * controller → service → mapper
 */
@Component
public class RegularChain<T extends BaseEntity> extends BaseChain<T> {

    RegularChain(PpmvcContext ppmvcContext) {
        super(ppmvcContext);
    }

    @Override
    @PostConstruct
    public <T extends BaseEntity, P extends Processor<T>> void processorChain() {
        Set<Class<BaseEntity>> enClassSet = getPpmvcContext().getEntityClassIterable();
        for (Class<BaseEntity> entityClass : enClassSet) {
            List<Processor<BaseEntity>> processorList = getPpmvcContext().getChainListByEntityClass(entityClass);
            // 装配
            sort(processorList);
            for (int i = 0; i < processorList.size() - 1; i++) {
                processorList.get(i).next(processorList.get(i + 1));
            }
        }
    }

    /**
     * 通过sort排序
     */
    public void sort(List<Processor<BaseEntity>> processorList) {
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
