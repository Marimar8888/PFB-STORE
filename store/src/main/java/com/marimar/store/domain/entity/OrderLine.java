package com.marimar.store.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
@Entity
@Table(name ="orderLines")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orderLineSecuence")
    @SequenceGenerator(name = "orderLineSecuence")
    private Long id;

    @ManyToOne
    private Order order;

 /*   @ManyToOne
    private Item item;*/

    private double price;
    private int quantity;
    private double subTotal;
}
