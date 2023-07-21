package com.marimar.store.domain.persistance;

import com.marimar.store.application.dto.OrderLineDTO;
import com.marimar.store.domain.entity.OrderLine;

import java.util.List;
import java.util.Optional;

public interface OrderLinePersistance {
    List<OrderLine> findAllByOrder_Id(Long orderId);
    OrderLine createOrderLine(OrderLine orderLine);
    void deleteOrderLine(Long oderLIneid);
    Optional<OrderLine> findByOrderIdAndId(Long orderId, Long orderLineId);
    OrderLine saveOrderLine(OrderLine orderLine);
}
