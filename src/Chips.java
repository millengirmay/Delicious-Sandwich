import java.util.List;

public class Chips implements ItemCost {
    private final String flavour;
    private static  final double price = 1.50;

    public Chips(String flavour) {
        this.flavour = flavour.toUpperCase();
    }

    //Chips flavour
    public static final List<String> chipsOptions = List.of("Sweet Potato", "PopChips", "Kettle Brand", "Classic French");
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
