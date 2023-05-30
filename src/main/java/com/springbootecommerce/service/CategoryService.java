package com.springbootecommerce.service;

import com.springbootecommerce.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategory();
    void addCategory(Category category);

    void removeCategoryById(int id);

    Optional<Category> getCategoryById(int id);
}
