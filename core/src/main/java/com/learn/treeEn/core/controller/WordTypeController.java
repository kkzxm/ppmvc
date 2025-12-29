package com.learn.treeEn.core.controller;

import com.learn.treeEn.base.controller.ABaseController;
import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.entity.WordType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@RequestMapping("/WordType")
public class WordTypeController extends ABaseController<WordType> {
    public WordTypeController(ABaseDoIt<WordType> aBaService) {
        super(aBaService, "单词类型");
    }
}
