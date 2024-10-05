package com.Aashish.online_platform.Project.service;

import java.util.List;

import com.Aashish.online_platform.Project.dto.MyUserDto;  
import com.Aashish.online_platform.Project.model.UserModel;

public interface UserService {
    void saveUser(MyUserDto usersDto);  

    UserModel findUserByEmail(String email);

    List<MyUserDto> findAllUsers();  
}
