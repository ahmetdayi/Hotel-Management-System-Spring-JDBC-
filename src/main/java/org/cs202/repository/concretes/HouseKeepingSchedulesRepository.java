package org.cs202.repository.concretes;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.entity.concretes.Room;
import org.cs202.repository.abstracts.IHouseKeepingSchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class HouseKeepingSchedulesRepository implements IHouseKeepingSchedulesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<HouseKeepingSchedules> findAll(){
        String sql = "SELECT * FROM houseKeepingSchedules";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(HouseKeepingSchedules.class));
    }

    public HouseKeepingSchedules save(HouseKeepingSchedules schedules){
        String sql = "INSERT INTO houseKeepingSchedules (roomId,createdUserId,houseKeepingId) VALUES ( ?,?)";
        Object[] args = {schedules.getRoom().getId(),schedules.getCreatedUser().getId(),schedules.getCreatedUser().getId()};
        int rowsAffected = jdbcTemplate.update(sql, args);
        if (rowsAffected == 1) {
            return schedules;
        } else {
            // handle error
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
