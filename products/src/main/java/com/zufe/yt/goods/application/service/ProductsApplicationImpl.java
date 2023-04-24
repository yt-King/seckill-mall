package com.zufe.yt.goods.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.goods.application.ProductsApplication;
import com.zufe.yt.goods.domain.category.entity.Category;
import com.zufe.yt.goods.domain.product.entity.Product;
import com.zufe.yt.goods.domain.product.repository.ProductsRepository;
import com.zufe.yt.goods.infrastructure.enums.CategoryEnum;
import com.zufe.yt.goods.infrastructure.transfer.CategoryMapper;
import com.zufe.yt.goods.infrastructure.util.EnumListUtil;
import com.zufe.yt.goods.interfaces.dto.CacheQueryDTO;
import com.zufe.yt.goods.interfaces.dto.QueryDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yt
 * @package: com.zufe.yt.goods.application.service
 * @className: ProductsApplicationImpl
 * @date 2023/4/23
 * @description: TODO
 */

@Service
public class ProductsApplicationImpl implements ProductsApplication {

    @Resource
    ProductsRepository productsRepository;

    @Override
    public void saveOrUpdate(Product product) {
        product.valid();
        //id为空表示更新，校验一遍是否存在
        if (StrUtil.isBlank(product.getId())) {
            product.validExistence(productsRepository);
        }
        productsRepository.saveOrUpdate(product);
    }

    @Override
    public void delete(CacheQueryDTO queryDTO) {
        productsRepository.delete(queryDTO);
    }

    @Override
    public List<Category> getCategory() {
        return CategoryMapper.INSTANCE.toEntityList(EnumListUtil.enumToListMap(CategoryEnum.class));
    }

    @Override
    public List<Product> getProductList(QueryDTO queryDTO) {
        return productsRepository.list();
    }

    @Override
    public Product getProductDetail(CacheQueryDTO queryDTO) {
        return productsRepository.findById(queryDTO);
    }

//    @Override
//    public MongoPage<SettingListDTO> page(PrizeWrap.PrizeListReq request) {
//        ActiveId activeId = new ActiveId(request.getSActiveId());
//        CriteriaAndWrapper wrapper = new CriteriaAndWrapper();
//        wrapper.eq(PrizeSettingDO::getSActiveId, activeId.getId());
//        wrapper.eq(PrizeSettingDO::getDeleteFlag, DeleteStatusEnum.SHOW.name());
//        if (StringUtils.isNotBlank(request.getName())) {
//            wrapper.like(PrizeSettingDO::getName, request.getName());
//        }
//        if (StringUtils.isNotBlank(request.getStatus())) {
//            wrapper.eq(PrizeSettingDO::getStatus, request.getStatus());
//        }
//        MongoPage<PrizeSetting> mongoPage = prizeSettingRepository.page(
//                new SortBuilder().desc(PrizeSettingDO::getCreateTime),
//                new MongoPage<>(request.getPage(), request.getPageSize()),
//                wrapper
//        );
//
//        MongoPage<SettingListDTO> page = new MongoPage<>();
//        page.setTotalPage(mongoPage.getTotalPage());
//        page.setTotalSize(mongoPage.getTotalSize());
//
//        List<SettingListDTO> list = new ArrayList<>();
//        if (CollUtil.isNotEmpty(mongoPage.getRecords())) {
//            List<PrizeSetting> prizeSettings = mongoPage.getRecords();
//            this.updateStatus(prizeSettings);
//            list.addAll(ConverterUtil.toDOList(prizeSettings, SettingListDTO.class));
//        }
//        page.setRecords(list);
//
//        return page;
//    }
}
