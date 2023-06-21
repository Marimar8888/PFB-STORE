package com.marimar.store.domain.entity;
import com.marimar.store.application.dto.OrderLineDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "orderSequence")
    @SequenceGenerator(name = "orderSequence")
    private Long id;

 /*   @ManyToOne
    private User user;*/

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
