package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.ItemShopDTO;
import com.marimar.store.domain.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ItemShopMapper extends EntityMapper<ItemShopDTO, Item> {
}
