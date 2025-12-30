package com.kkzxm.ppmvc.core.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kkzxm.ppmvc.assign.chian.BaseChain;
import com.kkzxm.ppmvc.entity.WordToChinese;
import com.kkzxm.ppmvc.service.AService;

import org.springframework.stereotype.Service;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Service
public class WordToChineseService extends AService<WordToChinese> {

    public WordToChineseService(BaseChain<WordToChinese> reg) {
        super(WordToChinese.class, reg);
    }
}
