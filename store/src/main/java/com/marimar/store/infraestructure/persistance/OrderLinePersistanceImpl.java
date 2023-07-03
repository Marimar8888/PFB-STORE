package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.OrderLine;
import com.marimar.store.domain.persistance.OrderLinePersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderLinePersistanceImpl implements OrderLinePersistance {

    private final OrderLineRepository orderLineRepository;

    @Autowired
    public OrderLinePersistanceImpl(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public List<OrderLine>  findAllByOrder_Id(Long orderId) {
        return this.orderLineRepository.getOrderLinesByOrderId(orderId);
    }

    @Override
    public OrderLine createOrderLine(OrderLine orderLine) {
        return this.orderLineRepository.save(orderLine);
    }

    @Override
    public void deleteOrderLine(Long oderLineId) {
        this.orderLineRepository.deleteById(oderLineId);
    }

    @Override
    public Optional<OrderLine> findByOrderIdAndId(Long orderId, Long orderLineId) {
        return this.orderLineRepository.findByOrderIdAndId(orderId, orderLineId);
    }

    @Override
    public OrderLine saveOrderLine(OrderLine orderLine) {
        return this.orderLineRepository.save(orderLine);
    }
}
