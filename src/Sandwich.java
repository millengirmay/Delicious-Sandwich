import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sandwich {
    String size;
    String bread;
    boolean toasted;
    List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getBasePrice() {
        return switch (size) {
            case Size.Four -> 5.50;
            case Size.Eight -> 7.00;
            case Size.Twelve -> 8.50;
            default -> 0.0;
        };
    }

    public double calculatePrice() {
        Map<String, Long> countMap = toppings.stream()
                .collect(Collectors.groupingBy(Topping::getName, Collectors.counting()));

        return getBasePrice() + toppings.stream()
                .mapToDouble(t -> t.getPrice(size, countMap.get(t.getName()) > 1))
                .sum();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" ").append(bread).append(" sandwich ");
        if (toasted) sb.append("Toasted ");
        toppings.forEach(t -> sb.append(" - ").append(t.getName()).append(" "));
                        sb.append(String.format("Subtotal: $%.2f ", calculatePrice()));
        return sb.toString();
    }
}