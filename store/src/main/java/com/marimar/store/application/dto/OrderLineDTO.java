package com.marimar.store.application.dto;

import com.marimar.store.domain.entity.Item;
import com.marimar.store.domain.entity.Order;

import java.io.Serializable;

public class OrderLineDTO implements Serializable {

    private Long id;
    private Order order;
    private Item item;
    private Double price;
    private int quantity;
    private Double subTotal;


    public OrderLineDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
}
