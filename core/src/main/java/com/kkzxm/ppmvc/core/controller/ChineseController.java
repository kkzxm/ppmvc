package com.kkzxm.ppmvc.core.controller;

import com.kkzxm.ppmvc.controller.AController;
import com.kkzxm.ppmvc.entity.Chinese;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@RestController
@RequestMapping("/chinese")
public class ChineseController extends AController<Chinese> {

    public ChineseController() {
        super(Chinese.class);
    }
}
