package com.zufe.yt.person.application;

import com.zufe.yt.person.domain.collection.entity.Collection;

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
     * 删除
     */
    Collection getCollection(String userId);
}
