package com.tms.dao;

import com.tms.model.User;
import com.tms.model.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements IUserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO user(login, password, username) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, user.getLogin(), user.getPassword(), user.getUsername());
    }

    @Override
    public User getByUsername(String username) {

        String sql = "SELECT * FROM user WHERE username=?";
        return jdbcTemplate.queryForObject(sql, new UserRowMapper(), username );
    }


}
