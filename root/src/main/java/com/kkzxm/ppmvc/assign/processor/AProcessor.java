package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    private Processor<T> next;
    protected final Class<T> entytyClass;
    private int sortValue;

    public AProcessor(Class<T> entytyClass, int sortValue) {
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
        registerThis();
    }

    @Override
    public Class<T> getEntityClass() {
        return entytyClass;
    }

    @Override
    public int getSortValue() {
        return sortValue;
    }

    /**
     * 从仓库里获取下一个处理器
     */
    @Override
    public Processor<T> next(Processor<T> processor) {
        this.next = processor;
        return next;
    }
}
