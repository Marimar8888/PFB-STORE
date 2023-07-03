package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.OrderDTO;
import com.marimar.store.application.mapper.OrderMapper;
import com.marimar.store.application.service.OrderService;
import com.marimar.store.domain.entity.Order;
import com.marimar.store.domain.persistance.OrderPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderPersistance orderPersistance;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderPersistance orderPersistance, OrderMapper orderMapper) {
        this.orderPersistance = orderPersistance;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderPersistance.getOrders();
        return orderMapper.toDto(orders);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDTO> getOrderById(Long id) {
        return orderPersistance
                .getOrderById(id)
                .map(order -> orderMapper.toDto(order));
    }

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        order = orderPersistance.createOrder(order);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        orderPersistance.deleteOrder(id);
    }
}
