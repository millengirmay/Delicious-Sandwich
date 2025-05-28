import java.util.ArrayList;
import java.util.List;

public class SignatureSandwich extends Sandwich{
    public SignatureSandwich(String name){
        super("8\"",
                new Bread("white", 7.00),
                createToppings(name),
                true);
    }

    private static List<Topping> createToppings(String name){
        List<Topping> toppings = new ArrayList<>();
        if(name.equalsIgnoreCase("blt")){
            toppings.add(new Topping("bacon", 2.50, false));
            toppings.add(new Topping("cheddar", 1.25, false));
            toppings.add(new Topping("lettuce", 0.0, false));
            toppings.add(new Topping("tomato", 0.0, false));
            toppings.add(new Topping("ranch", 0.0, false));
        } else if (name.equalsIgnoreCase("philly")){
            toppings.add(new Topping("steak", 2.50, false))
            toppings.add(new Topping("steak", 2.50, false))
            toppings.add(new Topping("steak", 2.50, false))
            toppings.add(new Topping("steak", 2.50, false))

        }
    }
}
