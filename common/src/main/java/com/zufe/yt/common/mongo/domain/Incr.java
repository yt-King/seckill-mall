package com.zufe.yt.common.mongo.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 表示每个集合记录自增的序列
 *
 * @author 秋玖壹
 */
@Data
@Document
public class Incr {
    @Id
    private String id;
    private String collectionName;
    private Long incrId;
}
