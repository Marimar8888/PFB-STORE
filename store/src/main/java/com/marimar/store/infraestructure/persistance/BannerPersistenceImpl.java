package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Banner;
import com.marimar.store.domain.persistance.BannerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerPersistenceImpl implements BannerPersistence {

    private final BannerRepository bannerRpository;
    @Autowired
    public BannerPersistenceImpl(BannerRepository bannerRpository) {
        this.bannerRpository = bannerRpository;
    }

    @Override
    public List<Banner> getAllBannerImages() {
        return this.bannerRpository.findAll();
    }

    @Override
    public Banner saveImage(Banner image) {
        return this.bannerRpository.save(image);
    }
}
