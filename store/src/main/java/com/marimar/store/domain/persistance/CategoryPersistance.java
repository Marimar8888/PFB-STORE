package com.marimar.store.domain.persistance;

import com.marimar.store.domain.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryPersistance {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category saveCategory(Category category);
    void deleteCategory(Long categoryId);
    List<Category> getCategoryByName(String partialName);
}