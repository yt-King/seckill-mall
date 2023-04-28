package com.zufe.yt.person.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.person.application.CollectionApplication;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.person.application.service
 * @className: CollectionApplicationImpl
 * @date 2023/4/28
 * @description: 收藏服务实现类
 */
public class CollectionApplicationImpl implements CollectionApplication {
    @Resource
    private CollectionRepository collectionRepository;

    @Override
    public void save(Collection collection) {
        collection.Valid();
        collectionRepository.saveOrUpdate(collection);
    }

    @Override
    public void delete(Collection collection) {
        collection.Valid();
        collectionRepository.delete(collection);
    }

    @Override
    public Collection getCollection(String userId) {
        if (StrUtil.isBlank(userId)) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        return collectionRepository.find(new CriteriaAndWrapper().eq(Collection::getUserId, userId));
    }
}
