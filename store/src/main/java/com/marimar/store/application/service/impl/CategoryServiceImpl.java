package com.marimar.store.application.service.impl;

import com.marimar.store.application.dto.CategoryDTO;
import com.marimar.store.application.mapper.CategoryMapper;
import com.marimar.store.application.service.CategoryService;
import com.marimar.store.domain.entity.Category;
import com.marimar.store.domain.persistance.CategoryPersistance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryPersistance categoryPersistance;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryPersistance categoryPersistance, CategoryMapper categoryMapper) {
        this.categoryPersistance = categoryPersistance;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = this.categoryPersistance.getAllCategories();
        return categoryMapper.toDto(categories);
    }

    @Override
    public Optional<CategoryDTO> getCategoryById(Long categoryId) {
        return this.categoryPersistance.getCategoryById(categoryId).map(categoryMapper::toDto);
    }

    @Override
    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = this.categoryPersistance.saveCategory(this.categoryMapper.toEntity(categoryDTO));
        return this.categoryMapper.toDto(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        this.categoryPersistance.deleteCategory(categoryId);
    }

    @Override
    public List<CategoryDTO> getAllCategoriesByName(String partialName) {
        List<Category> categories = this.categoryPersistance.getCategoryByName(partialName);
        return categoryMapper.toDto(categories);
    }
}
