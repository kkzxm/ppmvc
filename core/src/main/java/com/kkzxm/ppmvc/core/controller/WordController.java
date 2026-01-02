package com.kkzxm.ppmvc.core.controller;

import com.kkzxm.ppmvc.controller.AController;
import com.kkzxm.ppmvc.entity.Word;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/word")
public class WordController extends AController<Word> {

    public WordController() {
        super(Word.class);
    }
}
