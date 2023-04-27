package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.stock.entity.Stock;
import com.zufe.yt.goods.infrastructure.persistence.data.StockDO;
import com.zufe.yt.goods.interfaces.dto.StockDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;

import java.util.Map;

/**
 * @author yt
 * @package: com.zufe.yt.goods.infrastructure.transfer
 * @className: StockMapper
 * @date 2023/4/26
 * @description: 库存转换类
 */

@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    /**
     * 实体转持久化
     *
     * @param stock 入参
     * @return StockDO do对象
     */
    @Mapping(source = "productId.value", target = "productId")
    @Mapping(source = "totalCount.value", target = "totalCount")
    @Mapping(source = "gotCount.value", target = "gotCount")
    StockDO toDO(Stock stock);

    /**
     * dto转实体
     *
     * @param stockDTO 入参
     * @return Stock 实体
     */
    @Mapping(target = "productId.value", source = "productId")
    Stock toEntity(StockDTO stockDTO);

    /**
     * dto转实体
     *
     * @param map 入参
     * @return Stock 实体
     */
    @Mapping(expression = "java((String)map.get(\"productId\"))", target = "productId.value")
    @Mapping(expression = "java(Integer.valueOf(map.get(\"totalCount\").toString()))", target = "totalCount.value")
    @Mapping(expression = "java(Integer.valueOf(map.get(\"gotCount\").toString()))", target = "gotCount.value")
    @Mapping(expression = "java((String)map.get(\"id\"))", target = "id")
    Stock toEntity(Map<Object, Object> map);

    /**
     * message转dto
     *
     * @param incGotCountReq 入参
     * @return StockDTO dto
     */
    StockDTO toDTO(SeckillProductRpc.ProductMessage.IncGotCountReq incGotCountReq);
}
