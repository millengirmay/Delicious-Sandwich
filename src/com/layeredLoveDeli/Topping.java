package com.layeredLoveDeli;

import java.util.List;
import java.util.Map;

public class Topping {
    private final String category;
    private final String name;

    public Topping(String category, String name) {
        this.category = category.toUpperCase();
        this.name = name;
    }

    //bread option
    public static final List<String> breadOptions = List.of("WHITE", "WHEAT", "RYE", "WRAP", "SOURDOUGH", "BAGEL");

    //topping options
    public static final Map<String, List<String>> options = Map.of(
            "MEAT", List.of("Steak", "Ham", "Salami", "Pastrami", "Roast Beef", "Chicken", "Bacon"),
            "EXTRA MEAT", List.of("Steak", "Ham", "Salami", "Pastrami", "Roast Beef", "Chicken", "Bacon"),
            "CHEESE", List.of("American", "Provolone", "Cheddar", "Swiss"),
            "EXTRA CHEESE", List.of("American", "Provolone", "Cheddar", "Swiss"),
            "REGULAR", List.of("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"),
            "SAUCE", List.of("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"),
            "SIDE", List.of("Au Jus", "Sauce")
    );

    public double getPrice(int sandwichSize) {
        if (sandwichSize != 4 && sandwichSize != 8 && sandwichSize != 12) {
            throw new IllegalArgumentException("Size must be 4, 8, or 12 inches");
        }
        switch (category) {
            case "MEAT":
                return (sandwichSize == 4 ? 1.00 : sandwichSize == 8 ? 2.00 : 3.00);
            case "EXTRA MEAT":
                return (sandwichSize == 4 ? 0.50 : sandwichSize == 8 ? 1.00 : 1.50);
            case "CHEESE":
                return (sandwichSize == 4 ? 0.75 : sandwichSize == 8 ? 1.50 : 2.25);
            case "EXTRA CHEESE":
                return (sandwichSize == 4 ? 0.30 : sandwichSize == 8 ? 0.60 : 0.90);
            default:
                return 0.0;
        }
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

