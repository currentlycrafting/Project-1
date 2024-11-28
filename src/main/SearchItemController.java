package com.example.project_check_1_expiration;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class SearchItemController {

    @FXML
    private Button searchButton;
    @FXML
    private TextField searchNameField;
    @FXML
    private TextField searchCategoryField;
    @FXML
    private DatePicker searchStoredDatePicker;
    @FXML
    private DatePicker searchExpirationDatePicker;
    @FXML
    private Label resultLabel;

    @FXML
    public void onSearchButtonClick() {
        String name = searchNameField.getText();
        List<FoodItem> foodItemList = DataStore.getFoodItemList();

        if (foodItemList.isEmpty()) {
            resultLabel.setText("No items available to search. Add some items first!");
        }

        else {
            boolean found = false;
            for (int i = 0; i < foodItemList.size(); i++) {  // Looks for the item at Index
                FoodItem item = foodItemList.get(i);
                if (item.getName().equalsIgnoreCase(name)) {
                    resultLabel.setText("Item found: " + item.getName() + " at index: " + i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                resultLabel.setText("Item not found.");
            }
        }
    }
}
