package com.zufe.yt.common.mongo.domain;

import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 查询语句生成器
 *
 * @author Chen
 * @date 2021/5/24
 */
public abstract class AbstractCriteriaWrapper {
    boolean andLink = true;

    Criteria criteria;
    List<Criteria> list = new ArrayList<>();

    /**
     * 将Wrapper转化为Criteria
     *
     * @return Criteria
     */
    public Criteria build() {
        criteria = new Criteria();
        if (list.size() > 0) {
            if (andLink) {
                criteria.andOperator(listToArray(list));
            } else {
                criteria.orOperator(listToArray(list));
            }
        }
        return criteria;
    }

    private Criteria[] listToArray(List<Criteria> list) {
        return list.toArray(new Criteria[0]);
    }


    /**
     * 等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper eq(String column, Object params) {
        list.add(Criteria.where(column).is(params));
        return this;
    }

    /**
     * 不等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper ne(String column, Object params) {
        list.add(Criteria.where(column).ne(params));
        return this;
    }

    /**
     * 小于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper lt(String column, Object params) {
        list.add(Criteria.where(column).lt(params));
        return this;
    }

    /**
     * 小于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper lte(String column, Object params) {
        list.add(Criteria.where(column).lte(params));
        return this;
    }

    /**
     * 大于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper gt(String column, Object params) {
        list.add(Criteria.where(column).gt(params));
        return this;
    }

    /**
     * 大于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper gte(String column, Object params) {
        list.add(Criteria.where(column).gte(params));
        return this;
    }

    /**
     * 包含
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper contain(String column, Object params) {
        list.add(Criteria.where(column).all(params));
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper containOr(String column, Collection<?> params) {
        CriteriaOrWrapper criteriaOrWrapper = new CriteriaOrWrapper();
        for (Object object : params) {
            criteriaOrWrapper.contain(column, object);
        }

        list.add(criteriaOrWrapper.build());
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper containOr(String column, Object[] params) {
        return containOr(column, Arrays.asList(params));
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper containAnd(String column, Collection<?> params) {
        list.add(Criteria.where(column).all(params));
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper containAnd(String column, Object[] params) {
        return containAnd(column, Arrays.asList(params));
    }

    /**
     * 相似于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper like(String column, String params) {
        Pattern pattern = Pattern.compile("^.*" + params + ".*$", Pattern.CASE_INSENSITIVE);
        list.add(Criteria.where(column).regex(pattern));
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper in(String column, Collection<?> params) {
        list.add(Criteria.where(column).in(params));
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper in(String column, Object[] params) {
        return in(column, Arrays.asList(params));
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper nin(String column, Collection<?> params) {
        list.add(Criteria.where(column).nin(params));
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper nin(String column, Object[] params) {
        return nin(column, Arrays.asList(params));
    }

    /**
     * 为空
     *
     * @param column 字段
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper isNull(String column) {
        list.add(Criteria.where(column).is(null));
        return this;
    }

    /**
     * 不为空
     *
     * @param column 字段
     * @return CriteriaWrapper
     */
    public AbstractCriteriaWrapper isNotNull(String column) {
        list.add(Criteria.where(column).ne(null));
        return this;
    }

    /**
     * 数组查询
     *
     * @param arr    数组名
     * @param column 字段名
     * @param param  字段值
     * @return
     */
    public AbstractCriteriaWrapper findArray(String arr, String column, String param) {
        list.add(Criteria.where(arr).elemMatch(Criteria.where(column).is(param)));
        return this;
    }

    /**
     * 数组模糊查询
     *
     * @param arr    数组名
     * @param column 字段名
     * @param param  字段值
     * @return
     */
    public AbstractCriteriaWrapper findArrayLike(String arr, String column, String param) {
        Pattern pattern = Pattern.compile("^.*" + param + ".*$", Pattern.CASE_INSENSITIVE);
        list.add(Criteria.where(arr).elemMatch(Criteria.where(column).regex(pattern)));
        return this;
    }
}
