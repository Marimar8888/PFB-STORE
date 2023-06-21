package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long>, JpaSpecificationExecutor<OrderLine> {
    List<OrderLine> getOrderLinesByOrderId(Long orderId);
    Optional<OrderLine> findByOrderIdAndId(Long orderId, Long orderLineId);
}
