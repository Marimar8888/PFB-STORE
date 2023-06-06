package com.marimar.store.infraestructure.specs;


import com.marimar.store.domain.entity.Item;
import com.marimar.store.infraestructure.specs.shared.EntitySpecification;
import com.marimar.store.infraestructure.specs.shared.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public class ItemSpecification extends EntitySpecification<Item> implements Specification<Item> {


    public ItemSpecification(List<SearchCriteria> criteria) {
        this.criteria = criteria;
    }



}