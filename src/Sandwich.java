import java.util.List;

public class Sandwich implements MenuItem{
    private String size;
    private Bread bread;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, Bread bread, List<Topping> toppings, boolean toasted){
        this.size = size;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
    }

    public String getName(){
        return size + " Sandwich on " + bread.getName()
+ (toasted ? "(Toasted)": "");
    }

    public double getPrice(){
        double toppingTotal = toppings.stream().mapToDouble(MenuItem::getPrice).sum();
        return bread.getPrice() + toppingTotal;
    }

    public String getDetails(){
        StringBuilder sb = new StringBuilder();

    }
}
