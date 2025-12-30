package com.kkzxm.ppmvc.assign.chian;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.kkzxm.ppmvc.assign.processor.AProcessor;
import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.entity.BaseEntity;

/**
 * 链
 * 装配工厂
 *
 */
public abstract class BaseChain<T extends BaseEntity> {
  
  private PpmvcContext<T> ppmvcContext;

  public BaseChain(PpmvcContext<T> ppmvcContext) {
      this.ppmvcContext = ppmvcContext;
  }

  public PpmvcContext<T> getPpmvcContext(){
      return this.ppmvcContext;
  }

  /**
   * 得到装好的链
   *
   * @return
   */
  public abstract Processor<T> getChain(Class<T> clazz);

  /**
   * 得到某个节点
   *
   * @return
   */
  protected Processor<T> getBean(Class<AProcessor<T>> clazz) {
     return ppmvcContext.getProcessorByEntityClassAndIndex((Class<T>)Base.class, -1);
  }

  @SuppressWarnings("null")
  protected Processor<T> getBean(String name) {
   return null;
  }

  /**
   * 把处理器加入到上下文中,并以实体类进行分类
   */
  public void addProcessor(Processor<T> processor,Class<T> entityClass){ 
      ppmvcContext.registerProcessor(entityClass, processor);
  }

  public abstract Processor<T> getNextProcessor(Processor<T> processor, Class<T> entytyClass);
}
