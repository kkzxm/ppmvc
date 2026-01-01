package com.kkzxm.ppmvc.assign.processor;

import javax.annotation.PostConstruct;

import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;

import lombok.Getter;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    private Processor<T> next;
    protected final Class<T> entytyClass;
    @Getter
    private final int sortValue;

    public AProcessor(Class<T> entytyClass,PpmvcContext ppmvcContext, int sortValue) {
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
        ppmvcContext.registerProcessor(entytyClass,this);
    }

 
    /**
     * 从仓库里获取下一个处理器
     */
    @Override
    public Processor<T> next(Processor<T> processor) {
        this.next =  processor;
        return next;
    }
}
