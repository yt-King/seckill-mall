package com.zufe.yt.goods.infrastructure.transfer;

import com.zufe.yt.goods.domain.carousel.Carousel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import product.SeckillProductRpc;

/**
 * @author yt
 * @date 2023/4/28
 * @description: TODO
 */

@Mapper
public interface CarouselMapper {
    CarouselMapper INSTANCE = Mappers.getMapper(CarouselMapper.class);

    SeckillProductRpc.ProductMessage.Carousel toMessage(Carousel carousel);

}
