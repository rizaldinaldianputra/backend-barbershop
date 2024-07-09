package com.sinar12.barbershop.service;

import com.sinar12.barbershop.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category createOrUpdateCategory(Category category);

    void deleteCategory(Long id);
}
