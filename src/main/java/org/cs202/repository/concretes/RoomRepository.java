package org.cs202.repository.concretes;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.Room;
import org.cs202.entity.concretes.User;
import org.cs202.repository.abstracts.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class RoomRepository implements IRoomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public boolean save(Room room) {
        String sql = "INSERT INTO room (name,roomType,createdUserId) VALUES ( ?,?,?)";
        Object[] args = { room.getName(), room.getRoomType().toString(),room.getCreatedUser().getId()};
        int rowsAffected = jdbcTemplate.update(sql, args);
        return rowsAffected == 1;
    }

    @Override
    public List<Room> findAll() {
        String sql = "SELECT * FROM room";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Room.class));
    }

    @Override
    public boolean deleteById(int roomId,int callingUserId) {
       try {
           String sql = "DELETE FROM room WHERE id = ?";
           Object[] args = { roomId };
           jdbcTemplate.update(sql, args);
       }
       catch (Exception e){
           return false;
       }
       return true;
    }

    @Override
    public boolean updateRename(Room room) {
        try {
            String sql = "UPDATE room SET name = ? WHERE id = ?";
            Object[] args = { room.getId(), room.getName(), room.getRoomType().toString() };
            jdbcTemplate.update(sql, args);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateChangeType(Room room) {
        try {
            String sql = "UPDATE room SET roomType = ? WHERE id = ?";
            Object[] args = { room.getId(), room.getName(), room.getRoomType().toString() };
            jdbcTemplate.update(sql, args);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Room getById(int id) {
        String sql = "SELECT * FROM room WHERE id = :id";
        Map<String, Object> params = Map.of("id", id);
        RowMapper<Room> rowMapper = new BeanPropertyRowMapper<>(Room.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }


}
