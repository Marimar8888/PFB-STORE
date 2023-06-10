package com.marimar.store.application.service;

import com.marimar.store.application.dto.OrderDTO;

public interface OrderService {
    OrderDTO createOrder(OrderDTO orderDTO);
}
