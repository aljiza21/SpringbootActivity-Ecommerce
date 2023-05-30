package com.springbootecommerce.service;

import com.springbootecommerce.dto.ProductDTO;
import com.springbootecommerce.entity.Product;
import com.springbootecommerce.entity.Users;
import com.springbootecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImplementation implements UserService{

    @Value("${app.image.directory}")
    public String uploadDir;

    private CategoryService categoryService;
    private ProductService productService;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(CategoryService categoryService, ProductService productService, UserRepository userRepository) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.userRepository = userRepository;
    }
    @Override
    public void productAddPost(ProductDTO productDTO, String imgName, MultipartFile file) throws IOException {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImage_name(imageUUID);
        productService.addProduct(product);
    }

    @Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
