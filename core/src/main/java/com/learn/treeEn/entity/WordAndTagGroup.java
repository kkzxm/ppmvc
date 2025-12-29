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
@TableName("word_tag_group")
public class WordAndTagGroup implements Serializable {
    private Integer word_id;
    private Integer tag_id;
    private String comment;

    /**
     * 面对一对多关系的处理
     * 一个单词对应多个标签
     */
    public static Set<WordAndTagGroup> wordIdGetWordTagSet(Integer word_id,
                                                         Set<TagGroup> tagSet,
                                                         String comm) {
        Set<WordAndTagGroup> wordAndTagGroupSet = new HashSet<>();
        tagSet.forEach(ta -> {
            wordAndTagGroupSet.add(new WordAndTagGroup(word_id, ta.getId(), comm));
        });
        return wordAndTagGroupSet;
    }

    /**
     * 面对一对多关系的处理
     * 一个标签对应多个单词
     */
    public static Set<WordAndTagGroup> tagIdGetWordToChineseSet(Integer tag_id,
                                                                  Set<Word> wordSet,
                                                                  String comment) {
        Set<WordAndTagGroup> wordToChineseSet = new HashSet<>();
        wordSet.forEach(wo -> {
            wordToChineseSet.add(new WordAndTagGroup(wo.getId(), tag_id, comment));
        });
        return wordToChineseSet;
    }
}
