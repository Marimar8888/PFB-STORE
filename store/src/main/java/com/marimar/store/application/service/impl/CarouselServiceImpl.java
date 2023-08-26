package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.CarouselDTO;
import com.marimar.store.application.mapper.CarouselMapper;
import com.marimar.store.application.service.CarouselService;
import com.marimar.store.domain.entity.Carousel;
import com.marimar.store.domain.persistance.CarouselPersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    private final CarouselPersistence carouselPersistence;
    private final CarouselMapper carouselMapper;

    public CarouselServiceImpl(CarouselPersistence carouselPersistence, CarouselMapper carouselMapper) {
        this.carouselPersistence = carouselPersistence;
        this.carouselMapper = carouselMapper;
    }

    @Override
    public List<CarouselDTO> getAllImages() {
        List<Carousel> images = this.carouselPersistence.getAllImages();
        return this.carouselMapper.toDto(images);
    }

    @Override
    public CarouselDTO saveItem(CarouselDTO carouselDTO) {
        Carousel image = this.carouselPersistence.saveImage(this.carouselMapper.toEntity(carouselDTO));
        return this.carouselMapper.toDto(image);
    }
}
