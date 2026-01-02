package com.kkzxm.ppmvc.core.mapper;


import com.kkzxm.ppmvc.entity.WordAndType;
import com.kkzxm.ppmvc.mapper.PMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Mapper
public interface WordAndTypeMapper extends PMapper<WordAndType> {
    @Override
    default Class<WordAndType> getEntityClass() {
        return WordAndType.class;
    }
}
