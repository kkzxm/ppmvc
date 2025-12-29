package com.learn.treeEn.core.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learn.treeEn.base.service.ABaseDoIt;
import com.learn.treeEn.entity.Word;
import org.springframework.stereotype.Service;

@Service
public class WordService extends ABaseDoIt<Word> {

    public WordService(BaseMapper<Word> wordMapper) {
        super(wordMapper, Word.class);
    }


}
