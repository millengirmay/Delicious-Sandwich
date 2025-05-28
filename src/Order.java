import java.util.ArrayList;
import java.util.List;

public class Order {
    // Package and imports
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Drink> drinks = new ArrayList<>();
    private final List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
    }

    public void addDrink(Drink d) {
        drinks.add(d);
    }

    public void addChips(Chips c) {
        chips.add(c);
    }

    public double calculateTotal() {
        return sandwiches.stream().mapToDouble(Sandwich::calculatePrice).sum()
                + drinks.stream().mapToDouble(Drink::getPrice).sum()
                + chips.stream().mapToDouble(Chips::getPrice).sum();
    }

    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder("Order Summary:\n\n");
        sandwiches.forEach(s -> sb.append(s).append("\n"));
        drinks.forEach(d -> sb.append(d).append("\n"));
        chips.forEach(c -> sb.append(c).append("\n"));
        sb.append(String.format("\nTotal Order Cost: $%.2f\n", calculateTotal()));
        return sb.toString();
    }
}


