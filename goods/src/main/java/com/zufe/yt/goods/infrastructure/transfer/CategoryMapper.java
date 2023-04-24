package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;

import java.util.List;
import java.util.Map;

/**
 * @author yt
 * @date 2023/4/23
 * @description: TODO
 */

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    /**
     * map转实体
     *
     * @param map 入参
     * @return Product 实体
     */
    @Mapping(expression = "java((int)map.get(\"categoryId\"))", target = "categoryId")
    @Mapping(expression = "java((String)map.get(\"categoryName\"))", target = "categoryName")
    Category toEntity(Map<String, Object> map);

    /**
     * 实体转message
     *
     * @param category 入参
     * @return category 实体
     */
    SeckillProductRpc.ProductMessage.Category toMessage(Category category);

    /**
     * map列表转实体列表
     *
     * @param list 入参
     * @return Product 实体
     */
    List<Category> toEntityList(List<Map<String, Object>> list);
}
