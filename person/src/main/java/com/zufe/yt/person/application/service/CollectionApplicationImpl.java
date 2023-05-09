package com.zufe.yt.person.application.service;

import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.person.application.CollectionApplication;
import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;
import com.zufe.yt.person.infrastructure.transfer.CollectionMapper;
import com.zufe.yt.person.interfaces.dto.CollectionInfoDTO;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import product.SeckillProductRpc;
import product.SeckillProductServiceGrpc;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yt
 * @package: com.zufe.yt.person.application.service
 * @className: CollectionApplicationImpl
 * @date 2023/4/28
 * @description: 收藏服务实现类
 */
@Service
public class CollectionApplicationImpl implements CollectionApplication {
    @Resource
    private CollectionRepository collectionRepository;
    @GrpcClient("products")
    SeckillProductServiceGrpc.SeckillProductServiceBlockingStub productsStub;

    @Override
    public void save(Collection collection) {
        collection.Valid();
        collectionRepository.saveOrUpdate(collection);
    }

    @Override
    public void delete(Collection collection) {
        collection.Valid();
        collectionRepository.delete(collection);
    }

    @Override
    public List<CollectionInfoDTO> getCollection(String userId) {
        if (StrUtil.isBlank(userId)) {
            throw new ServiceException("用户id不能为空", 100001);
        }
        Collection collection = collectionRepository.find(new CriteriaAndWrapper().eq(Collection::getUserId, userId));
        Map<String, SeckillProductRpc.ProductMessage.SimpleProduct> simpleProductMap =
                productsStub.getAllProducts(SeckillProductRpc.ProductMessage.GetTotalProductsReq.newBuilder().build())
                        .getProductList().parallelStream().collect(Collectors.toMap(SeckillProductRpc.ProductMessage.SimpleProduct::getId, x -> x));
        List<CollectionInfoDTO> list = new ArrayList<>();
        if (collection != null) {
            collection.getProductIds().forEach(x -> {
                list.add(CollectionMapper.INSTANCE.toDTO(simpleProductMap.get(x)));
            });
        }
        return list;
    }
}
