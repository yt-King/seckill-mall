package com.zufe.yt.goods.interfaces.dto;

import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.goods.interfaces.dto
 * @className: QueryDTO
 * @date 2023/4/23
 * @description: 缓存条件查询dto
 */

@Data
public class CacheQueryDTO {
    String id;
    /**
     * 类目id
     */
    String categoryId;
}
