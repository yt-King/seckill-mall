package com.zufe.yt.common.core.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ReflectUtil;
import com.zufe.yt.common.core.domain.ValueObject;
import com.zufe.yt.common.core.exception.ServiceException;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 领域对象与DO互转
 *
 * @author 秋玖壹
 **/
public class ConverterUtil {

    /**
     * 根据相同字段名 领域对象转DO
     *
     * @param source 领域对象
     * @param target DO类
     * @param <T>    DO
     * @return DO
     */
    public static <T> T toDO(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }

        Map<String, Object> sourceMap = new LinkedHashMap<>(16);
        BeanUtil.descForEach(source.getClass(), (prop) -> {
            Field field = prop.getField();
            Class<?> fieldType = field.getType();
            Object value = prop.getValue(source);
            if (ClassUtil.isAssignable(ValueObject.class, fieldType)) {
                ValueObject<?> valueObject = (ValueObject<?>) value;
                if (valueObject != null) {
                    value = valueObject.getValue();
                }
            }
            sourceMap.put(prop.getFieldName(), value);
        });

        return BeanUtil.toBean(sourceMap, target);
    }

    /**
     * 根据相同字段名 领域对象集合转DO集合
     *
     * @param source 领域对象集合
     * @param target DO类
     * @param <T>    DO
     * @return DO集合
     */
    public static <T, S> List<T> toDOList(List<S> source, Class<T> target) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>();
        for (S s : source) {
            list.add(toDO(s, target));
        }
        return list;
    }

    /**
     * 根据相同字段名 DO转领域对象
     *
     * @param source DO对象
     * @param target 领域类
     * @param <T>    领域对象
     * @return 领域对象
     */
    public static <T> T toDomain(Object source, Class<T> target) {
        if (source == null) {
            return null;
        }

        Map<String, Object> objectMap = BeanUtil.beanToMap(source);

        T targetObj = ReflectUtil.newInstanceIfPossible(target);

        BeanUtil.descForEach(targetObj.getClass(), (prop) -> {
            String fieldName = prop.getFieldName();
            if (objectMap.containsKey(fieldName)) {
                Field field = prop.getField();
                Class<?> fieldType = field.getType();
                Object value = objectMap.get(fieldName);
                if (ClassUtil.isAssignable(ValueObject.class, fieldType)) {
                    try {
                        if (value != null) {
                            Object fieldObj = ReflectUtil.newInstance(fieldType, value);
                            prop.setValue(targetObj, fieldObj);
                        }
                    } catch (Exception e) {
                        if (e.getCause().getCause() instanceof ServiceException) {
                            throw (ServiceException) e.getCause().getCause();
                        }
                        throw e;
                    }
                } else {
                    prop.setValue(targetObj, value);
                }
            }
        });

        return targetObj;
    }

    /**
     * 根据相同字段名 DO集合转领域对象集合
     *
     * @param source DO对象集合
     * @param target 领域类
     * @param <T>    领域对象
     * @return 领域对象集合
     */
    public static <T, S> List<T> toDomainList(List<S> source, Class<T> target) {
        if (source == null || source.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> list = new ArrayList<>();
        for (S s : source) {
            list.add(toDomain(s, target));
        }
        return list;
    }
}
