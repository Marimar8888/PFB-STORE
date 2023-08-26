package com.marimar.store.application.service;

import com.marimar.store.application.dto.BannerDTO;

import java.util.List;

public interface BannerService {
    List<BannerDTO> getAllImages();
    BannerDTO saveItem(BannerDTO bannerDTO);
}
