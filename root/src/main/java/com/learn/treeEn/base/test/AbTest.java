package com.learn.treeEn.base.test;

import com.learn.treeEn.base.service.DoIt;

public abstract class AbTest<T> implements ITest<T> {
    protected T t;
    protected DoIt<T> service;
}
