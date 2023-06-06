package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.ItemDTO;
import com.marimar.store.domain.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ItemShopMapper extends EntityMapper<ItemDTO, Item> {
}
