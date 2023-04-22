package com.zufe.yt.person.domain.person.repository;

import com.zufe.yt.common.mongo.repository.IRepository;
import com.zufe.yt.person.domain.person.entity.Person;
import com.zufe.yt.person.infrastructure.persistence.data.PersonDO;

/**
 * @author yt
 * @date 2023/4/20
 * @description: 用户仓储类
 */
public interface PersonRepository extends IRepository<Person, PersonDO> {
}
