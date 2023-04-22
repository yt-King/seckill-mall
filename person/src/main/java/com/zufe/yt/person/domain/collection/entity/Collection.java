package com.zufe.yt.person.domain.collection.entity;

import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.domain.person.entity.value
 * @className: Collection
 * @date 2023/4/12
 * @description: 用户收藏实体
 */

@Data
public class Collection {
    private String id;
    private String userId;
    private List<String> productIds;
}
