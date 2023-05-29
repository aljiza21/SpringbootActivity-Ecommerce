package com.springbootecommerce.service;

import com.springbootecommerce.entity.Category;
import com.springbootecommerce.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImplementation implements CategoryService{
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategoryById(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        return categoryRepository.findById(id);
    }
}
