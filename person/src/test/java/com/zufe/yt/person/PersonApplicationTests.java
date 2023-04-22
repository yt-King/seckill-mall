package com.zufe.yt.person;

import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;
import com.zufe.yt.person.domain.person.entity.Person;
import com.zufe.yt.person.infrastructure.transfer.PersonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import person.SeckillPersonRpc;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
class PersonApplicationTests {
    @Resource
    CollectionRepository collectionRepository;
    @Test
    void contextLoads() {
        collectionRepository.saveOrUpdate(new Collection());
    }

    @Test
    void convertTest() {
        SeckillPersonRpc.PersonMessage.CreatePersonReq personReq = SeckillPersonRpc.PersonMessage.CreatePersonReq.newBuilder().setUserName("a").setPassword("123456").build();
        Person person = PersonMapper.INSTANCE.toEntity(personReq);
        System.out.println(person.toString());
    }
}
