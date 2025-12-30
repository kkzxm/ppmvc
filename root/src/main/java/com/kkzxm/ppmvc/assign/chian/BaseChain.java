package com.kkzxm.ppmvc.assign.chian;

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
  
  private PpmvcContext<T> ppmvcContext;
  private Class<T> entityClass;

  public BaseChain(PpmvcContext<T> ppmvcContext) {
      this.ppmvcContext = ppmvcContext;
  }

    /**
   * 得到装好的链
   *
   * @return
   */
  public abstract Processor<T> getChain(Class<T> clazz);



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
