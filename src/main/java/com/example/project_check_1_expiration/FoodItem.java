package com.example.project_check_1_expiration;

import java.time.LocalDate;

public class FoodItem {
    private String name;

    private String category;
    private LocalDate storedDate;
    private LocalDate expirationDate;

    public FoodItem(String name, String category, LocalDate storedDate, LocalDate expirationDate) {
        this.name = name;
        this.category = category;
        this.storedDate = storedDate;
        this.expirationDate = expirationDate;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() { return category; }

    public void setCategory(String category) {this.category = category;}

    public LocalDate getStoredDate() {
        return storedDate;
    }

    public void setStoredDate(LocalDate storedDate) {
        this.storedDate = storedDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
