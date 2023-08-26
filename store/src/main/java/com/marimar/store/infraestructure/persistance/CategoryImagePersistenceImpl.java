package com.marimar.store.infraestructure.persistance;

import com.marimar.store.domain.entity.CategoryImage;
import com.marimar.store.domain.persistance.CategoryImagePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryImagePersistenceImpl implements CategoryImagePersistence {

    private final CategoryImageRepository categoryImageRepository;

    @Autowired
    public CategoryImagePersistenceImpl(CategoryImageRepository categoryImageRepository) {
        this.categoryImageRepository = categoryImageRepository;
    }

    @Override
    public CategoryImage saveImage(CategoryImage categoryImage) {
        return this.categoryImageRepository.save(categoryImage);
    }

    @Override
    public List<CategoryImage> getAllCategoryImages() {
        return this.categoryImageRepository.findAll();
    }
}
