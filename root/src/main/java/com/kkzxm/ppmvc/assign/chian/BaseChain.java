package com.kkzxm.ppmvc.assign.chian;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 链
 * 装配工厂
 *
 */
@Getter
@Setter
public abstract class BaseChain<T extends BaseEntity> {
  
  private PpmvcContext ppmvcContext;
  private Class<T> entityClass;
  private static final Set<Class<?>> entityClassSet = new HashSet<>();



  public BaseChain(PpmvcContext ppmvcContext) {
      this.ppmvcContext = ppmvcContext;
      entityClassSet.add(entityClass);
  }

  protected Iterator<Class<?>> getEntityClassIterator() {
      return entityClassSet.iterator();
  }

  /**
   * 把处理器加入到上下文中,并以实体类进行分类
   */
  public void addProcessor(Processor<T> processor,Class<T> entityClass){ 
      ppmvcContext.registerProcessor(entityClass, processor);
  }

  /**
   * 装配
   * 从ppmvcContext中获取
   * 实体类对应的链式调用
   * 并装配完成
   *
   * 最后调用
   */
  public abstract void processorChain();
}
