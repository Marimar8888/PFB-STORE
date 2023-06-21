package com.marimar.store.application.service;

import com.marimar.store.application.dto.OrderDTO;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDTO> getOrders();
    Optional<OrderDTO> getOrderById(Long id);
    OrderDTO createOrder(OrderDTO orderDTO);
    void deleteOrder(Long id);
}
