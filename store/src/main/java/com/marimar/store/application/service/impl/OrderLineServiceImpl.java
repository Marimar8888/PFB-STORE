package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.OrderLineDTO;
import com.marimar.store.application.mapper.OrderLineMapper;
import com.marimar.store.application.service.OrderLineService;
import com.marimar.store.domain.entity.OrderLine;
import com.marimar.store.domain.persistance.OrderLinePersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLinePersistance orderLinePersistance;
    private final OrderLineMapper orderLineMapper;

    @Autowired
    public OrderLineServiceImpl(OrderLinePersistance orderLinePersistance, OrderLineMapper orderLineMapper) {
        this.orderLinePersistance = orderLinePersistance;
        this.orderLineMapper = orderLineMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderLineDTO> getOrderLinesByOrder(Long orderId) {
        List<OrderLine> orderLines =  orderLinePersistance.findAllByOrder_Id(orderId);
        return  orderLineMapper.toDto(orderLines);
    }
    @Override
    @Transactional
    public OrderLineDTO createOrderLine(Long orderId, OrderLineDTO orderLineDTO) {
        orderLineDTO.setOrderId(orderId);
        OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
        orderLine = orderLinePersistance.createOrderLine(orderLine);
        return orderLineMapper.toDto(orderLine);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderLineDTO> findByOrderIdAndId(Long orderId, Long orderLineId) {
       return orderLinePersistance
                .findByOrderIdAndId(orderId, orderLineId)
                .map(orderLine -> orderLineMapper.toDto(orderLine));
    }

    @Override
    @Transactional
    public OrderLineDTO saveOrderLine(OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
        orderLine = orderLinePersistance.saveOrderLine(orderLine);
        return orderLineMapper.toDto(orderLine);
    }

}
