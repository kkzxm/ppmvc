package com.learn.treeEn.core.service.allocation;

import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.base.service.allocation.ABaseAllocation;
import com.learn.treeEn.entity.TagGroup;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/24 01:53
 */
public class TagGroupAllocation extends ABaseAllocation<TagGroup> {
    public TagGroupAllocation(ABaseDoIt<TagGroup> baService) {
        super(baService, TagGroup.class);
    }
}
