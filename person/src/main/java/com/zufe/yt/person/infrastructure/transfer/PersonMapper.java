package com.zufe.yt.person.infrastructure.transfer;

import com.zufe.yt.person.domain.person.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import person.SeckillPersonRpc;

/**
 * @author yt
 * @date 2023/4/20
 * @description: person类转换器
 */

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    /**
     * rpc新增入参转实体
     * @param createPersonReq
     * @return
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.CreatePersonReq createPersonReq);

    /**
     * rpc更新入参转实体
     * @param updatePersonReq
     * @return
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.UpdatePersonReq updatePersonReq);
}
