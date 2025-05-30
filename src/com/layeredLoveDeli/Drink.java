package com.layeredLoveDeli;

import java.util.List;
import java.util.Map;

//Represents a .Drink item with size and flavor.

public class Drink implements ItemCost {

    private final String size;   // SMALL, MEDIUM, or LARGE
    private final String flavor; // e.g., COKE, SPRITE

    public Drink(String size, String flavor) {
        this.size = size.toUpperCase();      // Normalize to uppercase
        this.flavor = flavor.toUpperCase();  // Normalize to uppercase
    }

    // Available drink options by size
    public static final Map<String, List<String>> drinks = Map.of(
            "SMALL", List.of("Water", "Coke", "Diet Coke", "Sprite", "Fanta", "Dr Pepper", "Mountain Dew", "Ginger Ale"),
            "MEDIUM", List.of("Water", "Coke", "Diet Coke", "Sprite", "Fanta", "Dr Pepper", "Mountain Dew", "Ginger Ale"),
            "LARGE", List.of("Water", "Coke", "Diet Coke", "Sprite", "Fanta", "Dr Pepper", "Mountain Dew", "Ginger Ale")
    );

    @Override
    public double getPrice() {
        return switch (size) {
            case "SMALL" -> 2.00;
            case "MEDIUM" -> 2.50;
            case "LARGE" -> 3.00;
            default -> throw new IllegalArgumentException(".Drink size unavailable: " + size);
        };
    }

    @Override
    public String toString() {
        return size + " " + flavor + " drink";
    }

    public static void printDrinksBySize(String size) {
        List<String> options = drinks.get(size.toUpperCase());
        if (options == null) {
            System.out.println("No drinks available for size: " + size);
            return;
        }
        System.out.println("Available " + size.toUpperCase() + " drink options:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
    }
}
