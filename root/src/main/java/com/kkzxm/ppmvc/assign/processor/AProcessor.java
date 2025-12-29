package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    private Processor<T> next;

    public AProcessor<T> setNext(Processor<T> next){
        this.next = next;
        return this;
    }

    public Processor<T> getNext() {
        return next;
    }
}
