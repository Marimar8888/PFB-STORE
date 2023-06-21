package com.marimar.store.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;

@Entity
@Table(name ="orderLines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orderLineSequence")
    @SequenceGenerator(name = "orderLineSequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name= "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name="item_id", nullable = false)
    private Item item;

    @Column(nullable = false)
    @Positive
    private double price;
    @Column(nullable = false)
    @Positive
    private int quantity;
    @Column(nullable = false)
    @Positive
    private double subTotal;

    public OrderLine() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
