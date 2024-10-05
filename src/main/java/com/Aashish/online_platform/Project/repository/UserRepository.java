package com.Aashish.online_platform.Project.repository;

import com.Aashish.online_platform.Project.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}

