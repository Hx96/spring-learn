package com.hx.ddd.infrastructure.util;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CollectionUtilHxTest {

    @Test
    public void testListPredicate() {
        List<Predicate> predicates = new ArrayList<>();
        Predicate predicate = new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                return Objects.nonNull(o);
            }
        };
        predicates.add(predicate);
        predicates.add(new Predicate() {
            @Override
            public boolean evaluate(Object o) {
                return o.equals("xx");
            }
        });
        List<Predicate> bbPredicateList = new LinkedList<Predicate>();
        bbPredicateList.add(predicate);
        Predicate biospecimenBreakdownPredicates = PredicateUtils.allPredicate(predicates);
         List<String> list = new ArrayList<>();
        list.add("xx");
        list.add("x");
        list.add("");
        list.add(null);
        System.out.println(list.size());
        CollectionUtils.filter(list, biospecimenBreakdownPredicates);
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}