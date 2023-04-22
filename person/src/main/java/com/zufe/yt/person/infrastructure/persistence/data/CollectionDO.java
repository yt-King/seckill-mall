package com.zufe.yt.person.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.data
 * @className: CollectionDO
 * @date 2023/4/15
 * @description: 用户收藏持久化对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "collection")
public class CollectionDO extends MongoBaseDO {
    private String userId;
    private List<String> productIds;
}
