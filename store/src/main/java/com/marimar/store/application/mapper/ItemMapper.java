package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.ItemDTO;
import com.marimar.store.domain.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ItemShopMapper.class})
public interface ItemMapper extends EntityMapper<ItemDTO, Item> {
    @Override
    @Mapping(source = "categoryId", target = "category")
    Item toEntity(ItemDTO dto);

    @Override
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    ItemDTO toDto(Item entity);

    //Para crear un item con el id que recibe y con nada más
    //Al realizar un mappeo de los orderLine para obtener información del item sacar una entidad item sin necesidad de ir a la base de datos
    default Item fromId(Long id) {
        if(id == null) return null;
        Item item = new Item();
        item.setId(id);
        return item;
    }
}
