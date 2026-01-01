package com.kkzxm.ppmvc.core.service;

import com.kkzxm.ppmvc.assign.chian.PpmvcContext;
import com.kkzxm.ppmvc.entity.Word;
import com.kkzxm.ppmvc.service.AService;

import org.springframework.stereotype.Service;

@Service
public class WordService extends AService<Word> {

    public WordService( PpmvcContext ppmvcContext) {
        super(Word.class, ppmvcContext);
    }



}
