package com.marimar.store.domain.persistance;


import com.marimar.store.domain.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderPersistance {
    List<Order> getOrders();
    Optional<Order> getOrderById(Long id);
    Order createOrder(Order order);
    void deleteOrder(Long id);
}
