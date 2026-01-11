package com.kkzxm.ppmvc.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {
    private Processor<T> next;
    protected final Class<T> entytyClass;
    private final int sortValue;

    public AProcessor(Class<T> entytyClass, int sortValue) {
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
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
    public void next(Processor<? extends BaseEntity> processor) {
        this.next = (Processor<T>) processor;
    }

    @Override
    public Processor<T> next() {
        return next;
    }
}
