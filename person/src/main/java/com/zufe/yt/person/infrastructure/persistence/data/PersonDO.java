package com.zufe.yt.person.infrastructure.persistence.data;

import com.zufe.yt.common.mongo.util.MongoBaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yt
 * @package: com.zufe.yt.person.infrastructure.persistence.data
 * @className: PersonDO
 * @date 2023/4/20
 * @description: 用户持久化对象
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Document(collection = "person")
public class PersonDO extends MongoBaseDO {
    private String userName;
    private String password;
}
