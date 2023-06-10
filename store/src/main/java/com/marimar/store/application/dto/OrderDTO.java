package com.marimar.store.application.dto;

import java.io.Serializable;
import java.util.List;

public class OrderDTO implements Serializable {
    private Long id;
    private Long userId;
    private List<OrderLineDTO> orderLines;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderLineDTO> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLineDTO> orderLines) {
        this.orderLines = orderLines;
    }
}