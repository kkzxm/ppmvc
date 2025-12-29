package com.learn.manager.vue.admin.core.controller;

import com.learn.manager.vue.admin.entity.Router;
import com.learn.treeEn.base.controller.ABaseController;
import com.learn.treeEn.base.service.DoIt;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/29 02:58
 */
@RestController()
@RequestMapping("/router")
public class RouterController extends ABaseController<Router> {
    public RouterController(DoIt<Router> doIt) {
        super(doIt, "前端路由");
    }
}
