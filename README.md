
# Expiration Management System

## 📚 **Overview**
Welome Friend. This is the **Expiration Management System**  A JavaFX app is designed to help users manage and track food items, 
ensuring items are safely monitored for their expiration dates and are removed when necessary. 
** DATA stored in a CSV file for persistence across application runs. **

## 🚀 **Features**
- **Search for a food item by name**: Find and display the index of the food item.
- **Remove a food item**: Delete an item from the list and the CSV file after confirming it in the search, otherwise removal isn't allowed.
- **Persistent data storage**: Save and load food items from a CSV file.
- **Simple user interface**: Built using **JavaFX** for an intuitive experience.
- **Expiration Bar**: Custom UX that shows the progression using a bar on expiration. Closer it is the redder it becomes. The further the greener.

## 💻 **Lib/Language and Imports Used**
- **Programming Language**: **Java**
- **Framework**: **JavaFX**
- **Data Storage**: **CSV file**
- **Date Handling**: **LocalDate**

## 🔧 **Project Structure**
```
com.example.project_check_1_expiration
├── AddItem.java      // Adds a food item object type to DataStore list which stores it in the CSV file
├── DataStore.java      // Handles reading/writing to the CSV file for data persistence
├── DisplayItemController.java   // Displays the Item and Sorts it by either Expiration, Stored, or Alphabetically
├── FoodItem.java       // Model class for food item attributes
├── HomeController.java      // Handles all home page buttons
├──  Main.java           // Entry point of the application
├── SearchItemController.java // Manages user interactions and UI logic
└── SortController.java           // Sorts using Collection or TimSort ( O( n log n ) ) Time complexity 
```

## 🌟 **How to Run the Project**
1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the project directory**:
   ```bash
   cd <project-directory>
   ```

3. **Build and run the application**:
   Use your Java IDE or terminal to run the `Main.java` file after ensuring that JavaFX is properly configured.

## 🛠️ **Usage Instructions**
### **Search Functionality**
- Enter the name of a food item in the **Name** field and click the **Search** button.
- If found, the item details will be displayed, and the **Remove** button will become active.

### **Remove Functionality**
- After finding an item, click the **Remove** button to delete it from the list.
- The item will be removed from both the UI and the CSV file.

## 🌱 **Future Enhancements**
- **Adding an API:** For nutrional search and auto-fill.
- **Item Detail View**: For more detail. Allows user to type in info
- **Expiration Counter & Notification System and Search**: Create a new list that shows all expired or soon to be expired items.
- **SKUS Number**: Custom Bar-Code number that allows for better search of single items instead of searching through by name
- **Advanced Data Storage**: Transition CSVs to something more robust, possibly AWS


## 📫 **Contact**
Interested in contributing? Reach out at [said0106@umn.edu].

---

⭐️ **Feel free to explore the project, give feedback, and star the repository if you find it useful! Thanks for your help!** 😊
