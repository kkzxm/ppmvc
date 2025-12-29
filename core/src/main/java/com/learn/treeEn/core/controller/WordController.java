package com.learn.treeEn.core.controller;

import com.learn.treeEn.base.service.allocation.ABaseAllocation;
import com.learn.treeEn.base.controller.ABaseController;
import com.learn.treeEn.entity.Word;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/word")
public class WordController extends ABaseController<Word> {
    public WordController(ABaseAllocation<Word> aBaService) {
        super(aBaService, "单词");
    }
}
