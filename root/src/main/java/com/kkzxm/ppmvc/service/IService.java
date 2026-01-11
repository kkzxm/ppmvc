package com.kkzxm.ppmvc.service;


import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.processor.CRUD;

public interface IService<T extends BaseEntity> extends CRUD<T> {
}
