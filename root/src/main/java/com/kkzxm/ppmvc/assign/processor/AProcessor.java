package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AProcessor<T extends BaseEntity> implements Processor<T> {

    protected Processor<T> next;
    protected final Class<T> entytyClass;
    private final int sortValue;

    public AProcessor(Class<T> entytyClass, int sortValue) {
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
    }

    public AProcessor(Class<T> entytyClass,int sortValue, Processor<T> next) {
        this.entytyClass = entytyClass;
        this.sortValue = sortValue;
        this.next(next);
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
}
