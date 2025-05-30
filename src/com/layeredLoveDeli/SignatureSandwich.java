package com.layeredLoveDeli;

import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich{
        private final String name;
        private static final double price = 12.00;
        private final List<Topping> extraToppings;

        public SignatureSandwich(String name, int sizeInches, String breadType, List<Topping> toppings, boolean toasted, List<Topping> extraToppings) {
            super(sizeInches, breadType, new ArrayList<>(toppings), toasted);
            this.name = name;
            this.extraToppings = extraToppings;
        }

        public static SignatureSandwich BLT(){
            return new SignatureSandwich("BLT", 8, "white", List.of(
                    new Topping("MEAT", "Bacon"),
                    new Topping("CHEESE", "Cheddar"),
                    new Topping("REGULAR", "Lettuce"),
                    new Topping("REGULAR", "Tomatoes"),
                    new Topping("SAUCE", "Mayo")
            ), true, new ArrayList<>());
        }

        public static SignatureSandwich PhillyCheeseSteak() {
            return new SignatureSandwich("Philly Cheese Steak", 8, "white", List.of(
                    new Topping("MEAT", "Steak"),
                    new Topping("CHEESE", "American"),
                    new Topping("REGULAR", "Onions"),
                    new Topping("REGULAR", "Peppers"),
                    new Topping("SAUCE", "Mayo")
            ), true, new ArrayList<>());
        }
        public static SignatureSandwich SpicyRomance() {
            return new SignatureSandwich("SpicyRomance", 8, "Sourdough", List.of(
                    new Topping("Chicken", "SpicyChicken"),
                    new Topping("CHEESE", "Provolone"),
                    new Topping("SIDE", "Au Jus")
            ), true, new ArrayList<>());
        }

        public List<Topping> getMutableToppings(){
            return new ArrayList<>(super.getToppings());
        }

        public List<Topping> getExtraToppings() {
            return extraToppings;
        }


        public String getName() {
            return name;
        }

        @Override
        public double getPrice() {
            double total = price;
            if (extraToppings != null) {
                for (Topping t : extraToppings) {
                    total += t.getPrice(getSizeInches());
                }
            }
            return total;
        }

        @Override
        public String toString() {
            return String.format("Special .Sandwich: %s", name);
        }
    }


