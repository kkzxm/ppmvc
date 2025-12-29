package com.kkzxm.ppmvc.service;

import com.kkzxm.ppmvc.assign.processor.AProcessor;
import com.kkzxm.ppmvc.entity.BaseEntity;

import java.util.Collections;
import java.util.List;


public abstract class AService<T extends BaseEntity> extends AProcessor<T> implements IService<T> {
    @Override
    public Integer addOne(T t) {
        return 0;
    }

    @Override
    public Integer addList(List<T> list) {
        return 0;
    }

    @Override
    public Integer deleteOne(T t) {
        return 0;
    }

    @Override
    public Integer deleteList(List<T> list) {
        return 0;
    }

    @Override
    public Integer updateOne(T oldT, T newT) {
        return 0;
    }

    @Override
    public T findOne(T t) {
        return null;
    }

    @Override
    public List<T> findList(List<T> list) {
        return Collections.emptyList();
    }
}

