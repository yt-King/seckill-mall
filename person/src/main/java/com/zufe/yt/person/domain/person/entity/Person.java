package com.zufe.yt.person.domain.person.entity;

import com.zufe.yt.common.core.exception.ServiceException;
import com.zufe.yt.common.mongo.domain.CriteriaAndWrapper;
import com.zufe.yt.person.domain.person.repository.PersonRepository;
import com.zufe.yt.person.infrastructure.enums.GlobalNumEnum;
import lombok.Data;

/**
 * @author yt
 * @package: com.zufe.yt.person.domain.person.entity
 * @className: Person
 * @date 2023/4/11
 * @description: 用户实体（聚合根）
 */

@Data
public class Person {
    private String id;
    private String userName;
    private String password;

    public void valid() {
        if (this.userName.isBlank() || this.password.isBlank()) {
            throw new ServiceException("用户名或密码不能为空", 100001);
        }
        if (this.userName.length() < GlobalNumEnum.USER_NAME_LENGTH.getNum()) {
            throw new ServiceException("用户名长度过短", 100001);
        }
        if (this.password.length() < GlobalNumEnum.PASSWORD_LENGTH.getNum()) {
            throw new ServiceException("用户密码长度过短", 100001);
        }
    }

    public void validExistence(PersonRepository personRepository) {
        Person find = personRepository.find(new CriteriaAndWrapper().eq(Person::getUserName, this.userName));
        if (null != find) {
            throw new ServiceException("用户已存在", 100001);
        }
    }
}
