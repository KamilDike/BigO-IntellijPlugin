package com.github.kamildike.bigointellijplugin.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private Category category;
    private float discount;
    private float pricePerName;
    private float quantity;
    private float price;
    private String categoryName;

    public Product(String name, Category category, float discount, float pricePerName, float quantity, float price, String categoryName) {
        this.name = name;
        this.category = category;
        this.discount = discount;
        this.pricePerName = pricePerName;
        this.quantity = quantity;
        this.price = price;
        this.categoryName = categoryName;
    }

    public float pricePerQuantity() {
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

    public float getPricePerName() {
        return pricePerName;
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
