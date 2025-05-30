package com.layeredLoveDeli;

import java.util.List;

public class Chips implements ItemCost {
    private final String Type;
    private static  final double price = 1.50;

    public Chips(String flavour) {
        this.Type = flavour.toUpperCase();
    }

    //Available chips flavors
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
