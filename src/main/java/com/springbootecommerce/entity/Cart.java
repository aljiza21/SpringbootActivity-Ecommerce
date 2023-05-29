package com.springbootecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "user_id")
    private int userId;
    @Column(name ="quantity")
    private int quantity;
}
