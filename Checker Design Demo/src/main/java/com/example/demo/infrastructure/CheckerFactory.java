package com.example.demo.infrastructure;

import com.example.demo.infrastructure.specification.Specification;
import com.example.demo.infrastructure.specification.SpecificationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CheckerFactory<T> {

    private Map<SpecificationName, Specification<T>> specMap;

    @Autowired
    public CheckerFactory(Set<Specification<T>> specSet) {
        createSpecification(specSet);
    }

    public boolean execute(SpecificationName specificationName, T t) {
        return specMap.get(specificationName).isSatisfiedBy(t);
    }

    private void createSpecification(Set<Specification<T>> specSet) {
        specMap = new HashMap<>();
        specSet.forEach(spec -> specMap.put(spec.getName(), spec));
    }
}
