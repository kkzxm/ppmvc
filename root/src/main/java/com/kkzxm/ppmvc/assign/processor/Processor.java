package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

import java.util.List;

/**
 * 父处理器接口
 *
 * @param <T>
 */
public interface Processor<T extends BaseEntity> {
    // region 增

    /**
     * 增加一个
     */
    Integer addOne(T t);

    /**
     * 增加多个
     *
     * @param list
     */
    Integer addList(List<T> list);

// endregion

    // region 删

    /**
     * 删除一个
     *
     * @param t
     * @return
     */
    Integer deleteOne(T t);

    /**
     * 删除多个
     *
     * @param list
     * @return
     */
    Integer deleteList(List<T> list);
    // endregion

    // region 改

    /**
     * 修改一个
     *
     * @return
     */
    Integer updateOne(T oldT, T newT);

    // endregion

    // region 查

    /**
     * 查找一个
     *
     * @param t
     * @return
     */
    T findOne(T t);

    /**
     * 查找多个
     *
     * @param list
     * @return
     */
    List<T> findList(List<T> list);
    // endregion
}