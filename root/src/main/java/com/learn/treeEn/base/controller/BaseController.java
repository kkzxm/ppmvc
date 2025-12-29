package com.learn.treeEn.base.controller;

import com.learn.treeEn.base.controller.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-12 13:39
 */
public interface BaseController<T> {
    
    @PostMapping(value = "/add")
    Result add(HttpServletRequest request,T entity);
    
    @PostMapping(value = "/delById")
    Result delById(HttpServletRequest request,T entity);
    
    @RequestMapping("/updateFindById")
    Result updateFindById(HttpServletRequest request,T entity);
    
    @RequestMapping(value = "/update")
    Result update(HttpServletRequest request,T entity);
    
    @RequestMapping("/toInsertPage")
    Result toInsertPage();
    
    @RequestMapping("/list")
    Result list();
    
    @GetMapping("/getPage")
    Result getPage(Integer thisPage, Integer pageSize, String filter);
}
