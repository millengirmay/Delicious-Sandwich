package com.layeredLoveDeli;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sandwich implements ItemCost {
    private final int sizeInches;//must be 4, 8 and 12 inches
    private final String breadType;
    private final List<Topping> toppings;
    private final boolean toasted;


    public static final int SIZE_4_INCH = 4;
    public static final int SIZE_8_INCH = 8;
    public static final int SIZE_12_INCH = 12;

    //base price by size
    private static final double baseFourInches = 5.50;
    private static final double baseEightInches = 7.00;
    private static final double baseTwelveInches = 8.50;

    public Sandwich(int sizeInches, String breadType, List<Topping> toppings, boolean toasted) {
        if(sizeInches != SIZE_4_INCH && sizeInches != SIZE_8_INCH && sizeInches != SIZE_12_INCH){
            throw new IllegalArgumentException(
                    "Invalid sandwich size: " + sizeInches + " (must be 4, 8 or 12 inches)");
        }
        Objects.requireNonNull(breadType, "Bread type cannot be null");
        String normalizedBread = breadType.trim().toLowerCase();
        if (!normalizedBread.equals("white") && !normalizedBread.equals("wheat")
                && !normalizedBread.equals("rye") && !normalizedBread.equals("wrap") &&
                !normalizedBread.equals("sourdough")&&!normalizedBread.equals("bagel")){
            throw new IllegalArgumentException("Bread type must be one of: white, wheat, rye, wrap, Sourdough, Bagel");
        }
        Objects.requireNonNull(toppings, "Toppings list cannot be null");
        this.sizeInches = sizeInches;
        this.breadType = breadType;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        double total = switch (sizeInches){
            case SIZE_4_INCH -> baseFourInches;
            case SIZE_8_INCH -> baseEightInches;
            case SIZE_12_INCH -> baseTwelveInches;
            default -> throw new IllegalStateException("Unexpected value: " + sizeInches);
        };
        //add topping cost
        for(Topping topping: toppings){
            total += topping.getPrice(sizeInches);
        }
        return total;
    }
    public double getBaseBreadPrice() {
        return switch (sizeInches) {
            case SIZE_4_INCH -> baseFourInches;
            case SIZE_8_INCH -> baseEightInches;
            case SIZE_12_INCH -> baseTwelveInches;
            default -> 0.0;
        };
    }

    public int getSizeInches() {
        return sizeInches;
    }

    public String getBreadType(){
        return this.breadType;
    }
    public List<Topping> getToppings(){
        return toppings;
    }
    public boolean isToasted(){
        return toasted;
    }

    @Override
    public String toString() {
        String toppingList = toppings.isEmpty()
                ? ""
                : " with " + toppings.stream()
                .map(Topping::getName)
                .collect(Collectors.joining(", "));
        String toastedSuffix = toasted ? " (toasted)" : "";
        return String.format(".Sandwich: %d\" %s bread %s %s",
                sizeInches,
                breadType,
                toppingList,
                toastedSuffix);
    }
}