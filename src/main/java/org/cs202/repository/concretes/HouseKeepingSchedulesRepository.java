package org.cs202.repository.concretes;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.entity.concretes.Room;
import org.cs202.repository.abstracts.IHouseKeepingSchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class HouseKeepingSchedulesRepository implements IHouseKeepingSchedulesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<HouseKeepingSchedules> findAll(){
        String sql = "SELECT * FROM houseKeepingSchedules";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HouseKeepingSchedules.class));
    }
    @Override
    public boolean save(HouseKeepingSchedules schedules){
        String sql = "INSERT INTO houseKeepingSchedules (roomId,createdUserId,houseKeepingId) VALUES ( ?,?)";
        Object[] args = {schedules.getRoom().getId(),schedules.getCreatedUser().getId(),schedules.getCreatedUser().getId()};
        int rowsAffected = jdbcTemplate.update(sql, args);
        return rowsAffected == 1;
        }

    @Override
    public HouseKeepingSchedules getById(int id) {
        String sql = "SELECT * FROM room WHERE id = :id";
        Map<String, Object> params = Map.of("id", id);
        RowMapper<HouseKeepingSchedules> rowMapper = new BeanPropertyRowMapper<>(HouseKeepingSchedules.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }
    @Override
    public boolean deleteById(int id) {
        try {
            String sql = "DELETE FROM room WHERE id = ?";
            Object[] args = { id };
            jdbcTemplate.update(sql, args);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    }


