package com.zufe.yt.person.application;

import com.zufe.yt.person.domain.person.entity.Person;

/**
 * @author yt
 * @date 2023/4/20
 * @description: TODO
 */
public interface PersonApplication {
    /**
     * 新增
     */
    void save(Person person);
    /**
     * 更新
     */
    void update(Person person);
}
