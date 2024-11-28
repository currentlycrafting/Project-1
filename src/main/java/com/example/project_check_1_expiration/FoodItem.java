package com.example.project_check_1_expiration;

import java.time.LocalDate;

public class FoodItem {
    private String name;
    private LocalDate storedDate;
    private LocalDate expirationDate;

    public FoodItem(String name, LocalDate storedDate, LocalDate expirationDate) {
        this.name = name;
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
