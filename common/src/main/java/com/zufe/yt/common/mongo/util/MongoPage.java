package com.zufe.yt.common.mongo.util;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页类
 *
 * @author 秋玖壹
 */
@Data
public class MongoPage<T> {
    /**
     * 总页数
     */
    long totalPage = 0;
    /**
     * 总条数
     */
    long totalSize = 0;
    /**
     * 起始页
     */
    long current = 1;
    /**
     * 每页记录数
     */
    long limit = 10;
    /**
     * 数据
     */
    List<T> records = Collections.emptyList();

    public MongoPage () { }

    public MongoPage (long page, long pageSize) {
        this.current = page;
        this.limit = pageSize;
    }
}
