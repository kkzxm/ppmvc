package com.kkzxm.ppmvc.assign.processor;

import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;
import com.kkzxm.ppmvc.mapper.PMapper;
import org.springframework.boot.CommandLineRunner;

/**
 * 父处理器接口
 *
 * @param <T>
 */
public interface Processor<T extends BaseEntity> extends CommandLineRunner {
    PpmvcContext ppmvcContext = PpmvcContext.ppmvcContext();

    /**
     * 设置下一个处理器
     */
    void next(Processor<? extends BaseEntity> processor);

    /**
     * 处理器存到仓库中
     * 注册当前处理器到上下文仓库中
     */
    @Override
    default  void run(String... args) {
        if (this instanceof PMapper) {

            return;
        }
        ppmvcContext.registerProcessor(getEntityClass(), this);
    }



    /**
     * 获取(设置)当前处理器所处理的实体类（泛型替代）
     * @return 实体class
     */
    Class<T> getEntityClass();

    /**
     * 获取当前处理器的排序值
     * （越大越往后）
     * @return 排序值
     */
    int getSortValue();
}