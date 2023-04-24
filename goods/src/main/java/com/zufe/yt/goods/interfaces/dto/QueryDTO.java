package com.zufe.yt.goods.interfaces.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.goods.interfaces.dto
 * @className: QueryDTO
 * @date 2023/4/23
 * @description: TODO
 */

@Data
public class QueryDTO {
    /**
     * 类目id
     */
    List<Integer> categoryId;
    /**
     * 搜索条件
     */
    String search;
    /**
     * 当前页
     */
    Integer currentPage;
    /**
     * 条数
     */
    Integer pageSize;
}
