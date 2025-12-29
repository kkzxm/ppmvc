package com.learn.treeEn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@TableName("en_word")
public class Word {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String spell;
    private String comment;

    @TableField(exist = false)
    private final Set<Chinese> chineseSet = new HashSet<>();
    @TableField(exist = false)
    private final Set<WordType> typeSet = new HashSet<>();
    @TableField(exist = false)
    private final Set<TagGroup> tagSet = new HashSet<>();

}
