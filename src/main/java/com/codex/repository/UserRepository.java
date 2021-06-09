package com.codex.repository;

import com.codex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Long getIdByUsername(String username);

    User findByUsername(String username);

}
