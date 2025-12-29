package com.learn.treeEn.core.service.allocation;

import com.learn.treeEn.base.service.allocation.ABaseAllocation;
import com.learn.treeEn.core.service.*;
import com.learn.treeEn.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Author: 酷酷宅小明
 * @CreateTime: 2024/10/23 04:19
 */
@Component
public class WordAllocation extends ABaseAllocation<Word> {
    private final ChineseService sChinese;
    private final WordToChineseService sWordToChinese;
    private final WordTypeService sType;
    private final WordAndTypeService sWordAndType;
    private final TagGroupService sTag;
    private final WordAndTagService sWordAndTag;

    public WordAllocation(WordService wordService,
                          ChineseService sChinese,
                          WordToChineseService sWordToChinese,
                          WordTypeService sType,
                          WordAndTypeService sWordAndType,
                          TagGroupService sTag,
                          WordAndTagService sWordAndTag) {
        super(wordService, Word.class);
        this.sChinese = sChinese;
        this.sWordToChinese = sWordToChinese;
        this.sType = sType;
        this.sWordAndType = sWordAndType;
        this.sTag = sTag;
        this.sWordAndTag = sWordAndTag;
    }

    /**
     * 在添加单词时,
     * 可顺便添加,中文,类型,标签
     *
     * @param word 单词
     */
    @Transactional
    public void add(Word word) {
        super.getABaService().saveOrUpdate(word);
        Set<Chinese> chineseSet = word.getChineseSet();
        Set<WordType> typeSet = word.getTypeSet();
        Set<TagGroup> tagSet = word.getTagSet();
        // 有内容才添加或修改
        boolean ch = chineseSet.size() > 1 && sChinese.saveOrUpdateBatch(chineseSet);
        boolean ty = typeSet.size() > 1 && sType.saveOrUpdateBatch(typeSet);
        boolean ta = tagSet.size() > 1 && sTag.saveOrUpdateBatch(tagSet);
        //操作关系表
        //准备数据
        Integer wordId = word.getId();
        Set<WordToChinese> wordToChineseSet = WordToChinese.wordIdGetWordToChineseSet(wordId, chineseSet, "");
        Set<WordAndType> wordAndTypeSet = WordAndType.wordIdGetWordAndTypeSet(wordId, typeSet, "");
        Set<WordAndTagGroup> wordAndTagGroups = WordAndTagGroup.wordIdGetWordTagSet(wordId, tagSet, "");
        //添加关系表
        boolean a = ch && sWordToChinese.saveOrUpdateBatch(wordToChineseSet);
        boolean b = ty && sWordAndType.saveOrUpdateBatch(wordAndTypeSet);
        boolean c = ta && sWordAndTag.saveOrUpdateBatch(wordAndTagGroups);
    }
}
