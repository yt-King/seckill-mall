package com.zufe.yt.goods;

import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.infrastructure.enums.CategoryEnum;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.util.EnumListUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest(classes = Application.class)
class GoodsApplicationTests {

    @Test
    void contextLoads() {
        String key = "categoryId";
        if (EnumListUtil.enumToListMap(CategoryEnum.class).parallelStream().map(x -> (int) x.get(key)).noneMatch(x -> 0 == x)) {
            throw new ServiceException("类目id错误", 100001);
        }
    }

    @Test
    void convertTest() {
        List<Map<String, Object>> maps = EnumListUtil.enumToListMap(CategoryEnum.class);
        List<Category> entity = CategoryMapper.INSTANCE.toEntityList(maps);
        entity.forEach(System.out::println);
    }
}
