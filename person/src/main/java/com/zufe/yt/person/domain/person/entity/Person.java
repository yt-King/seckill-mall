package com.zufe.yt.person.domain.person.entity;

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
}
