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
            toppings.add(new Topping("bacon", 2.50, false));
            toppings.add(new Topping("bacon", 2.50, false))
        }
    }
}
