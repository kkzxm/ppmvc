package com.learn.manager.vue.admin.core.controller;

import com.kkzxm.ppmvc.assign.chian.basic.RegularChain;
import com.kkzxm.ppmvc.controller.AController;
import com.learn.manager.vue.admin.entity.Router;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/29 02:58
 */
@RestController()
@RequestMapping("/router")
public class RouterController extends AController<Router> {

    public RouterController( RegularChain<Router> reg) {
        super(Router.class, reg);
    }
}
