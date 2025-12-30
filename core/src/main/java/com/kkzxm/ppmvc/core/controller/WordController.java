package com.kkzxm.ppmvc.core.controller;

import com.kkzxm.ppmvc.assign.chian.basic.RegularChain;
import com.kkzxm.ppmvc.controller.AController;
import com.kkzxm.ppmvc.entity.Word;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/word")
public class WordController extends AController<Word> {

    public WordController(RegularChain<Word> reg) {
        super(Word.class, reg);
    }
}
