package com.marimar.store.domain.persistance;

import com.marimar.store.domain.entity.User;


import java.util.List;
import java.util.Optional;

public interface UserPersistance {

    List<User> getAllUsers();
    Optional<User> getUserById(long idUser);
    User saveUser(User user);
    void deleteUser(long idUser);
    List<User> getUserByUserName(String userName);
    User getOneUserByUserName(String userName);
}
