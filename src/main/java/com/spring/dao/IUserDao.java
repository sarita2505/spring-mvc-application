package com.spring.dao;

import java.util.List;

public interface IUserDao<T, I> {
    Integer create(T user);

    Integer update(T user, I i);

    Boolean delete(I i);

    T select(I i);

    List<T> selectAll();

}
