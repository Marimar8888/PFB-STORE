package com.marimar.store.application.service;

import com.marimar.store.application.dto.CategoryDTO;
import com.marimar.store.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    Optional<CategoryDTO> getCategoryById(Long categoryId);
    CategoryDTO saveCategory(CategoryDTO categoryDTO);
    void deleteCategory(Long categoryId);
    List<CategoryDTO> getAllCategoriesByName(String partialName);
}
