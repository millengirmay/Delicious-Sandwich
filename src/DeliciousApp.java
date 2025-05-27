import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeliciousApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Double> breadPrices = Map.of(
            "white", 5.50,
            "wheat", 5.50,
            "rye", 5.50,
            "wrap", 5.50
    );
    private static final Map<String, Double> sizeAdd = Map.of(
            "4", 0.0,
            "8", 1.50,
            "12", 3.00
    );
    private static final Map<String, Double> meats = Map.of(
            "steak", 1.00,
            "ham", 1.00,
            "salami", 1.00,
            "roast beef", 1.00,
            "chicken", 1.00,
            "bacon", 1.00
    );
    private static final Map<String, Double> cheeses = Map.of(
            "american", 0.75,
            "provolone", 0.75,
            "cheddar", 0.75,
            "swiss", 0.75
    );
    private static final List<String> regularToppings = List.of("lettuce", "peppers", "onions", "tomatos",
            "jalapenos", "cucumber", "pickles", "guacamole", "mushrooms");
    private static final List<String> sauces = List.of("mayo", "mustard", "ketchup", "ranch",
            "thousand island", "vinaigrette");
}
