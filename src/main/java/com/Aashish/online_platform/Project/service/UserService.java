package com.Aashish.online_platform.Project.service;

import java.util.List;

import com.Aashish.online_platform.Project.dto.UserDto;  
import com.Aashish.online_platform.Project.model.User;

public interface UserService {
    void saveUser(UserDto usersDto);  

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();  
}
