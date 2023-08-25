package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselRepository extends JpaRepository<Carousel, Long> {
}
