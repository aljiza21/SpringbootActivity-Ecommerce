package com.springbootecommerce.service;

import com.springbootecommerce.dto.PriceDTO;
import com.springbootecommerce.dto.TotalCartDTO;

import java.util.List;

public interface CartService {
    void addCart(int user_id, int product_id);

    void removeProductInCart(int user_id, int product_id);

    List<TotalCartDTO[]> findAll(int user_id);

    List<PriceDTO[]> findQuantityAndPrice(int user_id);

    Double getTotalPrice(String email, UserService userService);
}
