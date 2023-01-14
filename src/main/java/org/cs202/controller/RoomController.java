package org.cs202.controller;

import org.cs202.entity.concretes.Room;
import org.cs202.entity.dto.CreateRoomRequest;
import org.cs202.entity.dto.UpdateRoomRequest;
import org.cs202.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(CreateRoomRequest request){
        return new ResponseEntity<>(roomService.create(request), HttpStatus.CREATED);
    }

    @PostMapping("/modify/rename")
    public ResponseEntity<Boolean> updateRename(UpdateRoomRequest request){
        return new ResponseEntity<>(roomService.updateRename(request),HttpStatus.CREATED);

    }

    @PostMapping("/modify/change_type")
    public ResponseEntity<Boolean> updateChangeType(UpdateRoomRequest request){
        return new ResponseEntity<>(roomService.updateChangeType(request),HttpStatus.CREATED);
    }

    @PostMapping("/room/get")
    public ResponseEntity<Room> getById(int id){
        return new ResponseEntity<>(roomService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/modify/delete")
    public ResponseEntity<Boolean> deleteById(int id,int callingUserId){
        return new ResponseEntity<>(roomService.deleteRoom(id,callingUserId),HttpStatus.OK);
    }

}
