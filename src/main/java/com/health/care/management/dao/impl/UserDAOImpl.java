package com.health.care.management.dao.impl;

import static com.health.care.management.constant.Constant.SAVE_USER;
import static com.health.care.management.constant.Constant.VALIDATE_USER;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.dao.UserDAO;
import com.health.care.management.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    // Parameterized contructor to initialize the jdbc
    public UserDAOImpl() {
        super();
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    @Override
    // need to return the auto generated key refer
    // http://www.concretepage.com/spring/how-to-get-auto-generated-id-in-spring-jdbc
    public int saveUser(User user) {
        // Insert query
        // TODO create a statment n update
        int userId = 0;
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {

                // "INSERT INTO user (username, password, role) VALUES(?, ?, ?)"
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement pst = con.prepareStatement(SAVE_USER, new String[] { "user_id" });
                    pst.setString(1, user.getUserName());
                    pst.setString(2, user.getPassword());
                    pst.setString(3, user.getRole());
                    return pst;
                }
            }, keyHolder);
            userId = Math.toIntExact(keyHolder.getKey().longValue());
        } catch (DuplicateKeyException duplicateKeyException) {
            // swallow the exception and send invalid username indicator
            // 0 for invalid key
        }
        return userId;
    }

    @Override
    public User validateUser(User user) {
        // TODO Auto-generated method stub
        User userFromDB = jdbcTemplate.queryForObject(VALIDATE_USER, new Object[] { user.getUserName() }, new UserRowMapper());
        return userFromDB;
    }
    
    
    // Row mapper for user
    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));

            return user;
        }

    }

}

