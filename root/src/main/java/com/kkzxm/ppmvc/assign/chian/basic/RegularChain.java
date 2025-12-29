package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.processor.AProcessor;
import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 普通链式调用
 * controller → service → mapper
 */
@Component
public class RegularChain<T extends BaseEntity> extends BaseChain<T> {

    public RegularChain(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Override
    public AProcessor<T> getChain(Class<? extends BaseEntity> entityClass) {
        String simpleName = entityClass.getSimpleName();
        simpleName = simpleName.substring(0, 1).toLowerCase() + simpleName.substring(1);
        // service
        return super.getBean(simpleName + "Service")
                // mapper
                .setNext(super.getBean(simpleName + "Mapper"));
    }
}
