package com.zufe.yt.common.mongo.util;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author 秋玖壹
 **/
@Data
public class MongoBaseDO {
    /**
     * 主键
     */
    @Id
    @AutoInc
    private String id;
    /**
     * 创建时间
     */
    @CreateTime
    private Double createTime;
    /**
     * 更新时间
     */
    @UpdateTime
    private Double updateTime;
}
