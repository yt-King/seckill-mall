package com.zufe.yt.person.infrastructure.transfer;

import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.interfaces.dto.CollectionInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import person.SeckillPersonRpc;
import product.SeckillProductRpc;

/**
 * @author yt
 * @date 2023/4/28
 * @description: TODO
 */

@Mapper
public interface CollectionMapper {
    CollectionMapper INSTANCE = Mappers.getMapper(CollectionMapper.class);

    /**
     * rpc新增入参转实体
     *
     * @param addCollectionReq 入参
     * @return Collection 实体
     */
    Collection toEntity(SeckillPersonRpc.CollectionMessage.AddCollectionReq addCollectionReq);

    /**
     * rpc删除入参转实体
     *
     * @param deleteCollectReq 入参
     * @return Collection 实体
     */
    Collection toEntity(SeckillPersonRpc.CollectionMessage.DeleteCollectReq deleteCollectReq);

    /**
     * rpc->dto
     *
     * @param simpleProduct 入参
     * @return CollectionInfoDTO 实体
     */
    CollectionInfoDTO toDTO(SeckillProductRpc.ProductMessage.SimpleProduct simpleProduct);

    /**
     * dto->rpc
     *
     * @param collectionInfoDTO 入参
     * @return Collect message
     */
    SeckillPersonRpc.CollectionMessage.Collect toMessage(CollectionInfoDTO collectionInfoDTO);
}
