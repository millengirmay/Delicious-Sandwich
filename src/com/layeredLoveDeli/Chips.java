package com.layeredLoveDeli;

import java.util.List;

  //Represents a Chips item that can be added to a deli order.
  //Implements the ItemCost interface to provide pricing functionality.

public class Chips implements ItemCost {
    private final String Type;        // The type/flavor of chips chosen by the user
    private static  final double price = 1.50;   // Fixed price for any chips item

    // Constructs a Chips object with the given flavor.
    // The flavor is converted to uppercase for uniformity.
    public Chips(String flavour) {
        this.Type = flavour.toUpperCase();
    }

    //List of available chip flavor options
    public static final List<String> chipsOptions = List.of("Sweet Potato", "PopChips", "Kettle Brand", "Classic French");
    @Override
    public double getPrice() {
        return price;
    }
    public String getType(){
        return Type;
    }
    @Override
    public String toString(){
        return Type + " .Chips";
    }
}
