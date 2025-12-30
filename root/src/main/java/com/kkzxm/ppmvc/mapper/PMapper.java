package com.kkzxm.ppmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkzxm.ppmvc.annotation.PpmvcSort;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;

@PpmvcSort(value = 0)
public interface PMapper<T extends BaseEntity> extends Processor<T> , BaseMapper<T>{

}
