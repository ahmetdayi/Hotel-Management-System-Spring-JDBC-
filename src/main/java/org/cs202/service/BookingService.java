package org.cs202.service;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.concretes.Room;
import org.cs202.entity.dto.CreateBookRequest;
import org.cs202.entity.dto.UpdateBookRequest;
import org.cs202.repository.concretes.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean create(CreateBookRequest request){
        Book book = new Book(new Date(),2,100,roomService.getById(request.getRoomId()),userService.getById(request.getUserId()));
       return bookRepository.save(book);
    }

    public boolean updateDate(UpdateBookRequest request){
        Book book = bookRepository.getById(request.getId());
        book.setDayStart(request.getDayStart());
        book.setDayEnd(request.getDayEnd());
        return bookRepository.updateDate(book);
    }
    public boolean updatePrice(UpdateBookRequest request){
        Book book = bookRepository.getById(request.getId());
        book.setPrice(request.getPrice());
        return bookRepository.updatePrice(book);
    }
    public Book getById(int id){
       return bookRepository.getById(id);
    }

    public boolean pay(int userId,int bookId,double payPrice){
        Book book = bookRepository.getById(bookId);
        if(book.getUser().getId()==userId){
            return book.getPrice() == payPrice;
        }else {
            return false;
        }
    }

    public int getBookingByRoomId(int roomId){
        return getAll().stream().filter(book -> book.getRoom().getId() == roomId).toList().size();
    }



    public boolean deleteById(int id){
      return bookRepository.deleteById(id);
    }
}
