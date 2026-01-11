package com.kkzxm.ppmvc.service;

import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.mapper.PMapper;
import com.kkzxm.ppmvc.processor.AProcessor;

import java.util.List;

public  class AService<T extends BaseEntity> extends AProcessor<T> implements IService<T> {

    public AService(Class<T> entytyClass) {
        super(entytyClass,5);
    }

    @Override
    public PMapper<T> next() {
        return (PMapper<T>) super.next();
    }

    @Override
    public List<T> list() {
        return next().selectList(null);
    }
}

