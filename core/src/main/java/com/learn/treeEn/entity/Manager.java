package com.learn.treeEn.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2021-04-26 13:26
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("manager")
public class Manager {
    private Integer managerId;
    private String accountNumber;
    private String managerPassword;
}
