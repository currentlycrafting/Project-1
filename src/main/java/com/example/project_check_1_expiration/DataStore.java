package com.example.project_check_1_expiration;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private static final String CSV_FILE_PATH = "food_items.csv";
    private static List<FoodItem> foodItemList = new ArrayList<>();

    public static void addItem(FoodItem item) {
        foodItemList.add(item);
    }

    public static List<FoodItem> getFoodItemList() {
        return foodItemList;
    }

    public static int size() {
        return foodItemList.size();
    }

    // Save the food item list to a CSV file
    public static void saveToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE_PATH))) {
            writer.println("name,category,storedDate,expirationDate");
            for (FoodItem item : foodItemList) {
                writer.printf("%s,%s,%s,%s%n",
                        item.getName(),
                        item.getCategory(),
                        item.getStoredDate(),
                        item.getExpirationDate());
            }
        } catch (IOException e) {
            System.err.println("Error saving to CSV: " + e.getMessage());
        }
    }

    // Load the food item list from a CSV file
    public static void loadFromCSV() {
        foodItemList.clear(); // Clear Current List

        // Adds the new parts in each of their respective indices
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    String category = parts[1];
                    LocalDate storedDate = LocalDate.parse(parts[2]);
                    LocalDate expirationDate = LocalDate.parse(parts[3]);
                    foodItemList.add(new FoodItem(name, category, storedDate, expirationDate));
                }
            }

            // Error Catchers
        } catch (FileNotFoundException e) {
            System.out.println("CSV file not found. Starting with an empty list.");
        } catch (IOException e) {
            System.err.println("Error reading from CSV: " + e.getMessage());
        }
    }
}


