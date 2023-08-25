package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.CarouselDTO;
import com.marimar.store.domain.entity.Carousel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarouselMapper extends EntityMapper<CarouselDTO, Carousel>{
}
