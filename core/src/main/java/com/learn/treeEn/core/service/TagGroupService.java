package com.learn.treeEn.core.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.entity.TagGroup;
import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Service
public class TagGroupService extends ABaseDoIt<TagGroup> {

    public TagGroupService(BaseMapper<TagGroup> baseMapper) {
        super(baseMapper, TagGroup.class);
    }
}
