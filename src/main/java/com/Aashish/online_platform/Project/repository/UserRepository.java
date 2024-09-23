package com.Aashish.online_platform.Project.repository;

import com.Aashish.online_platform.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

