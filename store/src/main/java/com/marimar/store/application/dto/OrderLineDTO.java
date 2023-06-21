package com.marimar.store.application.dto;

import java.io.Serializable;
import java.util.Objects;

public class OrderLineDTO implements Serializable {

    private Long id;
    private Long orderId;
    private Long itemId;
    private String itemName;
    private Double price;
    private int quantity;
    private Double subTotal;

    public OrderLineDTO() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineDTO that = (OrderLineDTO) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(orderId, that.orderId)
                && Objects.equals(price, that.price) && Objects.equals(subTotal, that.subTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, price, quantity, subTotal);
    }

    @Override
    public String toString() {
        return "OrderLineDTO{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", price=" + price +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
