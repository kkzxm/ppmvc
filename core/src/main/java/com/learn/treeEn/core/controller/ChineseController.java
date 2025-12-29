package com.learn.treeEn.core.controller;

import com.learn.treeEn.base.controller.ABaseController;
import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.entity.Chinese;
import org.springframework.stereotype.Controller;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Controller(value = "/chinese")
public class ChineseController extends ABaseController<Chinese> {

    public ChineseController(ABaseDoIt<Chinese> aBaService) {
        super(aBaService, "中文");
    }

}
