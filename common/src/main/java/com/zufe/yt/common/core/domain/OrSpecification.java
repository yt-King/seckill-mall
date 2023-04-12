package com.zufe.yt.common.core.domain;

/**
 * 用于创建与给定规范或者(OR)的新规范
 *
 * @author 秋玖壹
 */
public class OrSpecification<T> extends AbstractSpecification<T> {

  private final Specification<T> spec1;
  private final Specification<T> spec2;


  public OrSpecification(final Specification<T> spec1, final Specification<T> spec2) {
    this.spec1 = spec1;
    this.spec2 = spec2;
  }

  @Override
  public boolean isSatisfiedBy(final T t) {
    return spec1.isSatisfiedBy(t) || spec2.isSatisfiedBy(t);
  }
}
