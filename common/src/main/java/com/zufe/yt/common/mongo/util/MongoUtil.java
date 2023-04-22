package com.zufe.yt.common.mongo.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.zufe.yt.common.mongo.domain.AbstractCriteriaWrapper;
import com.zufe.yt.common.mongo.domain.UpdateBuilder;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.QueryMapper;
import org.springframework.data.mongodb.core.convert.UpdateMapper;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.*;

/**
 * mongodb操作
 *
 * @author 秋玖壹
 */
@Component
public class MongoUtil {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private MongoConverter mongoConverter;

    private QueryMapper queryMapper;
    private UpdateMapper updateMapper;

    private static final String fieldId = "id";

    @PostConstruct
    public void init() {
        queryMapper = new QueryMapper(mongoConverter);
        updateMapper = new UpdateMapper(mongoConverter);
    }

    private String getCollectionName(Class<?> clazz) {
        org.springframework.data.mongodb.core.mapping.Document document = clazz.getAnnotation(org.springframework.data.mongodb.core.mapping.Document.class);
        if (document != null) {
            if (StrUtil.isNotEmpty(document.value())) {
                return document.value();
            }
            if (StrUtil.isNotEmpty(document.collection())) {
                return document.collection();
            }
        }

        return StrUtil.lowerFirst(clazz.getSimpleName());
    }

    /**
     * 插入或更新
     *
     * @param object 对象
     */
    public String insertOrUpdate(Object object) {
        String id = (String) ReflectUtil.getFieldValue(object, fieldId);
        Object objectOrg = StrUtil.isNotEmpty(id) ? mongoTemplate.findById(id, object.getClass()) : null;
        Date date = new Date();

        if (objectOrg == null) {
            // 插入
            // 去除id值
//            ReflectUtil.setFieldValue(object, fieldId, null);

            // 设置插入时间
            setCreateTime(object, (double) date.getTime());
            // 设置更新时间
            setUpdateTime(object, (double) date.getTime());
            // 设置默认值
            setDefaultValue(object);


            mongoTemplate.save(object);
            id = (String) ReflectUtil.getFieldValue(object, fieldId);
        } else {
            // 设置更新时间
            setUpdateTime(object, (double) date.getTime());
            // 更新
            Field[] fields = ReflectUtil.getFields(object.getClass());
            Update update = new Update();
            // 拷贝属性
            for (Field field : fields) {
                if (!field.getName().equals(fieldId) && ReflectUtil.getFieldValue(object, field) != null) {
                    update.set(field.getName(), ReflectUtil.getFieldValue(object, field));
                }
            }

            Query query = new Query();
            query.addCriteria(Criteria.where(fieldId).is(id));
            updateFirst(query, update, objectOrg.getClass());
        }
        return id;
    }

    /**
     * 插入
     *
     * @param object 对象
     */
    public String insert(Object object) {
        return insertOrUpdate(object);
    }

    /**
     * 批量插入
     *
     * @param <T>
     * @param list 对象
     */
    public <T> void insertAll(List<T> list) {
        Date date = new Date();
        for (Object object : list) {
            // 设置插入时间
            setCreateTime(object, (double) date.getTime());
            // 设置更新时间
            setUpdateTime(object, (double) date.getTime());

            // 设置默认值
            setDefaultValue(object);
        }

        mongoTemplate.insertAll(list);

    }

    /**
     * 根据id更新
     *
     * @param object 对象
     */
    public void updateById(Object object) {
        if (StrUtil.isEmpty((String) ReflectUtil.getFieldValue(object, fieldId))) {
            return;
        }
        insertOrUpdate(object);
    }

    /**
     * 根据id更新全部字段
     *
     * @param object 对象
     */
    public void updateAllColumnById(Object object) {
        if (StrUtil.isEmpty((String) ReflectUtil.getFieldValue(object, fieldId))) {
            return;
        }
        if (findById((String) ReflectUtil.getFieldValue(object, fieldId), object.getClass()) == null) {
            return;
        }
        Date date = new Date();
        setUpdateTime(object, (double) date.getTime());

        mongoTemplate.save(object);
    }

    /**
     * 根据id删除
     *
     * @param id    对象
     * @param clazz 类
     */
    public void deleteById(Serializable id, Class<?> clazz) {
        if (id == null) {
            return;
        }
        deleteByQuery(Criteria.where(fieldId).is(id), clazz);
    }

