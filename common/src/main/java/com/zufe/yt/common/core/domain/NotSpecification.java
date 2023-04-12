package com.zufe.yt.common.core.domain;

/**
 * 用于创建与给定规范相反(NOT)的新规范
 *
 * @author 秋玖壹
 */
public class NotSpecification<T> extends AbstractSpecification<T> {

  private final Specification<T> spec1;

  public NotSpecification(final Specification<T> spec1) {
    this.spec1 = spec1;
  }

  @Override
  public boolean isSatisfiedBy(final T t) {
    return !spec1.isSatisfiedBy(t);
  }
}
