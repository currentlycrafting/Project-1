package com.example.project_check_1_expiration;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static FoodItem storedFoodItem;
    public static FoodItem getStoredFoodItem() {
        return storedFoodItem;
    }
    public static void setStoredFoodItem(FoodItem foodItem) {
        storedFoodItem = foodItem;
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/project_check_1_expiration/Home.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Decay Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
