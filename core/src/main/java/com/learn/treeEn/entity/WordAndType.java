package com.learn.treeEn.entity;


import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("word_and_type")
public class WordAndType implements Serializable {
    private Integer word_id;
    private Integer type_id;
    private String comment;

    /**
     * 面对一对多关系的处理
     * 一个单词对应多个类型
     */
    public static Set<WordAndType> wordIdGetWordAndTypeSet(Integer word_id,
                                                           Set<WordType> wordTypeSetSet,
                                                           String comm) {
        Set<WordAndType> wordAndTypeSet = new HashSet<>();
        wordTypeSetSet.forEach(tp -> {
            wordAndTypeSet.add(new WordAndType(word_id, tp.getId(), comm));
        });
        return wordAndTypeSet;
    }

    /**
     * 面对一对多关系的处理
     * 一个类型对应多个单词
     */
    public static Set<WordAndType> typeIdGetWordAndTypeSet(Integer type_id,
                                                           Set<Word> wordSet,
                                                           String comment) {
        Set<WordAndType> wordAndTypeSet = new HashSet<>();
        wordSet.forEach(wo -> {
            wordAndTypeSet.add(new WordAndType(wo.getId(), type_id, comment));
        });
        return wordAndTypeSet;
    }
}
