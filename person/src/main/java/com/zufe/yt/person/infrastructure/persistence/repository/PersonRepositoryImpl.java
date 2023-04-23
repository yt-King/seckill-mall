package com.zufe.yt.person.infrastructure.persistence.repository;

import com.zufe.yt.common.mongo.repository.impl.RepositoryImpl;
import com.zufe.yt.person.domain.person.entity.Person;
import com.zufe.yt.person.domain.person.repository.PersonRepository;
import com.zufe.yt.person.infrastructure.persistence.data.PersonDO;
import org.springframework.stereotype.Repository;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.repository
 * @className: PersonRepositoryImpl
 * @date 2023/4/20
 * @description: 用户持久化实例
 */
@Repository
public class PersonRepositoryImpl extends RepositoryImpl<Person, PersonDO> implements PersonRepository {
}
