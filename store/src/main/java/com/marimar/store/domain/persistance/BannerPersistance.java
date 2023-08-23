package com.marimar.store.domain.persistance;

import com.marimar.store.domain.entity.Banner;

import java.util.List;

public interface BannerPersistance {
    List<Banner> getAllBannerImages();
    Banner saveImage(Banner entity);
}
