package com.github.kamildike.bigointellijplugin.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Category category;
    private float discount;
    private float pricePerQuantity;
    private float quantity;
    private float price;
    private String categoryName;

    public Product(String name, Category category, float discount, float quantity, float price, String categoryName) {
        this.name = name;
        this.category = category;
        this.discount = discount;
        this.quantity = quantity;
        this.price = price;
        this.categoryName = categoryName;
        this.pricePerQuantity = pricePerQuantity();
    }

    private float pricePerQuantity() {
        return price / quantity;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public float getDiscount() {
        return discount;
    }

    public float getPricePerQuantity() {
        return pricePerQuantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
