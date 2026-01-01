package com.learn.manager.vue.admin.core.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.service.AService;
import com.learn.manager.vue.admin.entity.Router;

import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/29 02:51
 */
@Service
public class RouterService extends AService<Router> {

    public RouterService(PpmvcContext ppmvcContext) {
        super(Router.class, ppmvcContext);
    }

    /**
     * 删除前先判断是否有子元素
     * 有,则不删
     */
    @Override
    public boolean removeById(Router entity) {
        QueryWrapper<Router> q = new QueryWrapper<Router>().eq("pid", entity.getId());
        boolean result = super.count(q) == 0 ? super.removeById(entity)
                : false;
        return result;
    }
}
