
![image](https://github.com/user-attachments/assets/3095d28a-6241-4aed-80e5-9578d8451dfc)







****Project Overview****

The Sandwich Ordering System is a Java-based application modeling a customizable sandwich shop menu. It supports:

Different sandwich sizes (4, 8, 12 inches)

Various bread types and toppings

Signature sandwiches with fixed base prices plus extra toppings

Price calculation based on sandwich size and toppings

This modular design leverages Java OOP principles with inheritance, encapsulation, and interface implementation.




****Key Features****

Sandwich customization: Select size, bread, toppings, and toasting option.


Topping pricing: Costs vary by topping category and sandwich size.


Signature sandwiches: Predefined popular sandwiches with fixed base price.


Robust validation: Ensures valid sizes, bread types, and topping categories.


Extensibility: Easily add new topping categories, bread types, or signature sandwiches.


Main Classes and Interfaces
ItemCost (interface)
Declares the method double getPrice() for calculating an item's price.

Topping
Represents a sandwich topping.

Has a category (MEAT, CHEESE, SAUCE, etc.) and a name.

Calculates topping price based on sandwich size and category.

Validates toppings against a predefined list of valid options.

Sandwich implements ItemCost
Represents a sandwich with:

Size (4, 8, or 12 inches)

Bread type (white, wheat, rye, wrap, sourdough, bagel)

List of toppings

Toasted or not

Calculates price as base price + toppings prices.

Provides a descriptive toString() method.

SignatureSandwich extends Sandwich
Represents special, named sandwiches with a fixed base price ($12).

Includes extra toppings that add to the price.

Overrides price calculation to use fixed price + extra toppings cost.



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







