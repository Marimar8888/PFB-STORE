package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
