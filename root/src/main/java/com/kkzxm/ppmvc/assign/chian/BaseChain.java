package com.kkzxm.ppmvc.assign.chian;

import com.kkzxm.ppmvc.assign.processor.AProcessor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.context.ApplicationContext;

/**
 * 链
 * 装配工厂
 *
 * 链式调用中，一种类型的链对应一个子类
 */
public abstract class BaseChain<T extends BaseEntity> {
  private final ApplicationContext context;

  public BaseChain(ApplicationContext context) {
    this.context = context;
  }

  public ApplicationContext getContext() {
    return context;
  }

  /**
   * 得到装好的链
   *
   * @return
   */
  public abstract AProcessor<T> getChain(Class<? extends BaseEntity> clazz);

  /**
   * 得到某个节点
   *
   * @return
   */
  protected AProcessor<T> getBean(Class<AProcessor<T>> clazz) {
   return context.getBean(clazz);
  }

  protected AProcessor<T> getBean(String name) {
   return (AProcessor<T>) context.getBean(name);
  }


}
