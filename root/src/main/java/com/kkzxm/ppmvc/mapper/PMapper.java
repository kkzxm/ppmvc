package com.kkzxm.ppmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.processor.Processor;

public interface PMapper<T extends BaseEntity> extends BaseMapper<T> , Processor<T> {
    @Override
    default int getSortValue(){
        return Integer.MAX_VALUE;
    }
}
