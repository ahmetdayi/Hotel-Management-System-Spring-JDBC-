package org.cs202.controller;

import org.cs202.entity.concretes.Book;
import org.cs202.entity.dto.CreateBookRequest;
import org.cs202.entity.dto.UpdateBookRequest;
import org.cs202.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll(){
        return new ResponseEntity<>(bookingService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/make_booking")
    public ResponseEntity<Boolean> create(CreateBookRequest request){
        return new ResponseEntity<>(bookingService.create(request),HttpStatus.CREATED);
    }

    @PostMapping("/modify/change_date")
    public ResponseEntity<Boolean> updateDate(UpdateBookRequest request){
        return new ResponseEntity<>(bookingService.updateDate(request),HttpStatus.CREATED);
    }

    @PostMapping("/modify/change_price")
    public ResponseEntity<Boolean> updatePrice(UpdateBookRequest request){
        return new ResponseEntity<>(bookingService.updatePrice(request),HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<Book> getById(int id){
        return new ResponseEntity<>(bookingService.getById(id),HttpStatus.OK);

    }

    @PostMapping("/pay")
    public ResponseEntity<Boolean> pay(int userId,int bookId,double payPrice){
        return new ResponseEntity<>(bookingService.pay(userId,bookId,payPrice),HttpStatus.ACCEPTED);

    }

    @PostMapping("/cancel_booking")
    public ResponseEntity<Boolean> deleteById(int id){
        return new ResponseEntity<>(bookingService.deleteById(id),HttpStatus.OK);
    }



}
