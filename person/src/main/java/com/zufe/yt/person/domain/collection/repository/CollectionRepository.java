package com.zufe.yt.person.domain.collection.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.infrastructure.persistence.data.CollectionDO;

/**
 * @author yt
 * @date 2023/4/15
 * @description: TODO
 */
public interface CollectionRepository extends IRepository<Collection, CollectionDO> {
    @Override
    String saveOrUpdate(Collection collection);

    String delete(Collection collection);
}
