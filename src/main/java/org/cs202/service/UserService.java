package org.cs202.service;

import org.cs202.entity.concretes.User;
import org.cs202.entity.dto.CreateUserRequest;
import org.cs202.entity.dto.UpdateUserRequest;
import org.cs202.entity.dto.converter.RoleConverter;
import org.cs202.repository.concretes.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleConverter converter;

    public User create(CreateUserRequest request) {
        User user1 = new User(request.getName(),converter.convert(request.getRole()));
        try {
            return userRepository.save(user1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id){
        try {
            User byId = userRepository.getById(id);
        }catch (Exception e){
            try {
                throw new Exception();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        userRepository.deleteById(id);
    }

    public void update(UpdateUserRequest request){
        User user = userRepository.getById(request.getId());
        user.setName(request.getName());
        user.setRole(converter.convert(request.getRole()));
        userRepository.update(user);
    }

    public User getById(int id){
        return userRepository.getById(id);
    }
}
