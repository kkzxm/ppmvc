package com.kkzxm.ppmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.assign.processor.AProcessor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.service.AService;
import com.kkzxm.ppmvc.controller.result.*;;


public abstract class AController<T extends BaseEntity> extends AProcessor<T> implements IController<T> {
    AService<T> next;
    public AController(Class<T> entytyClass) {
        super(entytyClass,0);
    }
  
    // region 增

    /**
     * 重写方法,需要再把@RequestBody加上
     */
    @Override
    public Result add(HttpServletRequest request, @RequestBody T entity) {
        boolean save = next.save(entity);
        return Result.result(save).setData(entity);
    }
    // endregion

    // region 删
    @Override
    public Result delById(HttpServletRequest request, @RequestBody T entity) {
        return Result.result(next.removeById(entity));
    }
    // endregion

    // region 改

    @Override
    public Result update(HttpServletRequest request, T entity) {
        return null;
    }

    @Override
    public Result updateFindById(HttpServletRequest request, T entity) {
        return null;
    }
    // endregion

    // region 查
    @Override
    public Result getPage(Integer thisPage, Integer pageSize, String filter) {
        Page<T> page = next.page(new Page<>(thisPage, Math.max(0, pageSize)));
        return Result.success(page);
    }

    @Override
    public Result toInsertPage() {
        return null;
    }

    @Override
    public Result list() {
        return Result.success(next.list());
    }
    // endregion

}