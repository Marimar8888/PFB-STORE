package com.marimar.store.application.service.impl;


import com.marimar.store.application.dto.CategoryImageDTO;
import com.marimar.store.application.mapper.CategoryImageMapper;
import com.marimar.store.application.service.CategoryImageService;
import com.marimar.store.domain.entity.CategoryImage;
import com.marimar.store.domain.persistance.CategoryImagePersistence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImageServiceImpl implements CategoryImageService {
    private final CategoryImagePersistence categoryImagePersistence;
    private final CategoryImageMapper categoryImageMapper;

    public CategoryImageServiceImpl(CategoryImagePersistence categoryImagePersistence, CategoryImageMapper categoryImageMapper) {
        this.categoryImagePersistence = categoryImagePersistence;
        this.categoryImageMapper = categoryImageMapper;
    }

    @Override
    public CategoryImageDTO saveItem(CategoryImageDTO categoryImageDTO) {
        CategoryImage image = this.categoryImagePersistence.saveImage(this.categoryImageMapper.toEntity(categoryImageDTO));
        return this.categoryImageMapper.toDto(image);
    }

    @Override
    public List<CategoryImageDTO> getAllImages() {
        List<CategoryImage> images = this.categoryImagePersistence.getAllCategoryImages();
        return this.categoryImageMapper.toDto(images);
    }
}
