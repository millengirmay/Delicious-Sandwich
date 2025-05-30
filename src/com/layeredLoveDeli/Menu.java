package com.layeredLoveDeli;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void homeScreen() {
        boolean entered = true;
        while (entered) {
            Display.showMainMenu();
            String UserInput = scanner.nextLine();

            switch (UserInput) {
                case "1" -> StartOrder();
                case "0" -> {
                    entered = false;
                    System.out.println("\n🙏 Thank you for visiting Layered Love Deli ! Have a great day!");
                }
                default -> System.out.println("❌ Invalid option.  Please enter 1 to start or 0 to exit.");
            }
        }
    }

    public void StartOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            Display.showOrderOptions();
            System.out.println("Choose an option: ");
            String UserInput = scanner.nextLine().trim();

            switch (UserInput) {
                case "1" -> {
                    Sandwich sandwich = addSandwich();
                    if (sandwich != null) {
                        order.addItem(sandwich);
                    } else {
                        System.out.println("Sandwich not added to your order.");
                    }
                }
                case "2" -> {
                    Drink drink = addDrink();
                    if (drink != null) {
                        order.addItem(drink);
                    } else {
                        System.out.println("Drink not added to your order.");
                    }
                }
                case "3" -> {
                    Chips chips = addChips();
                    if (chips != null) {
                        order.addItem(chips);
                    } else {
                        System.out.println("Chips not added to your order.");
                    }
                }
                case "4" -> {
                    // Bag handling
                    System.out.println("Would you like a bag? (Yes/No): ");
                    String bag = scanner.nextLine().trim().toLowerCase();
                    if (bag.equals("yes")) {
                        order.requestBag();
                        System.out.println("Bag fee of $0.08 added.");
                    }
                    //Tip handling
                    System.out.println(("Would you like to leave a tip? (Yes/No): "));
                    String tipChoice = scanner.nextLine().trim().toLowerCase();
                    if (tipChoice.equals("yes")) {
                        System.out.println("Select your tip level: 1) 15%, 2) 20%, 3) 25%, or hit ENTER to skip:");
                        String tipSelection = scanner.nextLine().trim();
                        double percent;
                        switch (tipSelection) {
                            case "1" -> percent = 0.15;
                            case "2" -> percent = 0.20;
                            case "3" -> percent = 0.25;
                            default -> percent = 0.0;
                        }
                        if (percent > 0) {
                            double tip = order.getTotal() * percent;
                            order.addTip(tip);
                            System.out.printf("Tip of %.0f%% added: $%.2f%n", percent * 100, tip);
                        }
                    }
                    order.checkout();
                    ordering = false;
                }
                case "5" -> {
                    Sandwich sandwich = special();
                    if (sandwich != null) {
                        order.addItem(sandwich);
                        System.out.println("Added to order: " + sandwich + " $" + sandwich.getPrice());
                    } else {
                        System.out.println("Special sandwich not added to your order");
                    }
                }
                case "0" -> {
                    System.out.println("Order canceled. Returning to home.");
                    ordering = false;
                }
                default -> System.out.println("Invalid selection. please try again.");
            }
        }
    }

    public Sandwich addSandwich() {
        System.out.println("\n=*=*=*=*=*=*=*=*=*= Get Ready your Sandwich *=*=*=*=*=*=*=*=*=*=*=*=*=");

        // 1. Bread selection first
        String bread = null;
        while (bread == null) {
            System.out.println("\n🥖 CHOOSE YOUR BREAD TYPE");
            String chosenBread = selectFromList("Available bread options", Topping.breadOptions);
            if (chosenBread == null) {
                System.out.println("⚠️ Bread selection skipped. You must choose a bread type to continue.");
            } else if (chosenBread.equals("BACK")) {
                return null; // Exit sandwich creation
            } else {
                bread = chosenBread;
                System.out.println("✅ " + bread + " bread selected");
            }
        }

        // 2. Size selection
        int size = 0;
        while (size != 4 && size != 8 && size != 12) {
            System.out.println("\n📏 CHOOSE YOUR SANDWICH SIZE");
            System.out.println("Options: 4\", 8\", or 12\"");
            System.out.println("Enter 0 to cancel sandwich creation");
            System.out.println("Enter B to go back to bread selection");
            System.out.print("Your choice: ");

            String sizeInput = scanner.nextLine().trim();
            if (sizeInput.equals("0")) return null;
            if (sizeInput.equalsIgnoreCase("B")) {
                // Go back to bread selection
                return addSandwich(); // Restart from beginning
            }

            try {
                size = Integer.parseInt(sizeInput);
                if (size != 4 && size != 8 && size != 12) {
                    System.out.println("❌ Invalid size. Please choose 4, 8, or 12 inches.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number (4, 8, or 12)");
            }
        }
        System.out.println("✅ " + size + "\" sandwich size selected");

        // 3. Toppings selection
        System.out.println("\n🥬 CHOOSE YOUR TOPPINGS (Enter 0 to skip a category, B to go back)");
        List<Topping> toppings = new ArrayList<>();
        String[] toppingGroups = {"MEAT", "EXTRA MEAT", "CHEESE", "EXTRA CHEESE", "REGULAR", "SAUCE", "SIDE"};
        int currentCategoryIndex = 0;

        while (currentCategoryIndex < toppingGroups.length) {
            String category = toppingGroups[currentCategoryIndex];
            System.out.println("\n--- " + category + " TOPPINGS ---");

            String chosen = selectFromList("Choose " + category + " (0 to skip, B to go back)",
                    Topping.options.get(category));

            if (chosen == null) {
                // Skip category
                System.out.println("⏩ " + category + " category skipped");
                currentCategoryIndex++;
            } else if (chosen.equals("BACK")) {
                // Handle back navigation
                if (currentCategoryIndex > 0) {
                    System.out.println("↩️ Returning to previous category");
                    currentCategoryIndex--; // Go to previous category
                } else {
                    // At first category, go back to size selection
                    System.out.println("↩️ Returning to size selection");
                    return addSandwich(); // Restart from bread selection
                }
            } else {
                // Valid selection
                toppings.add(new Topping(category, chosen));
                System.out.println("✅ Added: " + chosen);

                // Ask if they want another from same category
                System.out.print("Add another " + category + " topping? (yes/no): ");
                String another = scanner.nextLine().trim().toLowerCase();
                if (!another.startsWith("y")) {
                    currentCategoryIndex++;
                }
            }
        }

        // 4. Toasting option
        System.out.println("\n TOASTING OPTION");
        boolean toasted = false;
        System.out.print("Would you like it toasted? (yes/no/B to go back): ");
        String toast = scanner.nextLine().trim().toLowerCase();

        if (toast.equalsIgnoreCase("b")) {
            System.out.println("↩️ Returning to toppings selection");
            // Return to last topping category
            return addSandwich(); // Restart from bread selection
        }

        toasted = toast.startsWith("y");
        System.out.println("✅ " + (toasted ? "Toasted" : "Not toasted"));

        return new Sandwich(size, bread, toppings, toasted);
    }
    public Drink addDrink() {

        System.out.println("\n=*=*=*=*=*=*=*=*= Add a Drink =*=*=*=*=*=*=*=*=*=*=");
        String size = null;
        while (true) {
            System.out.println("Choose size: \nSmall  \nMedium  \nLarge:");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("0"))
                return null;

            switch (choice) {
                case "S" -> {
                    size = "SMALL";
                }
                case "M" -> {
                    size = "MEDIUM";
                }
                case "L" -> {
                    size = "LARGE";
                }
                default -> {
                    System.out.println("❌ Invalid entry; please enter S, M, L, or 0.");
                    continue;
                }
            }
            break;
        }

        List<String> flavours = Drink.drinks.get(size);
        String flavour = selectFromList(size + " .Drink Options", flavours);
        if (flavour == null || flavour.equals("BACK")) {
            System.out.println(".Drink skipped.");
            return null;
        }

        return new Drink(size, flavour);
    }

    public Chips addChips() {
        System.out.println("\n=*=*=*=*=*=*=*=*=*= Add Chips *=*=*=*=*=*=*=*=*=*=*=*=*=*=");

        String flavour = selectFromList(".Chips options", Chips.chipsOptions);
        if ("BACK".equals(flavour) || flavour == null) {
            System.out.println(".Chips skipped.");
            return null;
        }
        return new Chips(flavour);
    }

    public Sandwich special() {
        System.out.println("Choose a sandwich: ");
        System.out.println("=*=*=*=*=*=*=*=*=*== Special Sandwiches =*=*=*=*=*=*=*=*=* 1- BLT\n2- Philly Cheese Steak\n3- Spicy Romance\n0- Cancel");
        String choice = scanner.nextLine().trim();
        SignatureSandwich selected = null;
        switch (choice) {
            case "1" -> selected = SignatureSandwich.BLT();
            case "2" -> selected = SignatureSandwich.PhillyCheeseSteak();
            case "3" -> selected = SignatureSandwich.SpicyRomance();
            default -> {
                System.out.println("=*=*=*=*=*= Return to Order menu...");
                return null;
            }
        }
        System.out.println("Selected: " + selected);

        //REMOVE topping
        List<Topping> current = selected.getMutableToppings();
        System.out.println("Would you like to remove any toppings? (Yes/No): ");
        String remove = scanner.nextLine().trim().toLowerCase();
        //prompt("Would you like to remove any toppings? (y/n): ").toLowerCase();
        if (remove.equals("y")) {
            for (int i = 0; i < current.size(); i++) {
                Topping topping = current.get(i);
                System.out.printf("%d) Remove %s? (Yes/No): ", i + 1, topping.getName());
                String resp = scanner.nextLine().trim().toLowerCase();
                if (resp.startsWith("y")) {
                    current.set(i, null);
                }
            }
            current.removeIf(Objects::isNull);
        } else {
            System.out.println("Keeping all toppings.");
        }

        //asks if user want to add extra topping
        System.out.println("Would you like to add extra toppings? (Yes/No): ");
        String addMore = scanner.nextLine().trim().toLowerCase();
        if (addMore.equals("y")) {
            System.out.println("Add extra toppings press 0 to skip a category):");
            String[] categories = {"MEAT", "EXTRA MEAT", "CHEESE", "EXTRA CHEESE", "REGULAR", "SAUCE", "SIDE"};
            int input = 0;
            while (input < categories.length) {
                String category = categories[input];
                String chosen = selectFromList(category, Topping.options.get(category));

                if ("BACK".equals(chosen)) {
                    // step back one category
                    if (input > 0) {
                        input--;
                    }
                    continue;
                }
                if (chosen == null) {
                    // skip this category
                    input++;
                    continue;
                }
                current.add(new Topping(category, chosen));
                System.out.println("Added: " + chosen + " (" + category + ")");
                input++;
            }
        } else {
            System.out.println("No extra toppings added.");
        }
        // Ask for toasted
        System.out.println("Would you like it toasted? (yes/no): ");
        String toast = scanner.nextLine().trim().toLowerCase();
        boolean toasted = toast.equals("yes") || toast.equals("y");

        List<Topping> defaultToppings = selected.getToppings();
        List<Topping> extrasOnly = new ArrayList<>(current);
        extrasOnly.removeAll(defaultToppings); // only keep added toppings

        return new SignatureSandwich(
                selected.getName(),
                selected.getSizeInches(),
                selected.getBreadType(),
                defaultToppings,
                toasted,
                extrasOnly
        );
    }

    private String selectFromList(String label, List<String> options) {
        System.out.printf("\nAvailable: %s\n", label);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ") " + options.get(i));
        }
        while (true) {
            System.out.println("Choose a number 1 – " + options.size() + ", 0 to skip, or B to back.");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("B")) return "BACK";
            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) return null;
                if (choice >= 1 && choice <= options.size()) {
                    return options.get(choice - 1);
                }
            } catch (NumberFormatException _) {
            }
            System.out.print("Invalid entry; please enter 1 – " + options.size() + ", 0 to skip, or B to back.");
        }
    }
}
