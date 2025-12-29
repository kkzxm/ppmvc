package com.kkzxm.ppmvc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kkzxm.ppmvc.entity.BaseEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
@NoArgsConstructor
@TableName("tag_group")
public class TagGroup implements BaseEntity {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String name;
    private String comment;
    private Integer parentId;

    @TableField(exist = false)
    private TagGroup parent;
    @TableField(exist = false)
    private final Set<TagGroup> children = new HashSet<>();

    @NonNull
    public void setParent(TagGroup tagGroup){
        if (this.parentId.equals(tagGroup.id)) {
           this.parent = tagGroup;
        }
    }
}
