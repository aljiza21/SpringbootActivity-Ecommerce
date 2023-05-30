package com.springbootecommerce.service;

import com.springbootecommerce.dto.ProductDTO;
import com.springbootecommerce.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService{
    @Override
    public ProductDTO setProductFields(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageName(product.getImage_name());

        return productDTO;
    }
}
