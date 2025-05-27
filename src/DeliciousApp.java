import java.util.ArrayList;
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

    public static void main(String[] args) {
        while(true){
            //System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-\uD83E\uDD6A Welcome to Delicious sandwich *-*-*-*-*-*-*-*-*");
            System.out.println("   ┌──────────────────────────────────────────────┐");
            System.out.println("   🥪  Welcome to DELI-cious Sandwich Builder!");
            System.out.println("   🌯  Custom flavors made fresh just for you!");
            System.out.println("   └──────────────────────────────────────────────┘");

            System.out.println("[1] New Order ");
            System.out.println("[0] Exit ");
            String choice = scanner.nextLine();

            if(choice.equals("1")){
                takeOrder();
            }else if(choice.equals("0")){
                break;
            }
        }
    }

    private static void takeOrder(){
        Order order = new Order();
        while(true){
            System.out.println("*-*-*-*-*-*-*-*-*\nOrder Menu *-*-*-*-*-*-*-*-*-");
            System.out.println("*-*-*-*-*-*-*-*-*[1] Add Sandwich *-*-*-*-*-*-*-*-*-");
            System.out.println("*-*-*-*-*-*-*-*-*[2] Add Drink *-*-*-*-*-*-*-*-*-");
            System.out.println("*-*-*-*-*-*-*-*-*[3] Add Chips *-*-*-*-*-*-*-*-*-");
            System.out.println("*-*-*-*-*-*-*-*-*[4] Checkout *-*-*-*-*-*-*-*-*-");
            System.out.println("*-*-*-*-*-*-*-*-*[0] cancel Order *-*-*-*-*-*-*-*-*-");
            String choice = scanner.nextLine();
            switch(choice){
                case "1":
                    order.addItem(createSandwich());
                    break;
                case"2":
                    order.addItem(createDrink());
                    break;
                case"3":
                    order.addItem(createChips());
                    break;
                case"4":
                    System.out.println(order.getSummary());
                    System.out.println("*-*-*-*-*-*-*[1] Confirm*-*-*-*-*-");
                    System.out.println("*-*-*-*-*-*-*[0] Cancel*-*-*-*-*-");
                    String confirm = scanner.nextLine();
                    if(confirm.equals("1")){
                        order.saveReceipt();
                        return;
                    }else{
                        return;
                    }
                case"0":
                    return;
            }
        }
    }

    private static Sandwich createSandwich(){
        System.out.println("select Bread: white, wheat, rye, wrap");
        String breadChoice = scanner.nextLine().toLowerCase();
        double basePrice = breadPrices.getOrDefault(breadChoice, 5.50);

        System.out.println("select Size (4,8,12)");
        String size = scanner.nextLine();
        double sizeAddPrice = sizeAdd.getOrDefault(size, 0.0);

        Bread bread = new Bread(breadChoice, basePrice + sizeAddPrice);

        List<Topping> toppings = new ArrayList<>();
        meats.forEach((k, v) -> {
            System.out.println("Add meat " + k + "? Yes/No");
            if(scanner.nextLine().equalsIgnoreCase("Yes")){
                System.out.println("Extra? Yes/No");
                boolean extra = scanner.nextLine().equalsIgnoreCase("Yes");
                toppings.add(new Topping(k, v+ sizeAddPrice, extra));
            }
        });

        cheeses.forEach((k, v) -> {
            System.out.println("Add cheese " + k + "? Yes/No");
            if(scanner.nextLine().equalsIgnoreCase("Yes")){
                System.out.println("Extra? Yes/No");
                boolean extra = scanner.nextLine().equalsIgnoreCase("Yes");
                toppings.add(new Topping(k,v + sizeAddPrice, extra));
            }
        });

        for(String sauce : sauces){
            System.out.println("Add sauce " + sauce + "? Yes/No");
            if(scanner.nextLine().equalsIgnoreCase("Yes")){
                toppings.add(new Topping(sauce, 0.0, false));
            }
        }
        System.out.println("Toasted? Yes/No");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("Yes");

        return new Sandwich(size + "\"", bread, toppings, toasted);
    }

    private static Drink createDrink(){
        System.out.println("Select size: small, Medium, Large");
        String size = scanner.nextLine();
        double price = switch (size.toLowerCase()){
            case"medium" -> 2.50;
            case"large" -> 3.00;
            default -> 2.00;
        };
        System.out.println("Enter Flavor:");
        String flavor = scanner.nextLine();
        return new Drink(size, price, flavor);
    }

    private static Chips createChips(){
        System.out.println("Enter chip Type:");
        String type = scanner.nextLine();
        return new Chips(type);
    }

}
