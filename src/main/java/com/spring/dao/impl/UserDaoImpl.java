package com.spring.dao.impl;

import com.spring.Utils.UserRowMapper;
import com.spring.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl extends AbsUserDaoImpl<User, String> {
    String create = "insert into user(name,email,password) values(?,?,?)";
    String update = "update user set name=?,password=? where email=?";
    String delete = "delete from user where email=?";
    String select = "select * from user where email=?";
    String selectAll = "select * from user";

    @Override
    public Integer create(User user) {
        return getJdbcTemplate().update(create, new Object[]{user.getName(), user.getEmail(), user.getPassword()});
    }

    @Override
    public Integer update(User user, String email) {
        return getJdbcTemplate().update(update, new Object[]{user.getName(), user.getPassword(), email});
    }

    @Override
    public Boolean delete(String email) {
        Boolean data = false;
        Integer record = getJdbcTemplate().update(delete, new Object[]{email});
        if (record >= 1) {
            data = true;
        }
        return data;
    }

    @Override
    public User select(String email) {
        User user = new User();
        user = getJdbcTemplate().queryForObject(select, new Object[]{email}, new UserRowMapper());
        return user;
    }

    @Override
    public List<User> selectAll() {
        return getJdbcTemplate().query(selectAll,new UserRowMapper());
    }
}
