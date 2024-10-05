package com.Aashish.online_platform.Project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Aashish.online_platform.Project.dto.MyUserDto;  
import com.Aashish.online_platform.Project.model.RoleModel;  
import com.Aashish.online_platform.Project.model.UserModel; 
import com.Aashish.online_platform.Project.repository.RoleRepository;
import com.Aashish.online_platform.Project.repository.UserRepository;; 

@Service
public class UserMainService implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserMainService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(MyUserDto usersDto) {
        UserModel user = new UserModel();
        user.setName(usersDto.getFirstName() + " " + usersDto.getLastName());
        user.setEmail(usersDto.getEmail());
        //encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(usersDto.getPassword()));

        RoleModel role = roleRepository.findByName("ROLE_ADMIN");
        if (role == null) {
            role = checkRoleExist();
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    private RoleModel checkRoleExist() {
        RoleModel role = new RoleModel();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }

    @Override
    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<MyUserDto> findAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private MyUserDto convertEntityToDto(UserModel user) {
        MyUserDto userDto = new MyUserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
