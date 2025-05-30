package com.layeredLoveDeli;

import java.util.ArrayList;
import java.util.List;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
        private final List<ItemCost> items = new ArrayList<>();
        private static final double taxRate = 0.1025; // 10.25% tax
        private boolean bagRequested = false;
        private static final double bagFee = 0.08;
        private double tipAmount = 0.0;
        private boolean tipApplied = false;

        public void requestBag() {
            this.bagRequested = true;
        }

        public void addItem(ItemCost item) {
            if (item == null) {
                throw new IllegalArgumentException("Can't add null item");
            }
            items.add(item);
            System.out.println("Added: " + item);
        }

        public double getTotal() {
            double total = 0.0;
            for (ItemCost item : items) {
                total += item.getPrice();
            }
            return total;
        }

        public void checkout() {
            System.out.println("\n=*=*=*=*=*=*=*=*=*= Order Summary =*=*=*=*=*=*=*=*=");
            double subtotal = 0.0;
            StringBuilder sb = new StringBuilder();
            sb.append("Layered Love Deli Receipt\n");
            String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd - HHmmss"));
            sb.append("Time: ").append(time).append("\n");

            for (ItemCost item : items) {
                if (item instanceof SignatureSandwich special) {
                    // print base only
                    double extraSum = 0;
                    for (Topping t : special.getExtraToppings()) {
                        extraSum += t.getPrice(special.getSizeInches());
                    }
                    double basePrice = special.getPrice() - extraSum;
                    System.out.printf("%s $%.2f\n", special, basePrice);
                    sb.append(String.format("%s $%.2f\n", special, basePrice));
                    subtotal += basePrice;

                    // lists each extra and add its cost
                    if (special.getExtraToppings() != null && !special.getExtraToppings().isEmpty()) {
                        for (Topping topping : special.getExtraToppings()) {
                            double price = topping.getPrice(special.getSizeInches());
                            if (price > 0) {
                                System.out.printf("  + %-20s $%.2f\n", topping.getName(), price);
                                sb.append(String.format("  + %-20s $%.2f\n", topping.getName(), price));
                                subtotal += price;
                            }
                        }
                    }

                } else if (item instanceof Sandwich sandwich) {
                    System.out.printf("%s $%.2f\n", sandwich, sandwich.getPrice());
                    sb.append(String.format("%s $%.2f\n", sandwich, sandwich.getPrice()));
                    subtotal += sandwich.getPrice();

                    double breadPrice = sandwich.getBaseBreadPrice();
                    System.out.printf("Bread type: %-9s $%.2f\n",
                            sandwich.getBreadType().toUpperCase(), breadPrice);
                    sb.append(String.format("Bread type: %-9s $%.2f\n",
                            sandwich.getBreadType().toUpperCase(), breadPrice));

                    for (Topping topping : sandwich.getToppings()) {
                        double price = topping.getPrice(sandwich.getSizeInches());
                        String label = topping.getName();
                        if (topping.getCategory().equalsIgnoreCase("EXTRA MEAT")
                                || topping.getCategory().equalsIgnoreCase("EXTRA CHEESE")) {
                            label = "EXTRA " + label;
                        }
                        System.out.printf("%-20s  $%.2f\n", label, price);
                        sb.append(String.format("%-20s  $%.2f\n", label, price));
                    }

                } else {
                    String name = item.toString();
                    System.out.printf("%-21s $%.2f\n", name, item.getPrice());
                    sb.append(String.format("%-21s $%.2f\n", name, item.getPrice()));
                    subtotal += item.getPrice();
                }
            }
            if (bagRequested) {
                System.out.printf("%-21s $%.2f\n", "Bag", bagFee);
                sb.append(String.format("%-21s $%.2f\n", "Bag", bagFee));
                subtotal += bagFee;
            }
            System.out.printf("Subtotal: $%.2f\n", subtotal);
            sb.append(String.format("%-30s $%.2f\n", "Subtotal:", subtotal));

                // Tip
            if (tipApplied) {
                System.out.printf("Tip: $%.2f\n", tipAmount);
                sb.append(String.format("%-30s $%.2f\n", "Tip:", tipAmount));
                subtotal += tipAmount;
            }

            // Tax
            double tax = subtotal * taxRate;
            System.out.printf("Tax (%.2f%%): $%.2f\n", taxRate * 100, tax);
            sb.append(String.format("%-30s $%.2f\n",
                    String.format("Tax (%.2f%%):", taxRate * 100), tax));

            double total = subtotal + tax;
            System.out.printf("Total: $%.2f\n", total);
            sb.append(String.format("Total: $%.2f\n", total));

            Path receiptsDir = Paths.get("receipts");
            try {
                Files.createDirectories(receiptsDir);
                Path receiptFile = receiptsDir.resolve(time + ".txt");
                Files.writeString(receiptFile, sb.toString(), StandardOpenOption.CREATE_NEW);
                System.out.println("Receipt saved to " + receiptFile);
            } catch (IOException e) {
                System.err.println("Failed to save receipt: " + e.getMessage());
            }

        }
        public void addTip(double tip) {
            if (tip < 0) return;
            this.tipAmount = tip;
            this.tipApplied = true;
        }

    }



