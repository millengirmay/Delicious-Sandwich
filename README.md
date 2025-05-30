Project Overview
The Sandwich Ordering System is a Java-based application modeling a customizable sandwich shop menu. It supports:

Different sandwich sizes (4, 8, 12 inches)

Various bread types and toppings

Signature sandwiches with fixed base prices plus extra toppings

Price calculation based on sandwich size and toppings

This modular design leverages Java OOP principles with inheritance, encapsulation, and interface implementation.

Key Features
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

*****Interesting Code Highlights***

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
