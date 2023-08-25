package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.Carousel;
import com.marimar.store.domain.persistance.CarouselPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarouselPersistenceImpl implements CarouselPersistence {

    private final CarouselRepository carouselRepository;
    @Autowired
    public CarouselPersistenceImpl(CarouselRepository carouselRepository) {
        this.carouselRepository = carouselRepository;
    }

    @Override
    public List<Carousel> getAllImages() {
        return this.carouselRepository.findAll();
    }

    @Override
    public Carousel saveImage(Carousel image) {
        return this.carouselRepository.save(image);
    }
}
