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
     *
     * @param createPersonReq 入参
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.CreatePersonReq createPersonReq);

    /**
     * rpc更新入参转实体
     *
     * @param updatePersonReq 入参
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.UpdatePersonReq updatePersonReq);

    /**
     * rpc判断用户是否存在入参转实体
     *
     * @param findUserNameReq 入参
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.JudgeExistenceReq findUserNameReq);

    /**
     * rpc登陆入参转实体
     *
     * @param personLoginReq 入参
     */
    Person toEntity(SeckillPersonRpc.PersonMessage.PersonLoginReq personLoginReq);
}
