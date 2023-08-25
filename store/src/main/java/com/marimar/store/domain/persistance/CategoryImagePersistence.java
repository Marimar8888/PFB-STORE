package com.marimar.store.domain.persistance;

import com.marimar.store.domain.entity.CategoryImage;

import java.util.List;

public interface CategoryImagePersistence {
    CategoryImage saveImage(CategoryImage entity);

    List<CategoryImage> getAllCategoryImages();
}
