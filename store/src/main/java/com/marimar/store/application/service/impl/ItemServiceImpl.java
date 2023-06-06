package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.ItemDTO;
import com.marimar.store.application.mapper.ItemMapper;
import com.marimar.store.application.service.ItemService;
import com.marimar.store.domain.entity.Item;
import com.marimar.store.domain.persistance.ItemPersistance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemPersistance itemPersistance;
    private final ItemMapper itemMapper;

    public ItemServiceImpl(ItemPersistance itemPersistance, ItemMapper itemMapper) {
        this.itemPersistance = itemPersistance;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> items = this.itemPersistance.getAllItems();
        return this.itemMapper.toDto(items);
    }

    @Override
    public List<ItemDTO> getAllItemsByCategory(Long categoryId) {
        List<Item> items = this.itemPersistance.getAllItemsByCategory(categoryId);
        return this.itemMapper.toDto(items);
    }

    @Override
    public Optional<ItemDTO> getItemById(Long itemId) {
        return this.itemPersistance.getItemById(itemId).map(itemMapper::toDto);
    }

    @Override
    public ItemDTO saveItem(ItemDTO itemDTO) {
        Item itemSaved = this.itemPersistance.saveItem(this.itemMapper.toEntity(itemDTO));
        return this.itemMapper.toDto(itemSaved);
    }

    @Override
    public void deleteItem(Long itemId) {
        this.itemPersistance.deleteItem(itemId);
    }

    @Override
    public Page<ItemDTO> getItemByCriteriaStringPaged(Pageable pageable, String filter) {
        Page<Item> itemPage = this.itemPersistance.findAll(pageable, filter);
        return itemPage.map(itemMapper::toDto);
    }
}
