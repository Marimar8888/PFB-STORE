package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserName(String userName);
    User findOneByUserName(String userName);
}
