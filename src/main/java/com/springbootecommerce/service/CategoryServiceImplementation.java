package com.springbootecommerce.service;

import com.springbootecommerce.entity.Category;
import com.springbootecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

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
