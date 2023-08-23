package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.BannerDTO;
import com.marimar.store.application.mapper.BannerMapper;
import com.marimar.store.application.service.BannerService;
import com.marimar.store.domain.entity.Banner;
import com.marimar.store.domain.persistance.BannerPersistance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private final BannerPersistance bannerPersistance;
    private final BannerMapper bannerMapper;

    public BannerServiceImpl(BannerPersistance bannerPersistance, BannerMapper bannerMapper) {
        this.bannerPersistance = bannerPersistance;
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<BannerDTO> getAllImages() {
        List<Banner> images = this.bannerPersistance.getAllBannerImages();
        return this.bannerMapper.toDto(images);
    }

    @Override
    public BannerDTO saveItem(BannerDTO bannerDTO) {
        Banner image = this.bannerPersistance.saveImage(this.bannerMapper.toEntity(bannerDTO));
        return this.bannerMapper.toDto(image);

    }
}
