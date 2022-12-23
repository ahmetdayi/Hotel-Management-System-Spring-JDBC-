package org.cs202.repository.abstracts;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.Room;

import java.util.List;

public interface IBookRepository {

    Book save(Book book);

    List<Book> findAll();

    void deleteById(int id);

    void update(Book book);

    Book getById(int id);
}
