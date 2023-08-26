package com.marimar.store.application.mapper;

import com.marimar.store.application.dto.BannerDTO;
import com.marimar.store.domain.entity.Banner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BannerMapper extends EntityMapper<BannerDTO, Banner>{
}
