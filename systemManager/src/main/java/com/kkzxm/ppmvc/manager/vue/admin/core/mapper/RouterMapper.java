package com.kkzxm.ppmvc.manager.vue.admin.core.mapper;

import com.kkzxm.ppmvc.manager.vue.admin.entity.Router;
import com.kkzxm.ppmvc.mapper.PMapper;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/29 02:49
 */
public interface RouterMapper extends PMapper<Router> {
    @Override
    default Class<Router> getEntityClass() {
        return Router.class;
    }
}
