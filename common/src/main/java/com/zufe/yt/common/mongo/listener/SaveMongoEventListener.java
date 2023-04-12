package com.zufe.yt.common.mongo.listener;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ReflectUtil;
import com.zufe.yt.common.mongo.domain.Incr;
import com.zufe.yt.common.mongo.util.AutoInc;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import javax.annotation.Resource;

/**
 * 对mongodb保存过程进行监听，实现主键的递增替换
 *
 * @author 秋玖壹
 **/
@Component
public class SaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 在保存的时候进行监听，通过反射对ID进行自增
     * 此时MongoDB data已经将要操作的实体类转为Document对象，
     * 所以这时候应该对document对象进行换ID
     *
     * @param event 监听器
     */
    @Override
    public void onBeforeSave(BeforeSaveEvent<Object> event) {
        // 得到操作的实体类对象
        Object source = event.getSource();
        // spring-mongo-data与MongoDB交互的document对象
        Document document = event.getDocument();
        // 利用反射进行相关操作
        ReflectionUtils.doWithFields(source.getClass(), field -> {
            // 使操作的成员可访问
            ReflectionUtils.makeAccessible(field);
            // 该字段是否使用自增注解
            Object value = ReflectUtil.getFieldValue(source, field);
            if (field.isAnnotationPresent(AutoInc.class)) {
                if (value == null || StringUtils.isBlank(value.toString())) {
                    String collectionName = source.getClass().getSimpleName().substring(0, 1).toLowerCase()
                            + source.getClass().getSimpleName().substring(1);
                    // 判断document不能为空
                    Assert.notNull(document,"event.document must not be null");
                    // 获取自增主键
                    String incrId = IdUtil.fastSimpleUUID();
                    // 对ID进行替换
                    document.put("_id", incrId);
                    field.set(source, incrId);
                }
            }
        });
        super.onBeforeSave(event);
    }

    /**
     * 返回下一个自增ID
     *
     * @param collectionName 集合名
     * @return ID
     */
    private Long getIncrId(String collectionName) {
        Query query = new Query(Criteria.where("collectionName").is(collectionName));
        Update update = new Update();
        update.inc("incrId");
        FindAndModifyOptions options = FindAndModifyOptions.options();
        //没有就新增
        options.upsert(true);
        //返回最新
        options.returnNew(true);
        Incr andModify = mongoTemplate.findAndModify(query, update, options, Incr.class);
        Assert.notNull(andModify,"主键自增时返回参数异常");
        return andModify.getIncrId();
    }
}
