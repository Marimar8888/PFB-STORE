package com.marimar.store.application.service;

import com.marimar.store.application.dto.LoginDTO;
import com.marimar.store.application.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserById(long idUser);

    UserDTO saveUser(UserDTO user);

    void deleteUser(long idUser);

    boolean UserNameExist(String userName);

    UserDTO loginAuthentication(LoginDTO loginDTO);
}
