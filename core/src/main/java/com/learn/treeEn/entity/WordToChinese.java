package com.learn.treeEn.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.kkzxm.ppmvc.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-21 10:37
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("word_to_chinese")
public class WordToChinese implements BaseEntity {
    private Integer word_id;
    private Integer chinese_id;
    private String comment;

    /**
     * 面对一对多关系的处理
     * 一个单词对应多个中文
     */
    public static Set<WordToChinese> wordIdGetWordToChineseSet(Integer word_id,
                                                               Set<Chinese> chineseSet,
                                                               String comm) {
        Set<WordToChinese> wordToChineseSet = new HashSet<>();
        chineseSet.forEach(ch -> {
            wordToChineseSet.add(new WordToChinese(word_id, ch.getId(), comm));
        });
        return wordToChineseSet;
    }

    /**
     * 面对一对多关系的处理
     * 一个中文对应多个单词
     */
    public static Set<WordToChinese> chineseIdGetWordToChineseSet(Integer chinese_id,
                                                                  Set<Word> wordSet,
                                                                  String comment) {
        Set<WordToChinese> wordToChineseSet = new HashSet<>();
        wordSet.forEach(wo -> {
            wordToChineseSet.add(new WordToChinese(wo.getId(), chinese_id, comment));
        });
        return wordToChineseSet;
    }

}
