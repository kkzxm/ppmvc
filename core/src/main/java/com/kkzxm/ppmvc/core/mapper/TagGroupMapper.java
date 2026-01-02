package com.kkzxm.ppmvc.core.mapper;

import com.kkzxm.ppmvc.entity.Chinese;
import com.kkzxm.ppmvc.entity.TagGroup;
import com.kkzxm.ppmvc.mapper.PMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Mapper
public interface TagGroupMapper extends PMapper<TagGroup> {
    @Override
    default Class<TagGroup> getEntityClass() {
        return TagGroup.class;
    }
}
