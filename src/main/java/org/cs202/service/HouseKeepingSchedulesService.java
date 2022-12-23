package org.cs202.service;

import org.cs202.entity.concretes.HouseKeepingSchedules;
import org.cs202.entity.dto.CreateHouseKeepingSchedulesRequest;
import org.cs202.repository.concretes.HouseKeepingSchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HouseKeepingSchedulesService {

    @Autowired
    private HouseKeepingSchedulesRepository houseKeepingSchedulesRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;


    public List<HouseKeepingSchedules> getAll(){
        return houseKeepingSchedulesRepository.findAll();
    }

    public HouseKeepingSchedules create(CreateHouseKeepingSchedulesRequest schedules){
        if(!userService.getById(schedules.getCreatedUserId()).getRole().toString().equalsIgnoreCase("RECEPTIONIST")){
            throw new RuntimeException("Your Role not Suitable for this");
        }
        if(!userService.getById(schedules.getHouseKeepingId()).getRole().toString().equalsIgnoreCase("HOUSEKEEPING")){
            throw new RuntimeException("Your Role not Suitable for this");
        }
        HouseKeepingSchedules houseKeepingSchedules
                = new HouseKeepingSchedules
                (
                        roomService.getById(schedules.getRoomId()),
                        userService.getById(schedules.getCreatedUserId()),
                        userService.getById(schedules.getHouseKeepingId())
                );
        return houseKeepingSchedulesRepository.save(houseKeepingSchedules);

    }
}
