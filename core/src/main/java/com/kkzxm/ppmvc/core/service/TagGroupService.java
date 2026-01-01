package com.kkzxm.ppmvc.core.service;

import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.TagGroup;
import com.kkzxm.ppmvc.service.AService;

import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Service
public class TagGroupService extends AService<TagGroup> {

    public TagGroupService( PpmvcContext ppmvcContext) {
        super(TagGroup.class, ppmvcContext);
    }
}
