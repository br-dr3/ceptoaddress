package com.github.brdr3.ceptoaddress.core.service;

public interface Repo<T> {
    void persist(T element);
}
