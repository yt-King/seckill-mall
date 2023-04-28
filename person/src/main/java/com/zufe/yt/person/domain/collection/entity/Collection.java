package com.zufe.yt.person.domain.collection.entity;

import com.zufe.yt.common.core.exception.ServiceException;
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

    public void Valid() {
        if (this.userId.isBlank()) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        if (this.productIds.isEmpty()) {
            throw new ServiceException("收藏商品不能为空", 100001);
        }
    }
}
