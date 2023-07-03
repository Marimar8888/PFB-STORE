package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.OrderLineDTO;
import com.marimar.store.domain.entity.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { OrderMapper.class, ItemMapper.class })
public interface OrderLineMapper extends EntityMapper<OrderLineDTO, OrderLine> {
    //Crea un order vacio con ese id
    @Override
    @Mapping(source = "orderId", target = "order")
    @Mapping(source = "itemId", target = "item")
    OrderLine toEntity(OrderLineDTO dto);

    @Override
    @Mapping(source = "order.id", target = "orderId")
    @Mapping(source = "item.id", target = "itemId")
    @Mapping(source = "item.name", target = "itemName")
    OrderLineDTO toDto(OrderLine entity);



}
