package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class SearchItemController {

        @FXML
        private Button searchButton;
        @FXML
        private Button removeButton;

        @FXML
        private TextField searchNameField;
        @FXML
        private TextField searchCategoryField;
        @FXML
        private DatePicker searchStoredDatePicker;
        @FXML
        private DatePicker searchExpirationDatePicker;

        @FXML
        private ProgressBar expirationProgressBar;

        @FXML
        private Label resultLabel;
        private int foundIndex = -1;

        @FXML
        public void onSearchButtonClick() {
            String name = searchNameField.getText();
            List<FoodItem> foodItemList = DataStore.getFoodItemList();

            if (foodItemList.isEmpty()) {
                resultLabel.setText("No items available to search. Add some items first!");
                foundIndex = -1;
                expirationProgressBar.setProgress(0);
            } else {
                boolean found = false;
                for (int i = 0; i < foodItemList.size(); i++) {
                    FoodItem item = foodItemList.get(i);
                    if (item.getName().equalsIgnoreCase(name)) {
                        resultLabel.setText("Item found: " + item.getName() + " at index: " + i);
                        foundIndex = i;
                        found = true;
                        removeButton.setDisable(false);

                        LocalDate expirationDate = item.getExpirationDate();
                        LocalDate storedDate = item.getStoredDate();
                        long daysUntilExpiration = ChronoUnit.DAYS.between(storedDate, expirationDate);

                        if (daysUntilExpiration > 45) {
                            expirationProgressBar.setProgress(1.0);
                            expirationProgressBar.setStyle("-fx-accent: #3498db;"); // Blue to indicate "safe"
                            resultLabel.setText("Expiration Date not near!");
                            resultLabel.setText("Days Left: " + daysUntilExpiration);

                        } else {

                            double progress = 1 - Math.min((double) daysUntilExpiration / 45.0, 1.0);
                            expirationProgressBar.setProgress(progress);

                            if (daysUntilExpiration < 45 && daysUntilExpiration >= 30) {
                                // 45-30 days: Green
                                expirationProgressBar.setStyle("-fx-accent: #2ecc71;"); // Green for not about to expire
                                resultLabel.setText("Days Left: " + daysUntilExpiration);

                            } else if (daysUntilExpiration < 30 && daysUntilExpiration >= 14) {
                                // 30-14 days: Yellow
                                expirationProgressBar.setStyle("-fx-accent: #f1c40f;"); // Yellow for almost
                                resultLabel.setText("Days Left: " + daysUntilExpiration);

                            } else if (daysUntilExpiration < 14 && daysUntilExpiration >= 0) {
                                // 13-0 days: Red
                                expirationProgressBar.setStyle("-fx-accent: #e74c3c;"); // Red for very close
                                resultLabel.setText("Days Left: " + daysUntilExpiration);

                            }
                            else {
                                expirationProgressBar.setStyle("-fx-accent: #000000;"); // Black for over 45 days
                                resultLabel.setText("Days Left: " + daysUntilExpiration);

                            }
                        }

                        break;
                    }
                }

                if (!found) {
                    resultLabel.setText("Item not found.");
                    foundIndex = -1;
                    expirationProgressBar.setProgress(0);
                }
            }
        }
    @FXML
    public void onRemoveButtonClick() {
        if (foundIndex != -1) {
            List<FoodItem> foodItemList = DataStore.getFoodItemList();
            FoodItem itemToRemove = foodItemList.get(foundIndex);
            foodItemList.remove(foundIndex);

            DataStore.saveToCSV();
            foundIndex = -1;

            resultLabel.setText("Item removed: " + itemToRemove.getName());
        } else {
            resultLabel.setText("No item found for removal.");
        }
    }
}
