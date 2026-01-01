package com.kkzxm.ppmvc.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.override.MybatisMapperProxy;
import com.baomidou.mybatisplus.core.toolkit.MybatisUtils;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;

import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.assign.processor.AProcessor;

import com.kkzxm.ppmvc.entity.BaseEntity;

public abstract class AService<T extends BaseEntity> extends AProcessor<T> implements IService<T> {

    public AService(Class<T> entytyClass, PpmvcContext ppmvcContext) {
        super(entytyClass, ppmvcContext,70);
    }

    protected final Log log = LogFactory.getLog(this.getClass());

    private volatile SqlSessionFactory sqlSessionFactory;


    protected SqlSessionFactory getSqlSessionFactory() {
        if (this.sqlSessionFactory == null) {
            MybatisMapperProxy<?> mybatisMapperProxy = MybatisUtils.getMybatisMapperProxy(this.getBaseMapper());
            this.sqlSessionFactory = MybatisUtils.getSqlSessionFactory(mybatisMapperProxy);
        }

        return this.sqlSessionFactory;
    }

    public boolean saveOrUpdate(T entity) {
        return this.getBaseMapper().insertOrUpdate(entity);
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return this.getBaseMapper().selectOne(queryWrapper, throwEx);
    }

    public Optional<T> getOneOpt(Wrapper<T> queryWrapper, boolean throwEx) {
        return Optional.ofNullable(this.getBaseMapper().selectOne(queryWrapper, throwEx));
    }

    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return SqlHelper.getObject(this.log, this.getBaseMapper().selectMaps(queryWrapper));
    }

    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return SqlHelper.getObject(this.log, this.listObjs(queryWrapper, mapper));
    }

    protected <E> boolean executeBatch(Collection<E> list, int batchSize, BiConsumer<SqlSession, E> consumer) {
        return SqlHelper.executeBatch(this.getSqlSessionFactory(), this.log, list, batchSize, consumer);
    }

    protected <E> boolean executeBatch(Collection<E> list, BiConsumer<SqlSession, E> consumer) {
        return this.executeBatch(list, 1000, consumer);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    public boolean removeById(Serializable id, boolean useFill) {
        return SqlHelper.retBool(this.getBaseMapper().deleteById(id, useFill));
    }

    public boolean removeBatchByIds(Collection<?> list, int batchSize) {
        return SqlHelper.retBool(this.getBaseMapper().deleteByIds(list));
    }

    public boolean removeBatchByIds(Collection<?> list, int batchSize, boolean useFill) {
        return SqlHelper.retBool(this.getBaseMapper().deleteByIds(list, useFill));
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return null;
    }

    /**
     * mp框架链式查询用到这个方法,
     */
    @Override
    public Class<T> getEntityClass() {
        return null;
    }
    
}

