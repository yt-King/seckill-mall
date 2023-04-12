package com.zufe.yt.common.core.util;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

/**
 * 分页通用类
 *
 * @author 秋玖壹
 **/
@Data
public class BaseQuery {
    private Long page;

    private Long pageSize;

    private String id;

    private Long offset;


    public BaseQuery() {
        this.page = 1L;
        this.pageSize = 20L;
    }

    public Long getOffset() {
        if (Objects.nonNull(offset)) {
            return offset;
        }
        if (page != null) {
            if (page <= 0) {
                return 0L;
            }
            return (page - 1) * ObjectUtils.defaultIfNull(pageSize, 0L);
        }
        return 0L;
    }
}
