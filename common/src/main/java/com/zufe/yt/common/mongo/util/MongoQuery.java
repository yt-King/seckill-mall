package com.zufe.yt.common.mongo.util;


import com.zufe.yt.common.core.util.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * mongo分页对象
 *
 * @author 秋玖壹
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MongoQuery<T> extends BaseQuery {

    public MongoPage<T> toPage() {
        return new MongoPage<>(getPage(), getPageSize());
    }
}
