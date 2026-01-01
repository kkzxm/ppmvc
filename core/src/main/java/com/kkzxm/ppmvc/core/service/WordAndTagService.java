package com.kkzxm.ppmvc.core.service;


import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.WordAndTagGroup;
import com.kkzxm.ppmvc.service.AService;

import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Service
public class WordAndTagService extends AService<WordAndTagGroup> {

    public WordAndTagService(PpmvcContext ppmvcContext) {
        super(WordAndTagGroup.class, ppmvcContext);
    }

}
