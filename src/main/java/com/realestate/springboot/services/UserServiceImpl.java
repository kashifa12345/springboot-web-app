
package com.realestate.springboot.services;

import java.util.List;

import java.util.stream.Collectors;

import com.realestate.springboot.dto.UserDto;
import com.realestate.springboot.exception.ResourceNotFoundException;
import com.realestate.springboot.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;



    @Override
    public UserDto createUser(UserDto userDto) {
        User users= this.DtoToUser(userDto);
        User saveduser=this.userRepo.save(users);
        return this.UserToDto(saveduser);
    }
    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User users=this.userRepo.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("User","Id",userId));

        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setContact(userDto.getContact());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        User updateuser = this.userRepo.save(users);
        UserDto userDto1 = this.UserToDto(updateuser);
        return userDto1;

    }
    @Override
    public UserDto getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        return this.UserToDto(user);
    }
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos=users.stream().map(user-> this.UserToDto(user)).collect(Collectors.toList());

        return userDtos;
    }
    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(user);

    }
    private User DtoToUser(UserDto userDto){
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setContact(userDto.getContact());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
    private UserDto UserToDto(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(userDto.getUserId());
        userDto.setFirstName(userDto.getFirstName());
        userDto.setLastName(userDto.getLastName());
        userDto.setContact(userDto.getContact());
        userDto.setEmail(userDto.getEmail());
        userDto.setPassword(userDto.getPassword());
        return userDto;
    }

}
