package org.cs202.controller;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.entity.concretes.Room;
import org.cs202.entity.dto.CreateHouseKeepingSchedulesRequest;
import org.cs202.service.HouseKeepingSchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/housekeeping")
public class HouseKeepingSchedulesController {

    @Autowired
    private HouseKeepingSchedulesService houseKeepingSchedulesService;


    @PostMapping("/schedule")
    public ResponseEntity<Boolean> create(CreateHouseKeepingSchedulesRequest request){
        return new ResponseEntity<>(houseKeepingSchedulesService.create(request), HttpStatus.CREATED);
    }

    @PostMapping("/clean")
    public ResponseEntity<Boolean> clean(int roomId,int houseKeepingId,int houseKeepingScheduleId){
        return new ResponseEntity<>(houseKeepingSchedulesService.clean(roomId,houseKeepingId,houseKeepingScheduleId),HttpStatus.OK);
    }

    @PostMapping("/schedule/get")
    public ResponseEntity<List<Room>> getRooms(){
        return new ResponseEntity<>(houseKeepingSchedulesService.getRooms(),HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<HouseKeepingSchedules>> getAll(){
        return new ResponseEntity<>(houseKeepingSchedulesService.getAll(),HttpStatus.OK);
    }


}
