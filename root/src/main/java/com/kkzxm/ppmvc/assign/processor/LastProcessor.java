package com.kkzxm.ppmvc.assign.processor;

import com.baomidou.mybatisplus.core.override.MybatisMapperProxy;
import com.baomidou.mybatisplus.core.toolkit.MybatisUtils;
import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.mapper.PMapper;
import org.springframework.stereotype.Component;

/**
 * 最后一个处理器类,
 * 它的下一层就是Mapper
 */
@Component
public class LastProcessor<T extends BaseEntity> implements Processor<T> {


    public LastProcessor(PMapper<T> mapper) {
        MybatisMapperProxy<?> proxy = MybatisUtils.getMybatisMapperProxy(mapper);
        proxy.getSqlSession();
    }

    @Override
    public void next(Processor processor) {

    }

    @Override
    public Class getEntityClass() {
        return null;
    }

    @Override
    public int getSortValue() {
        return 0;
    }
}
