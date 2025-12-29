package com.learn.treeEn.base.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.treeEn.base.controller.result.Result;
import com.learn.treeEn.base.service.DoIt;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Math.*;

@AllArgsConstructor
public abstract class ABaseController<T> implements BaseController<T> {
    private final DoIt<T> doIt;
    private final String info;

    // region doIt and info
    protected DoIt<T> getDoIt() {
        return doIt;
    }

    protected String getInfo() {
        return info;
    }
    // endregion

    // region 增

    /**
     * 重写方法,需要再把@RequestBody加上
     */
    @Override
    public Result add(HttpServletRequest request, @RequestBody T entity) {
        boolean save = doIt.save(entity);
        return Result.result(save).setData(entity);
    }
    // endregion

    // region 删
    @Override
    public Result delById(HttpServletRequest request, @RequestBody T entity) {
        return Result.result(doIt.removeById(entity));
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
        Page<T> page = doIt.page(new Page<>(thisPage, max(0, pageSize)));
        return Result.success(page);
    }

    @Override
    public Result toInsertPage() {
        return null;
    }

    @Override
    public Result list() {
        return Result.success(doIt.list());
    }
    // endregion
}
