package com.learn.treeEn.base.service.chain;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 被继承类
 */
public class ExService<T> extends AService<T> {

    ExService(BaseMapper<T> baseMapper) {
        super(baseMapper);
    }

    @Override
    public int add(T t) {
        return 0;
    }

}
