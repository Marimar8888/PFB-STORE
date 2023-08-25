package com.marimar.store.application.service;

import com.marimar.store.application.dto.CategoryImageDTO;

import java.util.List;

public interface CategoryImageService {
    CategoryImageDTO saveItem(CategoryImageDTO categoryImageSaved);

    List<CategoryImageDTO> getAllImages();
}
