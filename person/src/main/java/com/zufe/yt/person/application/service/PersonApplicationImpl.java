package com.zufe.yt.person.application.service;

import com.zufe.yt.person.application.PersonApplication;
import com.zufe.yt.person.domain.person.entity.Person;
import com.zufe.yt.person.domain.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yt
 * @package: com.zufe.yt.person.application.service
 * @className: PersonServiceImpl
 * @date 2023/4/20
 * @description: 用户服务实现类
 */
@Service
public class PersonApplicationImpl implements PersonApplication {

    @Resource
    private PersonRepository personRepository;

    @Override
    public void save(Person person) {
        person.valid();
        person.validExistence(personRepository);
        personRepository.saveOrUpdate(person);
    }

    @Override
    public void update(Person person) {
        person.valid();
        personRepository.saveOrUpdate(person);
    }
}
