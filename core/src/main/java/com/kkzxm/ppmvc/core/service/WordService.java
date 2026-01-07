package com.kkzxm.ppmvc.core.service;

import com.kkzxm.ppmvc.entity.Word;
import com.kkzxm.ppmvc.mapper.PMapper;
import com.kkzxm.ppmvc.service.AService;

import org.springframework.stereotype.Service;

@Service
public class WordService extends AService<Word> {

    public WordService(PMapper<Word> mapper) {
        super(Word.class, mapper);
    }



}
