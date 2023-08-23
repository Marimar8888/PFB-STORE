package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRpository extends JpaRepository<Banner, Long> {
}
