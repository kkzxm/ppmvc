package com.kkzxm.ppmvc.core.controller;


import com.kkzxm.ppmvc.assign.chian.basic.RegularChain;
import com.kkzxm.ppmvc.controller.AController;
import com.kkzxm.ppmvc.entity.WordAndTagGroup;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@RequestMapping("/WordAndTag")
public class WordAndTagController extends AController<WordAndTagGroup> {

    public WordAndTagController(RegularChain<WordAndTagGroup> reg) {
        super(WordAndTagGroup.class, reg);
    }

}
