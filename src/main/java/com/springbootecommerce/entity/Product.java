package com.springbootecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    Long id;
    @Column(name = "productName")
    String productName;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "price")
    double price;
    @Column(name = "description")
    String description;

    public Product(Long id, String productName, int quantity, double price, String description) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
    }
    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
