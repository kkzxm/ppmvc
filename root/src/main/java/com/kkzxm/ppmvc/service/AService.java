package com.kkzxm.ppmvc.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.processor.AProcessor;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public  class AService<T extends BaseEntity> extends AProcessor<T> implements IService<T> {

    public AService(Class<T> entytyClass) {
        super(entytyClass,5);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        return false;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Optional<T> getOneOpt(Wrapper<T> queryWrapper, boolean throwEx) {
        return Optional.empty();
    }

    @Override
    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public List<T> list() {
        return getBaseMapper().selectList(null);
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return (BaseMapper<T>) next();
    }
}

