package com.zufe.yt.common.mongo.domain;


import com.zufe.yt.common.mongo.util.ReflectionUtil;
import com.zufe.yt.common.mongo.util.SerializableFunction;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Collection;

/**
 * 查询语句生成器 OR连接
 *
 * @author Chen
 * @date 2021/5/24
 */
public class CriteriaOrWrapper extends AbstractCriteriaWrapper {
    public CriteriaOrWrapper() {
        andLink = false;
    }

    public CriteriaOrWrapper or(Criteria criteria) {
        list.add(criteria);
        return this;
    }

    public CriteriaOrWrapper or(AbstractCriteriaWrapper abstractCriteriaWrapper) {
        list.add(abstractCriteriaWrapper.build());
        return this;
    }

    /**
     * 等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    @Override
    public CriteriaOrWrapper eq(String column, Object params) {
        super.eq(column, params);
        return this;
    }

    /**
     * 等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaWrapper
     */
    public <T, R> CriteriaOrWrapper eq(SerializableFunction<T, R> column, Object params) {
        super.eq(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper ne(String column, Object params) {
        super.ne(column, params);
        return this;
    }

    /**
     * 不等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper ne(SerializableFunction<T, R> column, Object params) {
        super.ne(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 小于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper lt(String column, Object params) {
        super.lt(column, params);
        return this;
    }

    /**
     * 小于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper lt(SerializableFunction<T, R> column, Object params) {
        super.lt(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 小于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper lte(String column, Object params) {
        super.lte(column, params);
        return this;
    }

    /**
     * 小于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper lte(SerializableFunction<T, R> column, Object params) {
        super.lte(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 大于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper gt(String column, Object params) {
        super.gt(column, params);
        return this;
    }

    /**
     * 大于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper gt(SerializableFunction<T, R> column, Object params) {
        super.gt(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 大于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper gte(String column, Object params) {
        super.gte(column, params);
        return this;
    }

    /**
     * 大于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper gte(SerializableFunction<T, R> column, Object params) {
        super.gte(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper contain(String column, Object params) {
        super.contain(column, params);
        return this;
    }

    /**
     * 包含
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper contain(SerializableFunction<T, R> column, Object params) {
        super.contain(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper containOr(String column, Collection<?> params) {
        super.containOr(column, params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper containOr(SerializableFunction<T, R> column, Collection<?> params) {
        super.containOr(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper containOr(String column, Object[] params) {
        super.containOr(column, params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper containOr(SerializableFunction<T, R> column, Object[] params) {
        super.containOr(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper containAnd(String column, Collection<?> params) {
        super.containAnd(column, params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper containAnd(SerializableFunction<T, R> column, Collection<?> params) {
        super.containAnd(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper containAnd(String column, Object[] params) {
        super.containAnd(column, params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper containAnd(SerializableFunction<T, R> column, Object[] params) {
        super.containAnd(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 相似于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper like(String column, String params) {
        super.like(column, params);
        return this;
    }

    /**
     * 相似于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper like(SerializableFunction<T, R> column, String params) {
        super.like(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper in(String column, Collection<?> params) {
        super.in(column, params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper in(SerializableFunction<T, R> column, Collection<?> params) {
        super.in(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper in(String column, Object[] params) {
        super.in(column, params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper in(SerializableFunction<T, R> column, Object[] params) {
        super.in(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper nin(String column, Collection<?> params) {
        super.nin(column, params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper nin(SerializableFunction<T, R> column, Collection<?> params) {
        super.nin(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper nin(String column, Object[] params) {
        super.nin(column, params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper nin(SerializableFunction<T, R> column, Object[] params) {
        super.nin(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 为空
     *
     * @param column 字段
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper isNull(String column) {
        super.isNull(column);
        return this;
    }

    /**
     * 为空
     *
     * @param column 字段
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper isNull(SerializableFunction<T, R> column) {
        super.isNull(ReflectionUtil.getFieldName(column));
        return this;
    }

    /**
     * 不为空
     *
     * @param column 字段
     * @return CriteriaOrWrapper
     */
    @Override
    public CriteriaOrWrapper isNotNull(String column) {
        super.isNotNull(column);
        return this;
    }

    /**
     * 不为空
     *
     * @param column 字段
     * @return CriteriaOrWrapper
     */
    public <T, R> CriteriaOrWrapper isNotNull(SerializableFunction<T, R> column) {
        super.isNotNull(ReflectionUtil.getFieldName(column));
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
    @Override
    public CriteriaOrWrapper findArray(String arr, String column, String param) {
        super.findArray(arr, column, param);
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
    public <T, R> CriteriaOrWrapper findArray(SerializableFunction<T, R> arr, SerializableFunction<T, R> column, String param) {
        super.findArray(ReflectionUtil.getFieldName(arr), ReflectionUtil.getFieldName(column), param);
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
    @Override
    public CriteriaOrWrapper findArrayLike(String arr, String column, String param) {
        super.findArrayLike(arr, column, param);
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
    public <T, R> CriteriaOrWrapper findArrayLike(SerializableFunction<T, R> arr, SerializableFunction<T, R> column, String param) {
        super.findArrayLike(ReflectionUtil.getFieldName(arr), ReflectionUtil.getFieldName(column), param);
        return this;
    }
}
