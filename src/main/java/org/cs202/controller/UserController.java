package org.cs202.controller;

import org.cs202.entity.concretes.User;
import org.cs202.entity.dto.CreateUserRequest;
import org.cs202.entity.dto.UpdateUserRequest;
import org.cs202.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Boolean> create(CreateUserRequest request){
        return new ResponseEntity<>(userService.create(request), HttpStatus.CREATED);
    }
    @PostMapping("/modify/rename")
    public ResponseEntity<Boolean> update(UpdateUserRequest request){
        return new ResponseEntity<>(userService.update(request),HttpStatus.CREATED);
    }

    @PostMapping("/user/delete")
    public ResponseEntity<Void> deleteById(int id){
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/user/getById")
    public ResponseEntity<User> getById(int id){
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }
}
