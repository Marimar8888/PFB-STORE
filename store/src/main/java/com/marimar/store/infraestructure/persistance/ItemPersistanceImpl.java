package com.marimar.store.infraestructure.persistance;


import com.marimar.store.infraestructure.specs.ItemSpecification;
import com.marimar.store.domain.entity.Item;
import com.marimar.store.domain.persistance.ItemPersistance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.marimar.store.infraestructure.specs.shared.*;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemPersistanceImpl implements ItemPersistance {

    private final ItemRepository itemRepository;

    public ItemPersistanceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @Override
    public List<Item> getAllItemsByCategory(Long categoryId) {
        return this.itemRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public Optional<Item> getItemById(Long itemId) {
        return this.itemRepository.findById(itemId);
    }

    @Override
    public Item saveItem(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.itemRepository.deleteById(itemId);
    }

    @Override
    public Page<Item> findAll(Pageable pageable, String filters) {
       ItemSpecification specification = new ItemSpecification(SearchCriteriaHelper.fromFilterString(filters));
        return itemRepository.findAll(specification, pageable);
    }
}