package com.zufe.yt.goods.domain.carousel;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.goods.domain.carousel
 * @className: Carousel
 * @date 2023/4/28
 * @description: 轮播图实体类
 */
@Data
@Builder
public class Carousel {
    Integer carouselId;
    String imgPath;

    private static final String PATH = "https://typora-imagehost-1308499275.cos.ap-shanghai.myqcloud.com/2023-5/%s.jpg";

    public List<Carousel> getCarousel() {
        List<Carousel> list = new ArrayList<Carousel>();
        for (int i = 1; i <= 4; i++) {
            list.add(Carousel.builder().carouselId(i).imgPath(String.format(PATH, i)).build());
        }
        return list;
    }
}
