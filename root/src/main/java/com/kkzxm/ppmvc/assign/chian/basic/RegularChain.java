package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.annotation.PpmvcSort;
import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.stereotype.Component;

/**
 * 普通链式调用
 * controller → service → mapper
 */
@Component
public class RegularChain<T extends BaseEntity> extends BaseChain<T> {


	RegularChain(PpmvcContext<T> ppmvcContext) {
        super(ppmvcContext);
    }

    /**
     * 获取链式调用
     */
    @Override
    public Processor<T> getChain(Class<T> clazz) {
        return super.getPpmvcContext().getChainsByEntityClass(clazz).get(0);
    }

	@Override
	public Processor<T> getNextProcessor(Processor<T> processor, Class<T> entytyClass) {
        System.out.println(
            processor.getClass().getSimpleName() + " ---> " +
            processor.getClass().getAnnotation(PpmvcSort.class)
            .value()
            + " ---> " + entytyClass.getSimpleName()
        );
        return null;
	}
}
