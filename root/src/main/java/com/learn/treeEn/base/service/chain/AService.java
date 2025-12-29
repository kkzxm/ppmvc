package com.learn.treeEn.base.service.chain;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public abstract class AService<T> implements IService<T> {
    BaseMapper<T> baseMapper;

    AService(BaseMapper<T> baseMapper) {
        this.baseMapper = baseMapper;
    }

    @Override
    public int add(T t) {
        return baseMapper.insert(t);
    }
}
