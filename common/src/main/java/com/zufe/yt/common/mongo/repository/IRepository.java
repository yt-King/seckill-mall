package com.zufe.yt.common.mongo.repository;


import com.zufe.yt.common.mongo.domain.AbstractCriteriaWrapper;
import com.zufe.yt.common.mongo.util.MongoPage;
import com.zufe.yt.common.mongo.util.SortBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * 公共方法
 *
 * @author 秋玖壹
 **/
public interface IRepository<Domain, Entity> {
    /**
     * 新增或者修改
     *
     * @param domain DO实体类
     * @return 主键
     */
    String saveOrUpdate(Domain domain);

    /**
     * 批量新增
     *
     * @param domains DO集合
     */
    void batchSave(List<Domain> domains);

    /**
     * 根据ID查找
     *
     * @param id 主键
     * @return 领域对象
     */
    Domain findById(Serializable id);

    /**
     * 根据ID集合查找
     *
     * @param ids 主键集合
     * @return 领域对象集合
     */
    List<Domain> listByIds(List<String> ids);

    /**
     * 根据条件查找
     *
     * @param wrapper 条件
     * @return 领域对象
     */
    Domain find(AbstractCriteriaWrapper wrapper);

    /**
     * 根据条件查找集合
     *
     * @param wrapper 条件
     * @return 领域对象
     */
    List<Domain> list(AbstractCriteriaWrapper wrapper);

    /**
     * 查询所有
     *
     * @return 领域对象
     */
    List<Domain> list();

    /**
     * 根据条件查找集合 并且排序
     *
     * @param wrapper     条件
     * @param sortBuilder 排序
     * @return 领域对象
     */
    List<Domain> list(SortBuilder sortBuilder, AbstractCriteriaWrapper wrapper);

    /**
     * 根据条件查找分页
     *
     * @param wrapper     条件
     * @param sortBuilder 排序
     * @param mongoPage   分页
     * @return 领域对象
     */
    MongoPage<Domain> page(SortBuilder sortBuilder, MongoPage<Entity> mongoPage, AbstractCriteriaWrapper wrapper);

    /**
     * 根据主键删除
     *
     * @param id 主键
     */
    void removeById(Serializable id);

    /**
     * 根据ID集合批量删除
     *
     * @param ids 主键集合
     */
    void removeByIds(List<String> ids);

    /**
     * 根据条件删除
     *
     * @param wrapper 条件
     */
    void remove(AbstractCriteriaWrapper wrapper);

    /**
     * 根据条件统计
     *
     * @param wrapper 条件
     * @return 统计数
     */
    long count(AbstractCriteriaWrapper wrapper);
}
