package com.example.project_check_1_expiration;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortController {
    public static void sortByName(List<FoodItem> list) {
        Collections.sort(list, Comparator.comparing(FoodItem::getName));
    }

    public static void sortByStoredDate(List<FoodItem> list) {
        Collections.sort(list, Comparator.comparing(FoodItem::getStoredDate));
    }

    public static void sortByExpirationDate(List<FoodItem> list) {
        Collections.sort(list, Comparator.comparing(FoodItem::getExpirationDate));
    }
}
