package com.marimar.store.domain.persistance;

import com.marimar.store.domain.entity.Carousel;

import java.util.List;

public interface CarouselPersistence {
    List<Carousel> getAllImages();

    Carousel saveImage(Carousel entity);
}
