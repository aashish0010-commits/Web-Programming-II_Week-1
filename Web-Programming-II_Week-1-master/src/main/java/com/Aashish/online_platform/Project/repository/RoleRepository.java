package com.Aashish.online_platform.Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Aashish.online_platform.Project.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findByName(String name);
}