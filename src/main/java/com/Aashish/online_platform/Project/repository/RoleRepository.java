package com.Aashish.online_platform.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Aashish.online_platform.Project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}