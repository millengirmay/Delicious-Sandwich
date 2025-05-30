
![image](https://github.com/user-attachments/assets/95bf5d4d-2eae-4292-9712-2b48a60fb9b6)








*****🥪 DELI-cious Sandwich Ordering System*****


****📋 Project Overview****


The Sandwich Ordering System is a Java-based application modeling a customizable sandwich shop menu. It supports:

Different sandwich sizes (4, 8, 12 inches)

Various bread types and toppings

Signature sandwiches with fixed base prices plus extra toppings

Price calculation based on sandwich size and toppings

This modular design leverages Java OOP principles with inheritance, encapsulation, and interface implementation.




****🔑 Key Features****


Build Your Own Sandwich: Choose size, bread, toppings, and toasting options.

Signature Sandwiches: Predefined customer favorites with fixed base prices.

Add Chips & Drinks: Select flavors and sizes for sides.

Real-Time Pricing: Prices calculated dynamically based on size and toppings.

Full Receipt: Generates a detailed summary of the order.

Robust Input Validation: Guards against invalid entries for toppings, bread, and sizes.

Extensible Design: Easy to add new items, sizes, or toppings.



****🧱 Class & Interface Overview****


🔹 ItemCost (Interface)
Defines the method:

double getPrice();

Implemented by:

Sandwich

SignatureSandwich

Chips

Drink


🔹 Topping
Represents an individual sandwich topping.

Fields: String name, String category

Methods:

Validates name/category

Calculates topping price based on size and type (e.g., MEAT, CHEESE)

Used inside Sandwich


🔹 Sandwich implements ItemCost
Represents a customizable sandwich.

Fields:

int size (4, 8, 12 inches)

String breadType

List<Topping> toppings

boolean toasted

Methods:

getPrice() → base + topping prices

toString() → summary of sandwich


🔹 SignatureSandwich extends Sandwich
Represents predefined sandwiches with fixed base price.

Fields:

String name

Overrides:

getPrice() → $12 base + extra toppings

Used for customer favorites


🔹 Chips implements ItemCost
Represents a chip side item.

Fields: String flavor

Methods:

getPrice() → $1.50

toString()


🔹 Drink implements ItemCost
Represents a drink item.

Fields: String size (small, medium, large)

Methods:

getPrice():

Small → $2.00

Medium → $2.50

Large → $3.00

toString()


🔹 Order
Handles the entire customer order.

Fields: List<ItemCost> items

Methods:

addItem(ItemCost item)

double checkout() → sum of item prices

String generateReceipt() → formatted full receipt


🔹 Menu
The CLI interface that drives user interaction.

Presents sandwich, chip, and drink options.

Collects user inputs and creates corresponding objects.

Handles looped ordering and checkout flow.


🔹 Display
A utility/helper class responsible for printing messages and menus.

Clean separation of UI logic from business logic.

Used by Menu to print options, prompts, errors, and instructions.


🔹 DELIciousApp
The application entry point.

Contains the main() method.

Initializes and runs the program via the Menu class.


****📊 UML Class Diagram****


<img width="467" alt="image" src="https://github.com/user-attachments/assets/cf4b1c21-bf7e-4e07-87c1-3cf15dc3a376" />


****▶️ How to Run the App****

Clone the repository
git clone <repo_url>

Navigate to the project folder
cd DELIcious

Compile the project
javac *.java

Run the app
java DELIciousApp


****📄 Sample CLI Output****

    Welcome to Layered Love Deli!
     1. Get ready Your Own Sandwich
     2. Choose Signature Sandwich
     3. Add Chips
     4. Add Drink
     5. Checkout

    >> Sandwich (12", White, Toasted)
     + chicken, Lettuce, Mayo
    >> Chips: Sweat potato
    >> Drink: Medium

     Total: $18.50
    Thank you for visiting Layered love Deli!

    
*****📦 Future Improvements*****

GUI integration (Swing or JavaFX)

Save/load previous orders

Loyalty system with customer profiles

Receipt export to .txt or .pdf


*****Interesting Code Highlights*****

    public void checkout() {
        for (ItemCost item : items) {
            if (item instanceof SignatureSandwich special) {
            // Special sandwich handling
            } else if (item instanceof Sandwich sandwich) {
            // Regular sandwich handling
         } else {
            // Drink or chips handling
        }
     }
    }

    

****Screnshots****

<img width="943" alt="1" src="https://github.com/user-attachments/assets/41b321a9-9507-4ad1-ae28-8de603caeff4" />
<img width="950" alt="2" src="https://github.com/user-attachments/assets/196398f5-4798-43f4-8e0e-3d8c68a216b9" />
<img width="936" alt="3" src="https://github.com/user-attachments/assets/01610797-e81f-4c3a-bcf5-b16d53adf039" />
<img width="957" alt="4" src="https://github.com/user-attachments/assets/21efb293-1478-4809-8947-b82a7c33006e" />
<img width="932" alt="5" src="https://github.com/user-attachments/assets/63a8e0fc-43ae-4a76-8824-5bd0442c78d0" />
<img width="943" alt="6" src="https://github.com/user-attachments/assets/fe501ede-04b4-41cd-98b5-d998c1dbea65" />
<img width="944" alt="7" src="https://github.com/user-attachments/assets/230acd4d-44f8-40a9-a213-c5a64d9e854c" />







