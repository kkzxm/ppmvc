package com.kkzxm.ppmvc.core.mapper;

import com.kkzxm.ppmvc.entity.Chinese;
import com.kkzxm.ppmvc.mapper.PMapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChineseMapper extends PMapper<Chinese> {
    @Override
    default Class<Chinese> getEntityClass() {
        return Chinese.class;
    }
}
