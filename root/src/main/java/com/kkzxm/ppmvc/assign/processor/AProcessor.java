package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.annotation.PpmvcSort;
import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    BaseChain<T> chain;
    private Processor<T> next;
    protected final Class<T> entytyClass;

    public AProcessor(Class<T> entytyClass, BaseChain<T> chain) {
        this.chain = chain;
        this.entytyClass = entytyClass;
        chain.setEntityClass(entytyClass);
        this.next = chain.getNextProcessor(this, entytyClass);
        chain.addProcessor(this,entytyClass);
    }

    /**
     * 从仓库里获取下一个处理器
     */
    public Processor<T> next() {
        if (next == null) {
            next = chain.getNextProcessor(this, entytyClass);
        }
        return next;
    }
}
