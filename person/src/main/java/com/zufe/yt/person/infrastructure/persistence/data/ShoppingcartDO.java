package com.zufe.yt.person.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import com.zufe.yt.person.domain.shoppingcart.value.ProductInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.data
 * @className: ShoppingcartDO
 * @date 2023/4/29
 * @description: TODO
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "shoppingcart")
public class ShoppingcartDO extends MongoBaseDO {
    private String userId;
    private List<ProductInfo> productInfos;
}
