package com.max.hr_user.repositories;

import com.max.hr_user.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {
}
