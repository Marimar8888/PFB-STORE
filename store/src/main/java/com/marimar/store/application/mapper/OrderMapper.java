package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.OrderDTO;
import com.marimar.store.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { OrderLineMapper.class, UserMapper.class })
public interface OrderMapper extends EntityMapper<OrderDTO, Order> {

    @Override
    @Mapping(source = "userId", target = "user")
    Order toEntity(OrderDTO dto);

    @Override
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    OrderDTO toDto(Order entity);

    //Para crear un order con el id que recibe
    default Order fromId(Long id) {
        if(id == null) return null;
        Order order = new Order();
        order.setId(id);
        return order;
    }
}
