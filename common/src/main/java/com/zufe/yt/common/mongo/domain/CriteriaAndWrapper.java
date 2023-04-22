package com.zufe.yt.common.mongo.domain;


import com.zufe.yt.common.mongo.util.ReflectionUtil;
import com.zufe.yt.common.mongo.util.SerializableFunction;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.Collection;

/**
 * 查询语句生成器 AND连接
 *
 * @author 秋玖壹
 */
public class CriteriaAndWrapper extends AbstractCriteriaWrapper {
    public CriteriaAndWrapper() {
        andLink = true;
    }

    public CriteriaAndWrapper and(Criteria criteria) {
        list.add(criteria);
        return this;
    }

    public CriteriaAndWrapper and(AbstractCriteriaWrapper wrapper) {
        list.add(wrapper.build());
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
    public CriteriaAndWrapper eq(String column, Object params) {
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
    public <T, R> CriteriaAndWrapper eq(SerializableFunction<T, R> column, Object params) {
        super.eq(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper ne(String column, Object params) {
        super.ne(column, params);
        return this;
    }

    /**
     * 不等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper ne(SerializableFunction<T, R> column, Object params) {
        super.ne(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 小于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper lt(String column, Object params) {
        super.lt(column, params);
        return this;
    }

    /**
     * 小于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper lt(SerializableFunction<T, R> column, Object params) {
        super.lt(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 小于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper lte(String column, Object params) {
        super.lte(column, params);
        return this;
    }

    /**
     * 小于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper lte(SerializableFunction<T, R> column, Object params) {
        super.lte(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 大于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper gt(String column, Object params) {
        super.gt(column, params);
        return this;
    }

    /**
     * 大于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper gt(SerializableFunction<T, R> column, Object params) {
        super.gt(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 大于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper gte(String column, Object params) {
        super.gte(column, params);
        return this;
    }

    /**
     * 大于或等于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper gte(SerializableFunction<T, R> column, Object params) {
        super.gte(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper contain(String column, Object params) {
        super.contain(column, params);
        return this;
    }

    /**
     * 包含
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper contain(SerializableFunction<T, R> column, Object params) {
        super.contain(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper containOr(String column, Collection<?> params) {
        super.containOr(column, params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper containOr(SerializableFunction<T, R> column, Collection<?> params) {
        super.containOr(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper containOr(String column, Object[] params) {
        super.containOr(column, params);
        return this;
    }

    /**
     * 包含,以或连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper containOr(SerializableFunction<T, R> column, Object[] params) {
        super.containOr(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper containAnd(String column, Collection<?> params) {
        super.containAnd(column, params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper containAnd(SerializableFunction<T, R> column, Collection<?> params) {
        super.containAnd(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper containAnd(String column, Object[] params) {
        super.containAnd(column, params);
        return this;
    }

    /**
     * 包含,以且连接
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper containAnd(SerializableFunction<T, R> column, Object[] params) {
        super.containAnd(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 相似于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper like(String column, String params) {
        super.like(column, params);
        return this;
    }

    /**
     * 相似于
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper like(SerializableFunction<T, R> column, String params) {
        super.like(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper in(String column, Collection<?> params) {
        super.in(column, params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper in(SerializableFunction<T, R> column, Collection<?> params) {
        super.in(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper in(String column, Object[] params) {
        super.in(column, params);
        return this;
    }

    /**
     * 在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper in(SerializableFunction<T, R> column, Object[] params) {
        super.in(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper nin(String column, Collection<?> params) {
        super.nin(column, params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper nin(SerializableFunction<T, R> column, Collection<?> params) {
        super.nin(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper nin(String column, Object[] params) {
        super.nin(column, params);
        return this;
    }

    /**
     * 不在其中
     *
     * @param column 字段
     * @param params 参数
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper nin(SerializableFunction<T, R> column, Object[] params) {
        super.nin(ReflectionUtil.getFieldName(column), params);
        return this;
    }

    /**
     * 为空
     *
     *
     * @param column 字段
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper isNull(String column) {
        super.isNull(column);
        return this;
    }

    /**
     * 为空
     *
     *
     * @param column 字段
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper isNull(SerializableFunction<T, R> column) {
        super.isNull(ReflectionUtil.getFieldName(column));
        return this;
    }

    /**
     * 不为空
     *
     *
     * @param column 字段
     * @return CriteriaAndWrapper
     */
    @Override
    public CriteriaAndWrapper isNotNull(String column) {
        super.isNotNull(column);
        return this;
    }

    /**
     * 不为空
     *
     *
     * @param column 字段
     * @return CriteriaAndWrapper
     */
    public <T, R> CriteriaAndWrapper isNotNull(SerializableFunction<T, R> column) {
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
    public CriteriaAndWrapper findArray(String arr, String column, String param) {
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
    public <T, R> CriteriaAndWrapper findArray(SerializableFunction<T, R> arr, SerializableFunction<T, R> column, String param) {
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
    public CriteriaAndWrapper findArrayLike(String arr, String column, String param) {
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
    public <T, R> CriteriaAndWrapper findArrayLike(SerializableFunction<T, R> arr, SerializableFunction<T, R> column, String param) {
        super.findArrayLike(ReflectionUtil.getFieldName(arr), ReflectionUtil.getFieldName(column), param);
        return this;
    }
}
