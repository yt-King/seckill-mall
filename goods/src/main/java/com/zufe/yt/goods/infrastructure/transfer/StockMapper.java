package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.stock.entity.Stock;
import com.zufe.yt.goods.infrastructure.persistence.data.StockDO;
import com.zufe.yt.goods.interfaces.dto.StockDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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
    @Mapping(source = "goodsId.value", target = "goodsId")
    @Mapping(source = "totalCount.value", target = "totalCount")
    @Mapping(source = "gotCount.value", target = "gotCount")
    StockDO toDO(Stock stock);

    /**
     * dto转实体
     *
     * @param stockDTO 入参
     * @return Stock 实体
     */
    @Mapping(target = "goodsId.value", source = "goodsId")
    @Mapping(target = "totalCount.value", source = "totalCount")
    @Mapping(target = "gotCount.value", source = "gotCount")
    Stock toEntity(StockDTO stockDTO);

    /**
     * dto转实体
     *
     * @param object 入参
     * @return Stock 实体
     */
    @Mapping(target = "goodsId.value", source = "goodsId")
    @Mapping(target = "totalCount.value", source = "totalCount")
    @Mapping(target = "gotCount.value", source = "gotCount")
    Stock toEntity(Object object);
}
