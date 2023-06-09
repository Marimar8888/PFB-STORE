package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.domain.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ItemMapper.class})
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
