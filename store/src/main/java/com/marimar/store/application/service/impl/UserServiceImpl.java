package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.ItemDTO;
import com.marimar.store.application.dto.LoginDTO;
import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.application.mapper.ItemMapper;
import com.marimar.store.application.mapper.UserMapper;
import com.marimar.store.application.service.UserService;
import com.marimar.store.domain.entity.Item;
import com.marimar.store.domain.entity.User;
import com.marimar.store.domain.persistance.ItemPersistance;
import com.marimar.store.domain.persistance.UserPersistance;
import com.marimar.store.utils.Encrypter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserPersistance userPersistance;
    private final ItemPersistance itemPersistance;
    private final UserMapper mapper;
    private final ItemMapper itemMapper;

    public UserServiceImpl(UserPersistance userPersistance, ItemPersistance itemPersistance, UserMapper mapper, ItemMapper itemMapper) {
        this.userPersistance = userPersistance;
        this.itemPersistance = itemPersistance;
        this.mapper = mapper;
        this.itemMapper = itemMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userPersistance.getAllUsers();
        return mapper.toDto(users);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserById(long idUser) {
        return this.userPersistance.getUserById(idUser).map(mapper::toDto);
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        String password = userDTO.getPassword();
        String passwordEncrypt = Encrypter.getMD5(password);
        userDTO.setPassword(passwordEncrypt);
        User userSaved = this.userPersistance.saveUser(this.mapper.toEntity(userDTO));
        return this.mapper.toDto(userSaved);
    }

    @Override
    @Transactional
    public void deleteUser(long idUser) {
        this.userPersistance.deleteUser(idUser);
    }

    @Override
    @Transactional(readOnly = true)
    public LoginDTO loginAuthentication(LoginDTO loginDTO) {
        String userName = loginDTO.getUserName();
        List<User> userList = this.userPersistance.getUserByUserName(userName);
        User user = userList.get(0);
        String password = loginDTO.getPassword();
        String passwordEncrypt = Encrypter.getMD5(password);
        if (passwordEncrypt.equals(user.getPassword())) {
            return loginDTO;
        } else {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public boolean UserNameExist(String userName) {
        List<User> userList = this.userPersistance.getUserByUserName(userName);
        if (userList.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Long> getFavoritesByUserName(String userName) {
        List<UserDTO> userDTOList = mapper.toDto(userPersistance.getUserByUserName(userName));
        UserDTO userDTO;
        if (!userDTOList.isEmpty()) {
            userDTO = userDTOList.get(0);
            return userDTO.getFavorites().stream()
                    .map(ItemDTO::getId)
                    .collect(Collectors.toList());
        } else {
            List<Long> empty = new ArrayList<>();
            return empty;
        }
    }

    @Override
    @Transactional
    public boolean insertFavoriteByUserIdAndByItemid(String userName, Long itemId) {
        List <UserDTO> userDtoList = this.mapper.toDto(userPersistance.getUserByUserName(userName));
        if (!userDtoList.isEmpty()) {
            UserDTO userDto = userDtoList.get(0);
            Optional<Item> items = itemPersistance.getItemById(itemId);
            if (items.isPresent()) {
                Item itemNewFav = items.get();
                userDto.getFavorites().add(itemMapper.toDto(itemNewFav));
                userPersistance.saveUser(mapper.toEntity(userDto));
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteFavoriteByItemId(String userName, Long itemId) {
        List<User> userList = userPersistance.getUserByUserName(userName);
        if (!userList.isEmpty()) {
            User user = userList.get(0);
            Optional<Item> items = itemPersistance.getItemById(itemId);
            if (items.isPresent()) {
                Item itemRemoveFav = items.get();
                user.getFavorites().remove(itemRemoveFav);
                userPersistance.saveUser(user);
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserByUserName(String userName) {
        List <UserDTO> userDtoList = this.mapper.toDto(userPersistance.getUserByUserName(userName));
        if (userDtoList.isEmpty()) {
            return null;
        }else{
            UserDTO userDto = userDtoList.get(0);
            return userDto;
        }

    }

}

