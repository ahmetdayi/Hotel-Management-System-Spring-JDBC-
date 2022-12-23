package org.cs202.service;


import org.cs202.entity.concretes.Room;
import org.cs202.entity.dto.CreateRoomRequest;
import org.cs202.entity.dto.UpdateRoomRequest;
import org.cs202.entity.dto.converter.RoomTypeConverter;
import org.cs202.repository.concretes.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    public RoomRepository roomRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public RoomTypeConverter roomTypeConverter;

    public List<Room> getAll(){
        return roomRepository.findAll();
    }


    public Room create(CreateRoomRequest createRoomRequest){

        if(!userService.getById(createRoomRequest.getCreatedUserId()).getRole().toString().equalsIgnoreCase("ADMINISTRATOR")){
            throw new RuntimeException("Your Role not Suitable for this");
        }

        Room room = new Room(createRoomRequest.getName(),roomTypeConverter.convert(createRoomRequest.getRoomType()),userService.getById(createRoomRequest.getCreatedUserId()));

        return roomRepository.save(room);

    }

    public void deleteRoom(int id,int callingUserId){
        if (!userService.getById(callingUserId).getRole().toString().equalsIgnoreCase("ADMINISTRATOR")){
            throw new RuntimeException("Your Role not Suitable for this");
        }
        roomRepository.deleteById(id,callingUserId);
    }

    public void updateRoom(UpdateRoomRequest updateRoomRequest){
        if(!userService.getById(updateRoomRequest.getUpdatedUser()).getRole().toString().equalsIgnoreCase("ADMINISTRATOR")){
            throw new RuntimeException("Your Role not Suitable for this");
        }
        Room room = roomRepository.getById(updateRoomRequest.getId());

        room.setName(updateRoomRequest.getName());
        room.setRoomType(roomTypeConverter.convert(updateRoomRequest.getRoomType()));

        roomRepository.update(room);

    }

    public Room getById(int id){
        return roomRepository.getById(id);
    }

}
