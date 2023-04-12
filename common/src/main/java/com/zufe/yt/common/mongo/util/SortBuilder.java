package com.zufe.yt.common.mongo.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序
 *
 * @author 秋玖壹
 */
public class SortBuilder {
    List<Order> orderList = new ArrayList<>();

    public SortBuilder() {
    }

    public SortBuilder(String column, Direction direction) {
        Order order = new Order(direction, column);
        orderList.add(order);
    }

    public SortBuilder(List<Order> orderList) {
        this.orderList.addAll(orderList);
    }

    public <T, R> SortBuilder(SerializableFunction<T, R> column, Direction direction) {
        Order order = new Order(direction, ReflectionUtil.getFieldName(column));
        orderList.add(order);
    }

    public SortBuilder desc(String column) {
        Order order = new Order(Direction.DESC, column);
        orderList.add(order);
        return this;
    }

    public <T, R> SortBuilder desc(SerializableFunction<T, R> column) {
        return this.desc(ReflectionUtil.getFieldName(column));
    }

    public SortBuilder asc(String column) {
        Order order = new Order(Direction.ASC, column);
        orderList.add(order);
        return this;
    }

    public <T, R> SortBuilder asc(SerializableFunction<T, R> column) {
        return this.asc(ReflectionUtil.getFieldName(column));
    }

    public Sort toSort() {
        return Sort.by(orderList);
    }
}
