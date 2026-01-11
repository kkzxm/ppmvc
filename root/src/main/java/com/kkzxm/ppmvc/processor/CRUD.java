package com.kkzxm.ppmvc.processor;

import com.kkzxm.ppmvc.entity.BaseEntity;

import java.util.List;

/**
 * 现在是controller需要next
 * processor总父类处理器里面有next，
 * 但我又不想把当前类加到processor里面，
 *
 * @param <T>
 */
public interface CRUD<T extends BaseEntity> {
    // region 增
    // endregion

    // region 增加或修改
    // endregion

    // region 删除
    // endregion

    // region 修改
    // endregion

    // region 查询
    List<T> list();
    // endregion
}
