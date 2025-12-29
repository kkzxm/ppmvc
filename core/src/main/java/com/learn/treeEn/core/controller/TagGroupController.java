package com.learn.treeEn.core.controller;

import com.learn.treeEn.base.controller.ABaseController;
import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.entity.TagGroup;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@RequestMapping("/tagGroup")
public class TagGroupController extends ABaseController<TagGroup> {

    public TagGroupController(ABaseDoIt<TagGroup> aBaService) {
        super(aBaService, "标签组");
    }


}
