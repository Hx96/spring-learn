package com.hx.ddd.domain.repository;


public interface Identifiable<ID extends Identifier> {
    ID getId();
}