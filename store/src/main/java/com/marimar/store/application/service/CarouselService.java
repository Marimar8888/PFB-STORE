package com.marimar.store.application.service;

import com.marimar.store.application.dto.CarouselDTO;

import java.util.List;

public interface CarouselService {
    List<CarouselDTO> getAllImages();
    CarouselDTO saveItem(CarouselDTO carouselDTO);
}
