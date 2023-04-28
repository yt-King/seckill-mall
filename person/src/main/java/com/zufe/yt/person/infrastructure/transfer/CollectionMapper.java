package com.zufe.yt.person.infrastructure.transfer;

import com.zufe.yt.person.domain.collection.entity.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import person.SeckillPersonRpc;

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
//    @Mapping(expression = "java((String)map.get(\"categoryName\"))", target = "categoryName")
    Collection toEntity(SeckillPersonRpc.CollectionMessage.AddCollectionReq addCollectionReq);

    /**
     * rpc删除入参转实体
     *
     * @param deleteCollectReq 入参
     * @return Collection 实体
     */
//    @Mapping(expression = "java((String)map.get(\"categoryName\"))", target = "categoryName")
    Collection toEntity(SeckillPersonRpc.CollectionMessage.DeleteCollectReq deleteCollectReq);
}
