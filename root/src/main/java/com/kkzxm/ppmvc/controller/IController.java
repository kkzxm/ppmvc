package com.kkzxm.ppmvc.controller;

import com.kkzxm.ppmvc.controller.result.Result;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

public interface IController<T extends BaseEntity> {
     
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
