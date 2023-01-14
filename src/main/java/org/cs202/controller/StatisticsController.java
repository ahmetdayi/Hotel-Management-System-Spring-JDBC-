package org.cs202.controller;

import org.cs202.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/statistics")
@RestController
public class StatisticsController {

    @Autowired
    private BookingService bookingService;


    @PostMapping("/room/bookings")
    public ResponseEntity<Integer> getBookingByRoomId(int roomId){
        return new ResponseEntity<>(bookingService.getBookingByRoomId(roomId), HttpStatus.OK);
    }

}
