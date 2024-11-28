package com.example.project_check_1_expiration;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static List<FoodItem> foodItemList = new ArrayList<>();

    public static void addItem(FoodItem item) {
        foodItemList.add(item);
    }

    public static List<FoodItem> getFoodItemList() {
        return new ArrayList<>(foodItemList);
    }
}

