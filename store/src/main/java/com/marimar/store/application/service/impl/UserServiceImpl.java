package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.LoginDTO;
import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.application.mapper.UserMapper;
import com.marimar.store.application.service.UserService;
import com.marimar.store.domain.entity.User;
import com.marimar.store.domain.persistance.UserPersistance;
import com.marimar.store.utils.Encrypter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserPersistance userPersistance;
    private final UserMapper mapper;

    public UserServiceImpl(UserPersistance userPersistance, UserMapper mapper) {
        this.userPersistance = userPersistance;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userPersistance.getAllUsers();
        return mapper.toDto(users);
    }

    @Override
    public Optional<UserDTO> getUserById(long idUser) {
        return this.userPersistance.getUserById(idUser).map(mapper::toDto);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        String password = userDTO.getPassword();
        String passwordEncrypt = Encrypter.getMD5(password);
        userDTO.setPassword(passwordEncrypt);
        User userSaved = this.userPersistance.saveUser(this.mapper.toEntity(userDTO));
        return this.mapper.toDto(userSaved);
    }

    @Override
    public void deleteUser(long idUser) {
        this.userPersistance.deleteUser(idUser);
    }
    @Override
    public UserDTO loginAuthentication(LoginDTO loginDTO) {
        String userName = loginDTO.getUserName();
        User user = this.userPersistance.getUserByUserName(userName);
        String password = loginDTO.getPassword();
        String passwordEncrypt = Encrypter.getMD5(password);

        if(passwordEncrypt.equals(user.getPassword())){
            return this.mapper.toDto(user);
        }else{
            return null;
        }
    }
    @Override
    public boolean UserNameExist(String userName) {
        User usuario = this.userPersistance.getUserByUserName(userName);
        if (usuario == null){
            return false;
        }
        return true;
    }
}
