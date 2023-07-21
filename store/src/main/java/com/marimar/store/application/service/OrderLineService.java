package com.marimar.store.application.service;

import com.marimar.store.application.dto.OrderLineDTO;
import com.marimar.store.domain.entity.OrderLine;

import java.util.List;
import java.util.Optional;

public interface OrderLineService {

    List<OrderLineDTO> getOrderLinesByOrder(Long orderId);
    OrderLineDTO createOrderLine(Long orderId, OrderLineDTO orderLineDTO);
    Optional<OrderLineDTO> findByOrderIdAndId(Long orderId, Long orderLineId);
    OrderLineDTO saveOrderLine(OrderLineDTO orderLineDTO);
}
