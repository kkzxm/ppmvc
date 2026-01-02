package com.kkzxm.ppmvc.core.mapper;

import com.kkzxm.ppmvc.entity.Word;
import com.kkzxm.ppmvc.mapper.PMapper;

public interface WordMapper extends PMapper<Word> {
    @Override
    default Class<Word> getEntityClass() {
        return Word.class;
    }
}
