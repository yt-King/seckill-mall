package com.zufe.yt.person;

import com.zufe.yt.person.domain.collection.entity.Collection;
import com.zufe.yt.person.domain.collection.repository.CollectionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = com.zufe.yt.person.PersonApplication.class)
class PersonApplicationTests {
    @Resource
    CollectionRepository collectionRepository;
    @Test
    void contextLoads() {
        collectionRepository.saveOrUpdate(new Collection());
    }

}
