package org.cs202.repository.concretes;

import org.cs202.entity.concretes.User;
import org.cs202.repository.abstracts.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;

public class UserRepository implements IUserRepository {
   @Autowired
    public JdbcTemplate jdbcTemplate;
@Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public User save(User user) throws Exception {
        String sql = "INSERT INTO users (name,role) VALUES (?, ?)";

        Object[] args = {user.getName(), user.getRole().toString()};
        int rowsAffected = jdbcTemplate.update(sql, args);

        if (rowsAffected == 1) {
            return user;
        } else {
            // handle error
            throw new Exception();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        Object[] args = { id };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET name = ?, role = ? WHERE id = ?";
        Object[] args = { user.getName(), user.getRole().toString(), user.getId() };
         jdbcTemplate.update(sql, args);
    }

    public User getById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        Map<String, Object> params = Map.of("id", id);
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }
}
