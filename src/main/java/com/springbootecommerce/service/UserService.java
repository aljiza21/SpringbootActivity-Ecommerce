package com.springbootecommerce.service;

import com.springbootecommerce.dto.ProductDTO;
import com.springbootecommerce.entity.Users;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void productAddPost(ProductDTO productDTO, String imgName, MultipartFile file) throws IOException;

    Users findUserByEmail(String email);
}
