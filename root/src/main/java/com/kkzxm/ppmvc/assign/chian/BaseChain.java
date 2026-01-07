package com.kkzxm.ppmvc.assign.chian;

import lombok.Getter;
import org.springframework.boot.CommandLineRunner;

/**
 * 链
 * 装配工厂
 *
 */
@Getter
public abstract class BaseChain implements CommandLineRunner {

    private final PpmvcContext ppmvcContext = PpmvcContext.ppmvcContext();

  /**
   * 装配
   * 从ppmvcContext中获取
   * 实体类对应的链式调用
   * 并装配完成
   *
   * 最后调用
   */
  public abstract void processorChain();

    @Override
    public void run(String... args) throws Exception {
        processorChain();
    }
}
