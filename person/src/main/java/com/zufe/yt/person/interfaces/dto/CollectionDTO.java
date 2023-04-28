package com.zufe.yt.person.interfaces.dto;

import lombok.Data;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.interfaces.dto
 * @className: CollectionDTO
 * @date 2023/4/28
 * @description: 收藏dto
 */

@Data
public class CollectionDTO {
    private String id;
    private String userId;
    private List<String> productIds;
}
