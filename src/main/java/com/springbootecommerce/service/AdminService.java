package com.springbootecommerce.service;

import com.springbootecommerce.dto.ProductDTO;
import com.springbootecommerce.entity.Product;

public interface AdminService {
    ProductDTO setProductFields(Product product);
}
