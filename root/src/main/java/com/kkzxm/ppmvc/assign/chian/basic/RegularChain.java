package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.stereotype.Component;

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
            for (Processor<BaseEntity> processor : processorList) {
                System.out.println("装配处理器：" + processor.getClass().getSimpleName());
            }
            System.out.println();
        }

    }
}
