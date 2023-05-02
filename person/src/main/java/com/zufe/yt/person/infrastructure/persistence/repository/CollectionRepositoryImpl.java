package com.zufe.yt.person.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;
import com.zufe.yt.person.infrastructure.persistence.data.CollectionDO;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.repository
 * @className: CollectionRepositoryImpl
 * @date 2023/4/15
 * @description: 收藏持久化实现类 // todo:有空把缓存加上
 */
@Repository
public class CollectionRepositoryImpl extends RepositoryImpl<Collection, CollectionDO> implements CollectionRepository {
    @Override
    public String saveOrUpdate(Collection collection) {
        Collection find = super.find(new CriteriaAndWrapper().eq(Collection::getUserId, collection.getUserId()));
        if (null == find) {
            //第一次新增
            return super.saveOrUpdate(collection);
        }
        //更新
        collection.setId(find.getId());
        //把原来的加进去再保存
        find.getProductIds().add(collection.getProductIds().get(0));
        collection.setProductIds(find.getProductIds());
        //做一遍去重保险一点
        collection.setProductIds(collection.getProductIds().parallelStream().distinct().collect(Collectors.toList()));
        return super.saveOrUpdate(collection);
    }

    @Override
    public String delete(Collection collection) {
        Collection find = super.find(new CriteriaAndWrapper().eq(Collection::getUserId, collection.getUserId()));
        if (null == find) {
            //直接返回
            return "";
        }
        collection.setId(find.getId());
        //删除
        find.getProductIds().removeIf(x -> x.equals(collection.getProductIds().get(0)));
        //做一遍去重保险一点
        collection.setProductIds(find.getProductIds().parallelStream().distinct().collect(Collectors.toList()));
        return super.saveOrUpdate(collection);
    }
}
