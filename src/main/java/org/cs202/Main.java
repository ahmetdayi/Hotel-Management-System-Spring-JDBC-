package org.cs202;


import org.cs202.config.ApplicationConfiguration;
import org.cs202.entity.dto.CreateRoomRequest;
import org.cs202.entity.dto.CreateUserRequest;
import org.cs202.entity.dto.UpdateUserRequest;
import org.cs202.repository.concretes.UserRepository;
import org.cs202.service.RoomService;
import org.cs202.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        UserService userService = context.getBean(UserService.class);
        UserRepository userRepository = context.getBean(UserRepository.class);
        RoomService roomService = context.getBean(RoomService.class);

        roomService.getAll();



    }
}