package com.zufe.yt.common.core.domain;


/**
 * 规范抽象实现类
 *
 * @author 秋玖壹
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

  /**
   * 检查规范是否满足
   *
   * @param t 测试对象
   * @return 是否满足规范
   */
  @Override
  public abstract boolean isSatisfiedBy(T t);

  @Override
  public Specification<T> and(final Specification<T> specification) {
    return new AndSpecification<T>(this, specification);
  }


  @Override
  public Specification<T> or(final Specification<T> specification) {
    return new OrSpecification<T>(this, specification);
  }


  @Override
  public Specification<T> not(final Specification<T> specification) {
    return new NotSpecification<T>(specification);
  }
}
