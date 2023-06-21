package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Order;
import com.marimar.store.domain.persistance.OrderPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderPersistanceImpl implements OrderPersistance {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderPersistanceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Order createOrder(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        this.orderRepository.deleteById(id);
    }
}
