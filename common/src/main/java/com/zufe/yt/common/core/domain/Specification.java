package com.zufe.yt.common.core.domain;

/**
 * 规范接口
 *
 * @author 秋玖壹
 **/
public interface Specification<T> {
    /**
     * 检查规范是否满足
     *
     * @param t 测试对象
     * @return 是否满足规范
     */
    boolean isSatisfiedBy(T t);

    /**
     * 创建一个新规范，当前规范和另一个规范的AND操作
     *
     * @param specification 另一个规范
     * @return specification.
     */
    Specification<T> and(Specification<T> specification);

    /**
     * 创建一个新规范，当前规范和另一个规范的OR操作
     *
     * @param specification 另一个规范
     * @return specification.
     */
    Specification<T> or(Specification<T> specification);

    /**
     * 创建一个新规范，当前规范和另一个规范的NOT操作
     *
     * @param specification 另一个规范
     * @return specification.
     */
    Specification<T> not(Specification<T> specification);
}
