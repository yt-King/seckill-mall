package com.zufe.yt.common.mongo.repository.impl;

import cn.hutool.core.collection.CollUtil;
import com.zufe.yt.common.core.util.ConverterUtil;
import com.zufe.yt.common.mongo.domain.AbstractCriteriaWrapper;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.common.mongo.util.MongoUtil;
import com.zufe.yt.common.mongo.util.SortBuilder;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 秋玖壹
 **/
public class RepositoryImpl<Domain, Entity> implements IRepository<Domain, Entity> {
    @Resource
    protected MongoUtil mongoUtil;
    /**
     * 数据库实体
     */
    protected Class<Entity> entityClass;
    /**
     * 领域实体
     */
    protected Class<Domain> domainClass;

    public RepositoryImpl() {
        ParameterizedType pt = (ParameterizedType)getClass().getGenericSuperclass();
        this.domainClass = ((Class) pt.getActualTypeArguments()[0]);
        this.entityClass = ((Class)pt.getActualTypeArguments()[1]);
    }

    @Override
    public String saveOrUpdate(Domain domain) {
        Entity entity = ConverterUtil.toDO(domain, entityClass);

        return mongoUtil.insertOrUpdate(entity);
    }

    @Override
    public void batchSave(List<Domain> domains) {
        List<Entity> entities = ConverterUtil.toDOList(domains, entityClass);

        mongoUtil.insertAll(entities);
    }

    @Override
    public Domain findById(Serializable id) {
        Entity entity =  mongoUtil.findById(id, entityClass);
        if (entity == null) {
            return null;
        }

        return ConverterUtil.toDomain(entity, domainClass);
    }

    @Override
    public List<Domain> listByIds(List<String> ids) {
        List<Entity> list = mongoUtil.findListByIds(ids, entityClass);
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }

        return ConverterUtil.toDomainList(list, domainClass);
    }

    @Override
    public Domain find(AbstractCriteriaWrapper wrapper) {
        Entity entity = mongoUtil.findOneByQuery(wrapper, entityClass);
        if (entity == null) {
            return null;
        }

        return ConverterUtil.toDomain(entity, domainClass);
    }

    @Override
    public List<Domain> list(AbstractCriteriaWrapper wrapper) {
        List<Entity> list = mongoUtil.findListByQuery(wrapper, entityClass);

        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }

        return ConverterUtil.toDomainList(list, domainClass);
    }

    @Override
    public List<Domain> list() {
        List<Entity> list = mongoUtil.findListByQuery(new CriteriaAndWrapper(), entityClass);
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }

        return ConverterUtil.toDomainList(list, domainClass);
    }

    @Override
    public List<Domain> list(SortBuilder sortBuilder, AbstractCriteriaWrapper wrapper) {
        List<Entity> list = mongoUtil.findListByQuery(wrapper, sortBuilder, entityClass);
        if (CollUtil.isEmpty(list)) {
            return Collections.emptyList();
        }

        return ConverterUtil.toDomainList(list, domainClass);
    }

    @Override
    public MongoPage<Domain> page(SortBuilder sortBuilder, MongoPage<Entity> mongoPage, AbstractCriteriaWrapper wrapper) {
        MongoPage<Entity> page = mongoUtil.findMongoPage(wrapper.build(), sortBuilder, mongoPage, entityClass);

        MongoPage<Domain> resultPage = new MongoPage<>(page.getCurrent(), page.getLimit());
        if (page.getTotalSize() != 0) {
            List<Domain> domains = new ArrayList<>();

            resultPage.setTotalPage(page.getTotalPage());
            resultPage.setTotalSize(page.getTotalSize());

            for (Entity record : page.getRecords()) {
                domains.add(ConverterUtil.toDomain(record, domainClass));
            }

            resultPage.setRecords(domains);
        }

        return resultPage;
    }

    @Override
    public void removeById(Serializable id) {
        mongoUtil.deleteById(id, entityClass);
    }

    @Override
    public void removeByIds(List<String> ids) {
        mongoUtil.deleteByIds(ids, entityClass);
    }

    @Override
    public void remove(AbstractCriteriaWrapper wrapper) {
        mongoUtil.deleteByQuery(wrapper, entityClass);
    }

    @Override
    public long count(AbstractCriteriaWrapper wrapper) {
        return mongoUtil.findCountByQuery(wrapper, entityClass);
    }
}
