package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class })
public interface UserMapper extends EntityMapper<UserDTO, User> {

    //Para crear un user con el id que recibe y con nada más
    default User fromId(Long id) {
        if(id == null) return null;
        User user = new User();
        user.setId(id);
        return user;
    }

}
