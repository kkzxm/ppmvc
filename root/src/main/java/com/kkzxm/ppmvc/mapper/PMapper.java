package com.kkzxm.ppmvc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;

public interface PMapper<T extends BaseEntity> extends Processor<T>, BaseMapper<T> {

    /**
     * 获取当前处理器的排序值
     * Mapper默认值为最大值
     * 因为Mapper是最后一个处理器
     * @return
     */
    @Override
    default int getSortValue() {
        return Integer.MAX_VALUE;
    }
}
