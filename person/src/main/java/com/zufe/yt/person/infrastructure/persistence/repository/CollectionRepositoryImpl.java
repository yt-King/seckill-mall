package com.zufe.yt.person.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;
import com.zufe.yt.person.infrastructure.persistence.data.CollectionDO;
import org.springframework.stereotype.Repository;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.repository
 * @className: CollectionRepositoryImpl
 * @date 2023/4/15
 * @description: TODO
 */
@Repository
public class CollectionRepositoryImpl extends RepositoryImpl<Collection, CollectionDO> implements CollectionRepository {

}
