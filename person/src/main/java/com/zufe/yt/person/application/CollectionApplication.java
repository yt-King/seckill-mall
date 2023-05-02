package com.zufe.yt.person.application;

import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.interfaces.dto.CollectionInfoDTO;

import java.util.List;

/**
 * @author yt
 * @date 2023/4/28
 * @description: TODO
 */
public interface CollectionApplication {
    /**
     * 新增
     */
    void save(Collection collection);

    /**
     * 删除
     */
    void delete(Collection collection);

    /**
     * 列表
     */
    List<CollectionInfoDTO> getCollection(String userId);
}
