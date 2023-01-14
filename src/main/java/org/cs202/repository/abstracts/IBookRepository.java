package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.Room;

import java.util.List;

public interface IBookRepository {

    boolean save(Book book);

    List<Book> findAll();

    boolean deleteById(int id);

    boolean updateDate(Book book);

    boolean updatePrice(Book book);

    Book getById(int id);
}
