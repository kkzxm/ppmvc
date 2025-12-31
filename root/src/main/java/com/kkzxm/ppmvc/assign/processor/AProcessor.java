package com.kkzxm.ppmvc.assign.processor;

import javax.annotation.PostConstruct;

import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.entity.BaseEntity;

import lombok.Getter;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    BaseChain<T> chain;
    private Processor<T> next;
    protected final Class<T> entytyClass;
    @Getter
    private final int sortValue;

    public AProcessor(Class<T> entytyClass, BaseChain<T> chain, int sortValue) {
        this.chain = chain;
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
        chain.setEntityClass(entytyClass);
        chain.addProcessor(this, entytyClass);
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
