package com.example.demo.infrastructure.specification;

public interface Specification<T> {

    boolean isSatisfiedBy(T t);

    SpecificationName getName();

}
