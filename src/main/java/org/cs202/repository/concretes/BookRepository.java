package org.cs202.repository.concretes;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.User;
import org.cs202.repository.abstracts.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

public class BookRepository implements IBookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Book> findAll(){
            String sql = "SELECT * FROM booking";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public boolean save(Book book) {
        List<Book> allBooking = findAll();
        for (Book books :
                allBooking) {
            if(books.getRoom()==book.getRoom()){
                if(book.getDayStart()==books.getDayStart()){
                    if(book.getDayEnd()==books.getDayEnd()){
                        throw new RuntimeException();
                    }
                }

            }
        }

        String sql = "INSERT INTO book (dayStart,dayEnd,price,userId,roomId) VALUES (?,?)";
        Object[] args = {book.getDayStart(),book.getDayEnd(),book.getPrice(),book.getUser().getId(),book.getRoom().getId()};
        int rowsAffected = jdbcTemplate.update(sql, args);
        return rowsAffected == 1;
    }

    @Override
    public boolean deleteById(int id) {
       try {
           String sql = "DELETE FROM booking WHERE id = ?";
           Object[] args = { id };
           jdbcTemplate.update(sql, args);
       }
       catch (Exception e){
           return false;
       }
       return true;
    }

    @Override
    public boolean updateDate(Book book) {
        try {
            String sql = "UPDATE booking SET dayStart = ?, dayEnd =? WHERE id = ?";
            Object[] args = { book.getId(),book.getDayStart(),book.getDayEnd() };
            jdbcTemplate.update(sql, args);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePrice(Book book) {
        try {
            String sql = "UPDATE booking SET price =? WHERE id = ?";
            Object[] args = { book.getId(),book.getPrice() };
            jdbcTemplate.update(sql, args);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Book getById(int id) {
        String sql = "SELECT * FROM booking WHERE id = :id";
        Map<String, Object> params = Map.of("id", id);
        RowMapper<Book> rowMapper = new BeanPropertyRowMapper<>(Book.class);
        return namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
    }
}
