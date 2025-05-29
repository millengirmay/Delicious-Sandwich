import java.util.List;

public class Chips implements PricedItem {
    private final String flavour;
    private static  final double price = 1.50;

    public Chips(String flavour) {
        this.flavour = flavour.toUpperCase();
    }

    //Chips flavour
    public static final List<String> chipsOption = List.of("BBQ", "Sour Cream", "Salt & Vinegar", "Jalapeño", "Lays Classic");
    @Override
    public double getPrice() {
        return price;
    }
    public String getFlavour(){
        return flavour;
    }
    @Override
    public String toString(){
        return flavour + " Chips";
    }
}
