package com.devicesservicemanager.DeviceServiceManager.services;

import com.devicesservicemanager.DeviceServiceManager.models.User;
import com.devicesservicemanager.DeviceServiceManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        System.out.println("Create user!!");
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
