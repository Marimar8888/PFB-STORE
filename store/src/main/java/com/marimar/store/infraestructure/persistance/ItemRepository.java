package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Item;
import com.marimar.store.infraestructure.specs.ItemSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    List<Item> findAllByCategoryId(Long categoryId);

}