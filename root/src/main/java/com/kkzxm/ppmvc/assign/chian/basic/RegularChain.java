package com.kkzxm.ppmvc.assign.chian.basic;


import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.BaseEntity;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

/**
 * 普通链式调用
 * controller → service → mapper
 */
@Component
public class RegularChain<T extends BaseEntity> extends BaseChain<T> {

	RegularChain(PpmvcContext ppmvcContext) {
        super(ppmvcContext);
    }



	@Override
    @PostConstruct
	public  void processorChain() {
        super.getEntityClassIterator();
	}
}
