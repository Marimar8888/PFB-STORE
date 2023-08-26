package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.CategoryImageDTO;
import com.marimar.store.domain.entity.CategoryImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryImageMapper extends EntityMapper<CategoryImageDTO, CategoryImage>{
}
