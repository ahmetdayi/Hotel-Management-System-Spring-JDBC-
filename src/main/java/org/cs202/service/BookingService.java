package org.cs202.service;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.dto.CreateBookRequest;
import org.cs202.repository.concretes.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Book create(CreateBookRequest request){
        Book book = new Book(new Date(),2,100,roomService.getById(request.getRoomId()),userService.getById(request.getUserId()));
       return bookRepository.save(book);
    }

    public void deleteById(int id){
      bookRepository.deleteById(id);
    }
}
