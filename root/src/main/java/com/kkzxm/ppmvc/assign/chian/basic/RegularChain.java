package com.kkzxm.ppmvc.assign.chian.basic;

import com.kkzxm.ppmvc.assign.processor.Processor;
import com.kkzxm.ppmvc.annotation.PpmvcSort;
import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.List;

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
        int thisSort = processor.getClass().getAnnotation(PpmvcSort.class).value();
        List<Processor<T>> chainsByEntityClass = getPpmvcContext().getChainsByEntityClass(entytyClass);
        int abs = 10;
        Processor<T> nextProcessor = null;
        for (int i = 0; i < chainsByEntityClass.size(); i++) {
            Processor<T>chain = chainsByEntityClass.get(i);
            int nextSort = chain.getClass().getAnnotation(PpmvcSort.class).value();
            if (nextSort <= thisSort) {
                continue;
            }
            if (nextSort - thisSort < abs) {
                abs = nextSort - thisSort;
                nextProcessor = chain;
                System.out.println(nextProcessor.getClass().getName());
            }
        }
        return nextProcessor;
	}
}