    /**
     * 根据id删除
     *
     * @param ids   集合
     * @param clazz 类
     */
    public void deleteByIds(List<String> ids, Class<?> clazz) {

        if (ids == null || ids.size() == 0) {
            return;
        }

        deleteByQuery(Criteria.where(fieldId).in(ids), clazz);
    }

    /**
     * 根据条件删除
     *
     * @param query 查询
     * @param clazz 类
     */
    public void deleteByQuery(Query query, Class<?> clazz) {

        mongoTemplate.remove(query, clazz);
    }

    /**
     * 根据条件删除
     *
     * @param criteria 查询
     * @param clazz    类
     */
    public void deleteByQuery(Criteria criteria, Class<?> clazz) {
        deleteByQuery(new Query(criteria), clazz);
    }

    /**
     * 根据条件删除
     *
     * @param wrapper 查询
     * @param clazz   类
     */
    public void deleteByQuery(AbstractCriteriaWrapper wrapper, Class<?> clazz) {
        deleteByQuery(new Query(wrapper.build()), clazz);
    }

    /**
     * 更新查到的第一项
     *
     * @param query  查询
     * @param update 更新
     * @param clazz  类
     */
    public void updateFirst(Query query, Update update, Class<?> clazz) {

        mongoTemplate.updateFirst(query, update, clazz);
    }



    /**
     * 更新查到的第一项
     *
     * @param criteria 查询
     * @param update   更新
     * @param clazz    类
     */
    public void updateFirst(Criteria criteria, Update update, Class<?> clazz) {
        updateFirst(new Query(criteria), update, clazz);
    }

    /**
     * 更新查到的第一项
     *
     * @param wrapper 查询
     * @param update  更新
     * @param clazz   类
     */
    public void updateFirst(AbstractCriteriaWrapper wrapper, Update update, Class<?> clazz) {
        updateFirst(new Query(wrapper.build()), update, clazz);
    }

    /**
     * 累加某一个字段的数量,原子操作
     */
    public void addCountById(Serializable id, String property, Number count, Class<?> clazz) {
        Update update = new Update().inc(property, count);
        updateFirst(new Query(Criteria.where(fieldId).is(id)), update, clazz);
    }

    /**
     * 累加某一个字段的数量,原子操作
     */
    public <T, R> void addCountById(Serializable id, SerializableFunction<T, R> property, Number count, Class<?> clazz) {
        addCountById(id, ReflectionUtil.getFieldName(property), count, clazz);
    }

    /**
     * 更新查到的全部项
     *
     * @param query  查询
     * @param update 更新
     * @param clazz  类
     */
    public void updateMulti(Query query, Update update, Class<?> clazz) {

        mongoTemplate.updateMulti(query, update, clazz);
    }

    /**
     * 更新查到的全部项
     *
     * @param criteriaWrapper 查询
     * @param updateBuilder   更新
     * @param clazz    类
     */
    public void updateMulti(AbstractCriteriaWrapper criteriaWrapper, UpdateBuilder updateBuilder, Class<?> clazz) {
        Query query = new Query(criteriaWrapper.build());
        mongoTemplate.updateMulti(new Query(criteriaWrapper.build()), updateBuilder.toUpdate(), clazz);

    }

    /**
     * 更新查到的全部项
     *
     * @param criteria 查询
     * @param update   更新
     * @param clazz    类
     */
    public void updateMulti(Criteria criteria, Update update, Class<?> clazz) {
        updateMulti(new Query(criteria), update, clazz);
    }

