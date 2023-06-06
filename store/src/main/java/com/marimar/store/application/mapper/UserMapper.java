package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.UserDTO;
import com.marimar.store.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
