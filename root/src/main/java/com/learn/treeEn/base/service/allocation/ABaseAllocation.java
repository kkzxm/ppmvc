package com.learn.treeEn.base.service.allocation;

import com.learn.treeEn.base.service.ABaseDoIt;
import lombok.Getter;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/23 04:18
 */
@Getter
public class ABaseAllocation<T> extends ABaseDoIt<T> {
    ABaseDoIt<T> aBaService;

    public ABaseAllocation(ABaseDoIt<T> baService,Class<T> tClass) {
        super(baService.getBaseMapper(),tClass);
        this.aBaService = baService;

    }

}
