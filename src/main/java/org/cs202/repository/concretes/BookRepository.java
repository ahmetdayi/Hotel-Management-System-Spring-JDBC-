package org.cs202.repository.concretes;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.User;
import org.cs202.repository.abstracts.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class BookRepository implements IBookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Book> findAll(){
            String sql = "SELECT * FROM booking";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book save(Book book) {
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
        if (rowsAffected == 1) {
            return book;
        } else {
            // handle error
            try {
                throw new Exception();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM booking WHERE id = ?";
        Object[] args = { id };
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public Book getById(int id) {
        return null;
    }
}