    /**
     * 更新查到的全部项
     *
     * @param wrapper 查询
     * @param update  更新
     * @param clazz   类
     */
    public void updateMulti(AbstractCriteriaWrapper wrapper, Update update, Class<?> clazz) {
        updateMulti(new Query(wrapper.build()), update, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param query 查询
     * @param page  分页参数
     * @param clazz 类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(Query query, MongoPage<T> page, Class<T> clazz) {
        // 查询出一共的条数
        long count = mongoTemplate.count(query, clazz);
        if (page.getCurrent() > 0 && page.getLimit() > 0) {
            // 查询page
            // 从那条记录开始
            query.skip((page.getCurrent() - 1) * page.getLimit());
            // 取多少条记录
            query.limit(((Long) page.getLimit()).intValue());
        }
        if (!query.isSorted()) {
            query.with(Sort.by(Sort.Direction.DESC, fieldId));
        }

        List<T> list = mongoTemplate.find(query, clazz);

        page.setTotalSize(count);
        page.setTotalPage(page.getLimit() > 0 ? (count + page.getLimit() - 1) / page.getLimit() : 0);
        page.setRecords(list);

        return page;
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param criteria 查询
     * @param page     分页
     * @param clazz    类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(Criteria criteria, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(criteria), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param wrapper 查询
     * @param page    分页
     * @param clazz   类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(AbstractCriteriaWrapper wrapper, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(wrapper.build()), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param criteria 查询
     * @param sort     排序
     * @param clazz    类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(Criteria criteria, Sort sort, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(criteria).with(sort), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param criteria    查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(Criteria criteria, SortBuilder sortBuilder, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(criteria).with(sortBuilder.toSort()), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param wrapper     查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(AbstractCriteriaWrapper wrapper, SortBuilder sortBuilder, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(wrapper.build()).with(sortBuilder.toSort()), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param wrapper 查询
     * @param sort    排序
     * @param clazz   类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(AbstractCriteriaWrapper wrapper, Sort sort, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query(wrapper.build()).with(sort), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param page  分页
     * @param sort  排序
     * @param clazz 类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(Sort sort, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query().with(sort), page, clazz);
    }

    /**
     * 按查询条件获取MongoPage
     *
     * @param sortBuilder 排序
     * @param page        分页
     * @param clazz       类
     * @return MongoPage 分页
     */
    public <T> MongoPage<T> findMongoPage(SortBuilder sortBuilder, MongoPage<T> page, Class<T> clazz) {
        return findMongoPage(new Query().with(sortBuilder.toSort()), page, clazz);
    }

    /**
     * 获取MongoPage
     * <p>
     * <p>
     * /**
     * 根据id查找
     *
     * @param id    id
     * @param clazz 类
     * @return T 对象
     */
    public <T> T findById(Serializable id, Class<T> clazz) {
        if (id == null) {
            return null;
        }


        return mongoTemplate.findById(id, clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param query 查询
     * @param clazz 类
     * @return T 对象
     */
    public <T> T findOneByQuery(Query query, Class<T> clazz) {
        query.limit(1);

        return mongoTemplate.findOne(query, clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param <T>      类型
     * @param criteria
     * @param clazz    类
     * @return T 对象
     */
    public <T> T findOneByQuery(Criteria criteria, Class<T> clazz) {
        return findOneByQuery(new Query(criteria), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param <T>     类型
     * @param wrapper
     * @param clazz   类
     * @return T 对象
     */
    public <T> T findOneByQuery(AbstractCriteriaWrapper wrapper, Class<T> clazz) {
        return findOneByQuery(new Query(wrapper.build()), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param criteria 查询
     * @param sort     排序
     * @param clazz    类
     * @return T 对象
     */
    public <T> T findOneByQuery(Criteria criteria, Sort sort, Class<T> clazz) {
        return findOneByQuery(new Query(criteria).with(sort), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param criteria    查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return T 对象
     */
    public <T> T findOneByQuery(Criteria criteria, SortBuilder sortBuilder, Class<T> clazz) {
        return findOneByQuery(new Query(criteria).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param wrapper 查询
     * @param sort    排序
     * @param clazz   类
     * @return T 对象
     */
    public <T> T findOneByQuery(AbstractCriteriaWrapper wrapper, Sort sort, Class<T> clazz) {
        return findOneByQuery(new Query(wrapper.build()).with(sort), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param wrapper     查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return T 对象
     */
    public <T> T findOneByQuery(AbstractCriteriaWrapper wrapper, SortBuilder sortBuilder, Class<T> clazz) {
        return findOneByQuery(new Query(wrapper.build()).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param sort  查询
     * @param clazz 类
     * @return T 对象
     */
    public <T> T findOneByQuery(Sort sort, Class<T> clazz) {
        return findOneByQuery(new Query().with(sort), clazz);
    }

    /**
     * 根据条件查找单个
     *
     * @param sortBuilder 查询
     * @param clazz       类
     * @return T 对象
     */
    public <T> T findOneByQuery(SortBuilder sortBuilder, Class<T> clazz) {
        return findOneByQuery(new Query().with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>   类型
     * @param query 查询
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(Query query, Class<T> clazz) {
        if (!query.isSorted()) {
            query.with(Sort.by(Sort.Direction.DESC, fieldId));
        }

        return mongoTemplate.find(query, clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>      类型
     * @param criteria 查询
     * @param clazz    类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(Criteria criteria, Class<T> clazz) {
        return findListByQuery(new Query(criteria), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>     类型
     * @param wrapper 查询
     * @param clazz   类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(AbstractCriteriaWrapper wrapper, Class<T> clazz) {
        return findListByQuery(new Query(wrapper.build()), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>         类型
     * @param criteria    查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(Criteria criteria, SortBuilder sortBuilder, Class<T> clazz) {
        return findListByQuery(new Query(criteria).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>      类型
     * @param criteria 查询
     * @param sort     排序
     * @param clazz    类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(Criteria criteria, Sort sort, Class<T> clazz) {
        return findListByQuery(new Query(criteria).with(sort), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>         类型
     * @param wrapper     查询
     * @param sortBuilder 排序
     * @param clazz       类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(AbstractCriteriaWrapper wrapper, SortBuilder sortBuilder, Class<T> clazz) {
        return findListByQuery(new Query(wrapper.build()).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找List
     *
     * @param <T>     类型
     * @param wrapper 查询
     * @param sort    排序
     * @param clazz   类
     * @return List 列表
     */
    public <T> List<T> findListByQuery(AbstractCriteriaWrapper wrapper, Sort sort, Class<T> clazz) {
        return findListByQuery(new Query(wrapper.build()).with(sort), clazz);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param query         查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T> List<T> findPropertiesByQuery(Query query, Class<?> documentClass, String property, Class<T> propertyClass) {
        query.fields().include(property);
        List<?> list = findListByQuery(query, documentClass);

        return extractProperty(list, property, propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param query         查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T, R> List<T> findPropertiesByQuery(Query query, Class<?> documentClass, SerializableFunction<T, R> property, Class<T> propertyClass) {
        return findPropertiesByQuery(query, documentClass, ReflectionUtil.getFieldName(property), propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param query         查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public List<String> findPropertiesByQuery(Query query, Class<?> documentClass, String property) {
        return findPropertiesByQuery(query, documentClass, property, String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param query         查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public <T, R> List<String> findPropertiesByQuery(Query query, Class<?> documentClass, SerializableFunction<T, R> property) {
        return findPropertiesByQuery(query, documentClass, ReflectionUtil.getFieldName(property), String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param criteria      查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T> List<T> findPropertiesByQuery(Criteria criteria, Class<?> documentClass, String property, Class<T> propertyClass) {
        return findPropertiesByQuery(new Query(criteria), documentClass, property, propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param criteria      查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T, R> List<T> findPropertiesByQuery(Criteria criteria, Class<?> documentClass, SerializableFunction<T, R> property, Class<T> propertyClass) {
        return findPropertiesByQuery(new Query(criteria), documentClass, ReflectionUtil.getFieldName(property), propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param wrapper       查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T, R> List<T> findPropertiesByQuery(AbstractCriteriaWrapper wrapper, Class<?> documentClass, SerializableFunction<T, R> property, Class<T> propertyClass) {
        return findPropertiesByQuery(new Query(wrapper.build()), documentClass, ReflectionUtil.getFieldName(property), propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param wrapper       查询
     * @param documentClass 类
     * @param property      属性
     * @param propertyClass 属性类
     * @return List 列表
     */
    public <T> List<T> findPropertiesByQuery(AbstractCriteriaWrapper wrapper, Class<?> documentClass, String property, Class<T> propertyClass) {
        return findPropertiesByQuery(new Query(wrapper.build()), documentClass, property, propertyClass);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param criteria      查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public List<String> findPropertiesByQuery(Criteria criteria, Class<?> documentClass, String property) {
        return findPropertiesByQuery(new Query(criteria), documentClass, property, String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param criteria      查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public <T, R> List<String> findPropertiesByQuery(Criteria criteria, Class<?> documentClass, SerializableFunction<T, R> property) {
        return findPropertiesByQuery(new Query(criteria), documentClass, ReflectionUtil.getFieldName(property), String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param wrapper       查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public List<String> findPropertiesByQuery(AbstractCriteriaWrapper wrapper, Class<?> documentClass, String property) {
        return findPropertiesByQuery(new Query(wrapper.build()), documentClass, property, String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param wrapper       查询
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public <T, R> List<String> findPropertiesByQuery(AbstractCriteriaWrapper wrapper, Class<?> documentClass, SerializableFunction<T, R> property) {
        return findPropertiesByQuery(new Query(wrapper.build()), documentClass, ReflectionUtil.getFieldName(property), String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param ids      id集合
     * @param ids      类
     * @param property 属性
     * @return List 列表
     */
    public List<String> findPropertiesByIds(Collection<String> ids, Class<?> documentClass, String property) {
        return findPropertiesByQuery(Criteria.where(fieldId).in(ids), documentClass, property, String.class);
    }

    /**
     * 根据条件查找某个属性
     *
     * @param <T>           类型
     * @param ids           id集合
     * @param documentClass 类
     * @param property      属性
     * @return List 列表
     */
    public <T, R> List<String> findPropertiesByIds(Collection<String> ids, Class<?> documentClass, SerializableFunction<T, R> property) {
        return findPropertiesByIds(ids, documentClass, ReflectionUtil.getFieldName(property));
    }

    /**
     * 根据条件查找id
     *
     * @param wrapper 查询
     * @param clazz   类
     * @return String id
     */
    public Serializable findIdByQuery(AbstractCriteriaWrapper wrapper, Class<?> clazz) {
        List<String> ids = findIdsByQuery(wrapper, clazz);
        return ids.isEmpty() ? null : ids.get(0);
    }

    /**
     * 根据条件查找id
     *
     * @param query 查询
     * @param clazz 类
     * @return List 列表
     */
    public List<String> findIdsByQuery(Query query, Class<?> clazz) {
        List<String> ids = new ArrayList<>();
        query.fields().include(fieldId);

        List<?> list = mongoTemplate.find(query, clazz);
        for (Object object : list) {
            ids.add((String) ReflectUtil.getFieldValue(object, fieldId));
        }

        return ids;
    }

    /**
     * 根据条件查找id
     *
     * @param criteria 查询
     * @param clazz    类
     * @return List 列表
     */
    public List<String> findIdsByQuery(Criteria criteria, Class<?> clazz) {
        return findIdsByQuery(new Query(criteria), clazz);
    }

    /**
     * 根据条件查找id
     *
     * @param wrapper 查询
     * @param clazz   类
     * @return List 列表
     */
    public List<String> findIdsByQuery(AbstractCriteriaWrapper wrapper, Class<?> clazz) {
        return findIdsByQuery(new Query(wrapper.build()), clazz);
    }

    /**
     * 根据条件查找id
     *
     * @param criteria 查询
     * @param clazz    类
     * @return List 列表
     */
    public List<String> findIdsByQuery(Criteria criteria, Sort sort, Class<?> clazz) {
        return findIdsByQuery(new Query(criteria).with(sort), clazz);
    }

    /**
     * 根据条件查找id
     *
     * @param criteria 查询
     * @param clazz    类
     * @return List 列表
     */
    public List<String> findIdsByQuery(Criteria criteria, SortBuilder sortBuilder, Class<?> clazz) {
        return findIdsByQuery(new Query(criteria).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据条件查找id
     *
     * @param wrapper 查询
     * @param clazz   类
     * @return List 列表
     */
    public List<String> findIdsByQuery(AbstractCriteriaWrapper wrapper, Sort sort, Class<?> clazz) {
        return findIdsByQuery(new Query(wrapper.build()).with(sort), clazz);
    }

    /**
     * 根据条件查找id
     *
     * @param wrapper 查询
     * @param clazz   类
     * @return List 列表
     */
    public List<String> findIdsByQuery(AbstractCriteriaWrapper wrapper, SortBuilder sortBuilder, Class<?> clazz) {
        return findIdsByQuery(new Query(wrapper.build()).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(Collection<String> ids, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in(ids)), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(Collection<String> ids, SortBuilder sortBuilder, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in(ids)).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(Collection<String> ids, Sort sort, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in(ids)).with(sort), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(String[] ids, SortBuilder sortBuilder, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in((Object) ids)).with(sortBuilder.toSort()), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(String[] ids, Sort sort, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in((Object) ids)).with(sort), clazz);
    }

    /**
     * 根据id集合查找
     *
     * @param ids   id集合
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findListByIds(String[] ids, Class<T> clazz) {
        return findListByQuery(new Query(Criteria.where(fieldId).in((Object) ids)), clazz);
    }

    /**
     * 查询全部
     *
     * @param <T>   类型
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findAll(Class<T> clazz) {
        return findListByQuery(new Query(), clazz);
    }

    /**
     * 查询全部
     *
     * @param <T>   类型
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findAll(Sort sort, Class<T> clazz) {
        return findListByQuery(new Criteria(), sort, clazz);
    }

    /**
     * 查询全部
     *
     * @param <T>   类型
     * @param clazz 类
     * @return List 列表
     */
    public <T> List<T> findAll(SortBuilder sortBuilder, Class<T> clazz) {
        return findListByQuery(new Criteria(), sortBuilder.toSort(), clazz);
    }

    /**
     * 查找全部的id
     *
     * @param clazz 类
     * @return List 列表
     */
    public List<String> findAllIds(Class<?> clazz) {
        return findIdsByQuery(new Query(), clazz);
    }

    /**
     * 查找数量
     *
     * @param query 查询
     * @param clazz 类
     * @return Long 数量
     */
    public Long findCountByQuery(Query query, Class<?> clazz) {
        return mongoTemplate.count(query, clazz);
    }

    /**
     * 查找数量
     *
     * @param criteria 查询
     * @param clazz    类
     * @return Long 数量
     */
    public Long findCountByQuery(Criteria criteria, Class<?> clazz) {
        return findCountByQuery(new Query(criteria), clazz);
    }

    /**
     * 查找数量
     *
     * @param wrapper 查询
     * @param clazz   类
     * @return Long 数量
     */
    public Long findCountByQuery(AbstractCriteriaWrapper wrapper, Class<?> clazz) {
        return findCountByQuery(new Query(wrapper.build()), clazz);
    }

    /**
     * 查找全部数量
     *
     * @param clazz 类
     * @return Long 数量
     */
    public Long findAllCount(Class<?> clazz) {
        return findCountByQuery(new Query(), clazz);
    }

    /**
     * 获取list中对象某个属性,组成新的list
     *
     * @param list     列表
     * @param clazz    类
     * @param property 属性
     * @return List<T> 列表
     */
    private <T> List<T> extractProperty(List<?> list, String property, Class<T> clazz) {
        Set<T> rs = new HashSet<>();
        for (Object object : list) {
            Object value = ReflectUtil.getFieldValue(object, property);
            if (value != null && value.getClass().equals(clazz)) {
                rs.add((T) value);
            }
        }

        return new ArrayList<>(rs);
    }

    /**
     * 设置创建时间
     *
     * @param object 对象
     * @param date   时间
     */
    private void setCreateTime(Object object, Double date) {
        Field[] fields = ReflectUtil.getFields(object.getClass());
        for (Field field : fields) {
            // 获取注解
            if (field.isAnnotationPresent(CreateTime.class) && field.getType().equals(Double.class)) {
                ReflectUtil.setFieldValue(object, field, date);
            }
        }
    }

    /**
     * 设置更新时间
     *
     * @param object 对象
     * @param date   时间
     */
    private void setUpdateTime(Object object, Double date) {
        Field[] fields = ReflectUtil.getFields(object.getClass());
        for (Field field : fields) {
            // 获取注解
            if (field.isAnnotationPresent(UpdateTime.class) && field.getType().equals(Double.class)) {
                ReflectUtil.setFieldValue(object, field, date);
            }
        }
    }

    /**
     * 设置默认值
     *
     * @param object 对象
     */
    private void setDefaultValue(Object object) {
        BeanUtil.descForEach(object.getClass(), (prop) ->{
            Field field = prop.getField();
            if (field.isAnnotationPresent(InitValue.class)) {
                InitValue defaultValue = field.getAnnotation(InitValue.class);
                String value = defaultValue.value();

                if (prop.getValue(object) == null) {
                    prop.setValue(object, value);
                }
            }
        });
    }
}
