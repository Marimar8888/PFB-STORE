package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.BannerDTO;
import com.marimar.store.application.mapper.BannerMapper;
import com.marimar.store.application.service.BannerService;
import com.marimar.store.domain.entity.Banner;
import com.marimar.store.domain.persistance.BannerPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    private final BannerPersistence bannerPersistence;
    private final BannerMapper bannerMapper;

    public BannerServiceImpl(BannerPersistence bannerPersistance, BannerMapper bannerMapper) {
        this.bannerPersistence = bannerPersistance;
        this.bannerMapper = bannerMapper;
    }

    @Override
    public List<BannerDTO> getAllImages() {
        List<Banner> images = this.bannerPersistence.getAllBannerImages();
        return this.bannerMapper.toDto(images);
    }

    @Override
    public BannerDTO saveItem(BannerDTO bannerDTO) {
        Banner image = this.bannerPersistence.saveImage(this.bannerMapper.toEntity(bannerDTO));
        return this.bannerMapper.toDto(image);

    }
}
